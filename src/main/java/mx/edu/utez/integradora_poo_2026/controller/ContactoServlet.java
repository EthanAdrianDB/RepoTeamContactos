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
        request.setCharacterEncoding("UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            int telefono = Integer.parseInt(request.getParameter("Telefono"));
            String telefono_alternativo = request.getParameter("Telefono Alternativo");
            String correo = request.getParameter("correo");
            String red_social = request.getParameter("Red_Social");

            Contacto nuevaContacto = new Contacto();
            nuevaContacto.setNombre(nombre);
            nuevaContacto.setApellidos(apellidos);
            nuevaContacto.setTelefono(telefono);
            nuevaContacto.setTelefono_alternativo(telefono_alternativo);
            nuevaContacto.setCorreo(correo);
            nuevaContacto.setRed_social(red_social);

            contactoDao.create(nuevaContacto);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("contacto");
    }
}