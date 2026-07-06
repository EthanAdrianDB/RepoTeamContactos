package mx.edu.utez.integradora_poo_2026.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.integradora_poo_2026.model.Contacto;
import mx.edu.utez.integradora_poo_2026.model.dao.ContactoDao;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactoServlet", value = "/contacto")
public class ContactoServlet extends HttpServlet {

    private final ContactoDao contactoDao = new ContactoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contacto> lista = contactoDao.getAll();

        request.setAttribute("listaContacto", lista);
        request.getRequestDispatcher("gestion-contacto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTAMOS EN EL SERVLET");
        request.setCharacterEncoding("UTF-8");
        try {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            String telefono_alternativo = request.getParameter("telefono_alternativo");
            String correo_electronico = request.getParameter("correo_electronico");
            String red_social = request.getParameter("red_social");

            Contacto nuevaContacto = new Contacto();
            nuevaContacto.setNombres(nombres);
            nuevaContacto.setApellidos(apellidos);
            nuevaContacto.setTelefono(telefono);
            nuevaContacto.setTelefono_alternativo(telefono_alternativo);
            nuevaContacto.setCorreo_electronico(correo_electronico);
            nuevaContacto.setRed_social(red_social);

            System.out.println(correo_electronico);

            contactoDao.create(nuevaContacto);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("contacto");
    }
}
