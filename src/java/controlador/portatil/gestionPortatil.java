/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.portatil;

import DAO.PortatilDAO;
import DAO.RecursoDAO;
import DAO.SistemaOperativoDAO;
import static com.opensymphony.xwork2.Action.*;
import java.text.ParseException;
import java.util.List;
import modelo.Portatil;
import modelo.Recurso;
import modelo.SistemaOperativo;

/**
 *
 * @author Jose
 */
public class gestionPortatil {

    private String operacion;

    private PortatilDAO portatilDAO = new PortatilDAO();
    private SistemaOperativoDAO sistemaOperativoDAO = new SistemaOperativoDAO();
    private RecursoDAO recursoDAO = new RecursoDAO();

    private String numSerie;
    private Recurso recurso;
    private SistemaOperativo sistemaOperativo;
    private String marca;
    private String modelo;
    
    private int idSistemaOperativo;

    private Portatil portatil;
    private List<Portatil> portatiles;

    public gestionPortatil() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public PortatilDAO getPortatilDAO() {
        return portatilDAO;
    }

    public void setPortatilDAO(PortatilDAO portatilDAO) {
        this.portatilDAO = portatilDAO;
    }

    public SistemaOperativoDAO getSistemaOperativoDAO() {
        return sistemaOperativoDAO;
    }

    public void setSistemaOperativoDAO(SistemaOperativoDAO sistemaOperativoDAO) {
        this.sistemaOperativoDAO = sistemaOperativoDAO;
    }

    public RecursoDAO getRecursoDAO() {
        return recursoDAO;
    }

    public void setRecursoDAO(RecursoDAO recursoDAO) {
        this.recursoDAO = recursoDAO;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public SistemaOperativo getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Portatil getPortatil() {
        return portatil;
    }

    public void setPortatil(Portatil portatil) {
        this.portatil = portatil;
    }

    public List<Portatil> getPortatiles() {
        return portatiles;
    }

    public void setPortatiles(List<Portatil> portatiles) {
        this.portatiles = portatiles;
    }

    public int getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(int idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    public String execute() throws Exception {
        if (getNumSerie() != null) {
            portatilDAO = new PortatilDAO();
            portatil = portatilDAO.read(getNumSerie());
        }
        return operacion;
    }

    public String alta() throws ParseException {
        
        Recurso r = new Recurso(true);
        recursoDAO.create(r);
        
        portatil = new Portatil(getNumSerie(), r, sistemaOperativoDAO.readId(getIdSistemaOperativo()), getMarca(), getModelo());
        portatilDAO.create(portatil);
        
        portatiles = portatilDAO.list();
        
        return SUCCESS;
    }

    public String baja() {
        if (getNumSerie()!= null) {
            portatil = portatilDAO.read(getNumSerie());
            portatilDAO.delete(portatil);
            
            portatiles = portatilDAO.list();
            
            return SUCCESS;
        }
        return ERROR;
    }

    public String consultar() {
        portatil = portatilDAO.read(getNumSerie());
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        if (getNumSerie() != null) {
            portatil = portatilDAO.read(getNumSerie());
            portatil.setMarca(getMarca());
            portatil.setModelo(getModelo());
            portatil.setRecurso(getRecurso());
            
            portatil.setSistemaOperativo(sistemaOperativoDAO.readId(getIdSistemaOperativo()));
            
            portatilDAO.update(portatil);
            portatiles = portatilDAO.list();
            
            return SUCCESS;
        }
        return ERROR;
    }
}
