/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.opensymphony.xwork2.ActionSupport;
import servicios.EmailAutomaticoJerseyClient;

/**
 *
 * @author josel
 */
public class contactar extends ActionSupport {

    private String nombre;
    private String correo;
    private String telefono;
    private String mensaje;

    public contactar() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String execute() throws Exception {
        EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
        client.enviarCorreo(String.class,
                "biblioupo44@gmail.com",
                "Petición de contacto",
                "Nombre: "+getNombre()+
                        "\nCorreo Electrónico: "+getCorreo()+
                        "\nTeléfono: "+getTelefono()+"\nMensaje: "+getMensaje());
        return SUCCESS;
    }

}
