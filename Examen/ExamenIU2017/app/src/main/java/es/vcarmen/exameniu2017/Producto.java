package es.vcarmen.exameniu2017;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matinal on 12/12/17.
 */

public class Producto {

    private String titulo;
    private String descripcion;
    private String precio;
    private String categoria;
    private boolean foto;
    private Date fecha;

    public Producto(String titulo, String descripcion, String precio, String categoria, boolean foto, Date fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.foto = foto;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean getFoto() {
        return foto;
    }

    public void setFoto(boolean foto) {
        this.foto = foto;
    }

    public String getFecha() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        return format.format(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
