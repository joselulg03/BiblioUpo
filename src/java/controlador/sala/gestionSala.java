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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author manue
 */
public class gestionSala extends ActionSupport {

    private String operacion;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    private int filtro;

    private SalaJerseyClient salaClient = new SalaJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();

    private String nombre;
    private int aforo;

    private Sala sala;
    private List<Sala> salas;

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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
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

    public String execute() {

        sala = salaClient.find_XML(Sala.class, getNombre());
        return operacion;
    }

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

        salas = Arrays.asList(salaClient.findAll_XML(Sala[].class));

        return SUCCESS;
    }

    public String baja() {
        if (getNombre() != null) {
            salaClient.remove(getNombre());
            salas = Arrays.asList(salaClient.findAll_XML(Sala[].class));

            return SUCCESS;
        }
        return ERROR;
    }

    public String consulta() {
        sala = salaClient.find_XML(Sala.class, getNombre());
        return SUCCESS;
    }

    public String consultar() {
        if (filtro != 0) {
            salas = muestra(filtro);
            if (sala == null) {
                return ERROR;
            }
        }
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        if (getNom() != null) {
            salaClient.edit_XML("<sala>"
                    + "<aforo>" + getAforo() + "</aforo>"
                    + "<nombre>" + getNom()+ "</nombre>"
                    + "</sala>", getNombre());

            salas = Arrays.asList(salaClient.findAll_XML(Sala[].class));

            return SUCCESS;
        }
        return ERROR;
    }

    private List<Sala> muestra(int filtro) {
        salas = Arrays.asList(salaClient.findAll_XML(Sala[].class));
        List<Sala> sals = new ArrayList<>();
        for (Sala s : salas) {
            if (s.getAforo() == filtro) {
                sals.add(s);
            }
        }
        return sals;
    }
}
