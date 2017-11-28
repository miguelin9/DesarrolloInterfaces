package es.vcarmen.bundleserializableparcelable;

import java.io.Serializable;

/**
 * Created by matinal on 17/10/17.
 */
// cualquier objeto que queramos salvar necesita implementar serializable para que java sepa guardarlo
public class Persona implements Serializable{
    private String nombre;
    private String apellidos;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    @Override
    public String toString() {
        return this.nombre + this.apellidos;
    }
}
