package mx.edu.utez.integradora_poo_2026.model.dao;

import mx.edu.utez.integradora_poo_2026.model.Contacto;
import mx.edu.utez.integradora_poo_2026.utils.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactoDao implements Dao<Contacto, Integer>{
    @Override
    public boolean create(Contacto entidad) {
        String sql = "INSERT INTO MASCOTAS(nombre, apellidos, telefono, telefono_alternativo, correo, red_social) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getTelefono());
            ps.setString(4, entidad.getTelefono_alternativo());
            ps.setString(5, entidad.getCorreo());
            ps.setString(6, entidad.getRed_social());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Contacto> getAll() {
        List<Contacto> datos = new ArrayList<>();
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM MASCOTAS");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contacto m = new Contacto();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setApellidos(rs.getString("apellidos"));
                m.setTelefono(rs.getInt("Telefono"));
                m.setTelefono_alternativo(rs.getString("Telefono Alternativo"));
                m.setCorreo(rs.getString("correo"));
                m.setRed_social(rs.getString("Red Social"));
                datos.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    @Override
    public Contacto getById(Integer id) {
        String sql = "SELECT * FROM MASCOTAS WHERE id = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Contacto m = new Contacto();
                    m.setId(rs.getInt("id"));
                    m.setNombre(rs.getString("nombre"));
                    m.setApellidos(rs.getString("apellidos"));
                    m.setTelefono(rs.getInt("Telefono"));
                    m.setTelefono_alternativo(rs.getString("Telefono Alternativo"));
                    m.setCorreo(rs.getString("correo"));
                    m.setRed_social(rs.getString("Red Social"));
                    return m;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Contacto entidad) {
        String sql = "UPDATE MASCOTAS SET nombre = ?, especie = ?, edad = ?, personalidad = ?, foto = ?, vacunada = ? WHERE id = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getTelefono());
            ps.setString(4, entidad.getTelefono_alternativo());
            ps.setString(5, entidad.getCorreo());
            ps.setString(6, entidad.getRed_social());
            ps.setInt(7, entidad.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM MASCOTAS WHERE id = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
