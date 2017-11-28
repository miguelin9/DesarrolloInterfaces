package es.vcarmen.agenda;

/**
 * Created by matinal on 3/10/17.
 */

public class Contacto {
    private String nombre;
    private String apellidos;
    private String telefono;
    private boolean hombre = false;
    private boolean mujer = false;

    public Contacto(String nombre, String apellidos, String telefono, boolean hombre, boolean mujer) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.hombre = hombre;
        this.mujer = mujer;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isHombre() {
        return hombre;
    }

    public void setHombre(boolean hombre) {
        this.hombre = hombre;
    }

    public boolean isMujer() {
        return mujer;
    }

    public void setMujer(boolean mujer) {
        this.mujer = mujer;
    }
}
