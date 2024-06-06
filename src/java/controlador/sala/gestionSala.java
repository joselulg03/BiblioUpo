/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.sala;

import DAO.SalaDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.List;
import modelo.Sala;

/**
 *
 * @author manue
 */
public class gestionSala extends ActionSupport {

    private String operacion;

    private SalaDAO salaDAO;

    private String nombre;
    private int aforo;

    private Sala sala;
    private List<Sala> salas;

    public gestionSala() {
    }

    public SalaDAO getSalaDAO() {
        return salaDAO;
    }

    public void setSalaDAO(SalaDAO salaDAO) {
        this.salaDAO = salaDAO;
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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String execute() throws Exception {
        if (getNombre()!= null) {
            salaDAO = new SalaDAO();
            sala = salaDAO.read(getNombre());
        }
        return operacion;
    }

    public String alta() throws ParseException {
       // salaDAO = new SalaDAO();
        
       // salaDAO.create(new Sala(getNombre(), getAforo()));
      //  salas = salaDAO.list();

        return SUCCESS;
    }

    public String baja() {
        salaDAO = new SalaDAO();
        sala = salaDAO.read(getNombre());
        salaDAO.delete(sala);
        salas = salaDAO.list();
        
        return SUCCESS;
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

