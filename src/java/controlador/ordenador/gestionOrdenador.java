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


/**
 *
 * @author manue
 */
public class gestionOrdenador extends ActionSupport {

    private String operacion;

    private OrdenadorJerseyClient ordenadorClient = new OrdenadorJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();

    
    private String nombre;

    private Ordenador ordenador;
    private Ordenador[] ordenadores;

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

    public Ordenador[] getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(Ordenador[] ordenadores) {
        this.ordenadores = ordenadores;
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

  

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
/*
    public String execute() throws Exception {
        if (getNombre()!= null) {
            ordenadorDAO = new OrdenadorDAO();
            ordenador = ordenadorDAO.read(getNombre());
        }
        return operacion;
    }
*/
    public String alta() throws ParseException {
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);
        
        ordenadorClient.create_XML("<ordenador>"
                + "<idRecurso>"
                + "<id>"+r[r.length-1].getId()+"</id>"
                + "</idRecurso>"
                + "<nombre>"+getNombre()+"</nombre>"
                + "</ordenador>");
        
        ordenadores = ordenadorClient.findAll_XML(Ordenador[].class);
        
        return SUCCESS;
    }

    public String baja() {
       if (getNombre()!= null) {
            ordenadorClient.remove(getNombre());
            ordenadores = ordenadorClient.findAll_XML(Ordenador[].class);
            
            return SUCCESS;
        }
        return ERROR;
    }

    public String consultar() {
        ordenadorDAO = new OrdenadorDAO();
        ordenador = ordenadorDAO.read(getNombre());
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        System.out.println("Ordenador :" + getNombre());

        ordenadorDAO = new OrdenadorDAO();
        ordenador = ordenadorDAO.read(getNombre());
        
        ordenador.setNombre(getNombre());
        
        ordenadores = ordenadorDAO.list();
        return SUCCESS;
    }

}

