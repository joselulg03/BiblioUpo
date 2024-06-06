/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ordenador;

import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import servicios.*;
import entidades.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author manue
 */
public class gestionOrdenador extends ActionSupport {

    private String operacion;
        private String nom;


    private OrdenadorJerseyClient ordenadorClient = new OrdenadorJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();

    private String nombre;

    private Ordenador ordenador;
    private List<Ordenador> ordenadores;

    public gestionOrdenador() {
    }

    public OrdenadorJerseyClient getOrdenadorClient() {
        return ordenadorClient;
    }

    public void setOrdenadorClient(OrdenadorJerseyClient ordenadorClient) {
        this.ordenadorClient = ordenadorClient;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
    }

    public List<Ordenador> getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(List<Ordenador> Ordenadores) {
        this.ordenadores = Ordenadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ordenador getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(Ordenador ordenador) {
        this.ordenador = ordenador;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**/
    public String execute() throws Exception {

        ordenador = ordenadorClient.find_XML(Ordenador.class, getNombre());
        return operacion;
    }

    public String alta() throws ParseException {
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);

        ordenadorClient.create_XML("<ordenador>"
                + "<idRecurso>"
                + "<id>" + r[r.length - 1].getId() + "</id>"
                + "</idRecurso>"
                + "<nombre>" + getNombre() + "</nombre>"
                + "</ordenador>");

        ordenadores = Arrays.asList(ordenadorClient.findAll_XML(Ordenador[].class));

        return SUCCESS;
    }

    public String consultar() {
        ordenador = ordenadorClient.find_XML(Ordenador.class, getNombre());
        return SUCCESS;
    }

    public String baja() {
        if (getNombre() != null) {
            ordenadorClient.remove(getNombre());
            ordenadores = Arrays.asList(ordenadorClient.findAll_XML(Ordenador[].class));

            return SUCCESS;
        }
        return ERROR;
    }

    public String modificar() throws ParseException {
        if (getNom() != null) {
            ordenadorClient.edit_XML("<ordenador>"
                    + "<nombre>" + getNombre() + "</nombre>"
                    + "</ordenador>",getNom());

            ordenadores = Arrays.asList(ordenadorClient.findAll_XML(Ordenador[].class));

            return SUCCESS;
        }
        return ERROR;
    }

}
