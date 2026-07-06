package mx.edu.utez.integradora_poo_2026.model;

public class Contacto {
    private int id;
    private String nombre;
    private String apellidos;
    private int telefono;
    private int telefono_alternativo;
    private String correo;
    private String red_social;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String apellidos, int Telefono, int telefono_alternativo, String correo, String red_social) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = Telefono;
        this.telefono_alternativo = telefono_alternativo;
        this.correo = correo;
        this.red_social = red_social;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono_alternativo() {
        return telefono_alternativo;
    }

    public void setTelefono_alternativo(int telefono_alternativo) {
        this.telefono_alternativo = telefono_alternativo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRed_social() {
        return red_social;
    }

    public void setRed_social(String red_social) {
        this.red_social = red_social;
    }

    @Override
    public String toString() {
        return id + ',' + nombre + ',' + apellidos + ',' + telefono
                + ',' + telefono_alternativo + ',' + correo + ',' + red_social;
    }
}
