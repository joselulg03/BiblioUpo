/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ordenador;

import DAO.OrdenadorDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.List;
import modelo.Ordenador;

/**
 *
 * @author manue
 */
public class gestionOrdenador extends ActionSupport {

    private String operacion;

    private OrdenadorDAO ordenadorDAO;

    private String nombre;

    private Ordenador ordenador;
    private List<Ordenador> ordenadores;

    public gestionOrdenador() {
    }

    public OrdenadorDAO getOrdenadorDAO() {
        return ordenadorDAO;
    }

    public void setOrdenadorDAO(OrdenadorDAO ordenadorDAO) {
        this.ordenadorDAO = ordenadorDAO;
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

    public List<Ordenador> getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(List<Ordenador> ordenadores) {
        this.ordenadores = ordenadores;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String execute() throws Exception {
        if (getNombre()!= null) {
            ordenadorDAO = new OrdenadorDAO();
            ordenador = ordenadorDAO.read(getNombre());
        }
        return operacion;
    }

    public String alta() throws ParseException {
       // ordenadorDAO = new OrdenadorDAO();
        
       // ordenadorDAO.create(new Ordenador(getNombre()));
      //  ordenadores = ordenadorDAO.list();

        return SUCCESS;
    }

    public String baja() {
        ordenadorDAO = new OrdenadorDAO();
        ordenador = ordenadorDAO.read(getNombre());
        ordenadorDAO.delete(ordenador);
        ordenadores = ordenadorDAO.list();
        
        return SUCCESS;
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

