/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.sala;

import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import servicios.*;
import entidades.*;

/**
 *
 * @author manue
 */
public class gestionSala extends ActionSupport {

    private String operacion;

    private SalaJerseyClient salaClient = new SalaJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();

    private String nombre;
    private int aforo;

    private Sala sala;
    private Sala[] salas;

    public gestionSala() {
    }

    public SalaJerseyClient getSalaClient() {
        return salaClient;
    }

    public void setSalaClient(SalaJerseyClient salaClient) {
        this.salaClient = salaClient;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /*
    public String execute() throws Exception {
        if (getNombre()!= null) {
            salaDAO = new SalaDAO();
            sala = salaDAO.read(getNombre());
        }
        return operacion;
    }*/

    public String alta() throws ParseException {
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);

        salaClient.create_XML("<sala>"
                + "<aforo>" + getAforo() + "</aforo>"
                + "<idRecurso>"
                + "<id>" + r[r.length - 1].getId() + "</id>"
                + "</idRecurso>"
                + "<nombre>" + getNombre() + "</nombre>"
                + "</sala>");

        salas = salaClient.findAll_XML(Sala[].class);

        return SUCCESS;
    }

    public String baja() {
        if (getNombre() != null) {
            salaClient.remove(getNombre());
            salas = salaClient.findAll_XML(Sala[].class);
            
            return SUCCESS;
        }
        return ERROR;
    }

    public String consultar() {
        salaDAO = new SalaDAO();
        sala = salaDAO.read(getNombre());
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        System.out.println("Sala :" + getNombre());

        salaDAO = new SalaDAO();
        sala = salaDAO.read(getNombre());

        sala.setNombre(getNombre());

        salas = salaDAO.list();
        return SUCCESS;
    }

}
