package mx.edu.utez.integradora_poo_2026.model;

public class Contacto {
    private int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String telefono_alternativo;
    private String correo_electronico;
    private String red_social;

    public Contacto() {
    }

    public Contacto(int id, String nombres, String apellidos, String telefono, String telefono_alternativo, String correo_electronico, String red_social) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefono_alternativo = telefono_alternativo;
        this.correo_electronico = correo_electronico;
        this.red_social = red_social;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_alternativo() {
        return telefono_alternativo;
    }

    public void setTelefono_alternativo(String telefono_alternativo) {
        this.telefono_alternativo = telefono_alternativo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo) {
        this.correo_electronico = correo;
    }

    public String getRed_social() {
        return red_social;
    }

    public void setRed_social(String red_social) {
        this.red_social = red_social;
    }

    @Override
    public String toString() {
        return id + ',' + nombres + ',' + apellidos + ',' + telefono
                + ',' + telefono_alternativo + ',' + correo_electronico + ',' + red_social;
    }
}
