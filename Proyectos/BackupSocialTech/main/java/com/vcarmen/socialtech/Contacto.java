package com.vcarmen.socialtech;

import java.io.Serializable;

/**
 * Created by miguel on 14/10/17.
 * implementamos Serializable para saveInstance
 */

public class Contacto implements Serializable{
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String formacion;
    private String provincia;
    private int edad;
    private boolean hombre;
    private boolean mujer;

    public Contacto(String nombre, String apellidos, String telefono, String email, String formacion, String provincia, int edad, boolean hombre, boolean mujer) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.formacion = formacion;
        this.provincia = provincia;
        this.edad = edad;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getSexo() {
        if (this.hombre == true && this.mujer == false) {
            return "Hombre";
        }
        if (this.hombre == false && this.mujer == true) {
            return "Mujer";
        }
        return "Desconocido";
    }
}
