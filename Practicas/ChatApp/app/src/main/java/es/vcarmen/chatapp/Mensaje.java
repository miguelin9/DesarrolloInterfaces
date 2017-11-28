package es.vcarmen.chatapp;

/**
 * Created by matinal on 7/11/17.
 */

public class Mensaje {
    String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje() {}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
