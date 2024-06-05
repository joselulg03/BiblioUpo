/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.portatil;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.List;
import entidades.Portatil;
import entidades.Recurso;
import entidades.SistemaOperativo;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.ws.rs.core.GenericType;
import servicios.PortatilJerseyClient;
import servicios.RecursoJerseyClient;
import servicios.SistemaOperativoJerseyClient;

/**
 *
 * @author Jose
 */
public class gestionPortatil extends ActionSupport{

    private String operacion;

    private PortatilJerseyClient portatilClient = new PortatilJerseyClient();
    private SistemaOperativoJerseyClient sistemaOperativoClient = new SistemaOperativoJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();

    private String numSerie;
    private Recurso recurso;
    private SistemaOperativo sistemaOperativo;
    private String marca;
    private String modelo;
    
    private int idSistemaOperativo;

    private Portatil portatil;
    private List<Portatil> portatiles;
    private List<SistemaOperativo> sistemasOperativos;
    

    public gestionPortatil() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public PortatilJerseyClient getPortatilClient() {
        return portatilClient;
    }

    public void setPortatilClient(PortatilJerseyClient portatilClient) {
        this.portatilClient = portatilClient;
    }

    public SistemaOperativoJerseyClient getSistemaOperativoClient() {
        return sistemaOperativoClient;
    }

    public void setSistemaOperativoClient(SistemaOperativoJerseyClient sistemaOperativoClient) {
        this.sistemaOperativoClient = sistemaOperativoClient;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
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

    public int getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(int idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
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

    public List<SistemaOperativo> getSistemasOperativos() {
        return sistemasOperativos;
    }

    public void setSistemasOperativos(List<SistemaOperativo> sistemasOperativos) {
        this.sistemasOperativos = sistemasOperativos;
    }

    public String execute() throws Exception {

        sistemasOperativos = Arrays.asList(sistemaOperativoClient.findAll_XML(SistemaOperativo[].class));
        if (getNumSerie() != null) {
            portatil = portatilClient.find_XML(Portatil.class, getNumSerie());
        }
        return operacion;
    }

    public String alta() throws ParseException {
        
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);
        
        portatilClient.create_XML("<portatil>"
            + "<numSerie>"+getNumSerie()+"</numSerie>"
            + "<marca>"+getMarca()+"</marca>"
            + "<modelo>"+getModelo()+"</modelo>"    
            + "<id_sistema_operativo>"
            + "<id>"+getIdSistemaOperativo()+"</id>"
            +"</id_sistema_operativo>"  
            + "<id_recurso>"
            + "<id>"+r[r.length-1].getId()+"</id>"   
            +"</id_recurso>"        
            + "</portatil>"
        );
        
        portatiles = Arrays.asList(portatilClient.findAll_XML(Portatil[].class));
        
        return SUCCESS;
    }

    public String baja() {
        portatilClient.remove(getNumSerie());
        
        portatiles = Arrays.asList(portatilClient.findAll_XML(Portatil[].class));
        
        return SUCCESS;
    }

    public String consultar() {
        portatil = portatilClient.find_XML(Portatil.class, getNumSerie());
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        
        portatilClient.edit_XML("<portatil>"
            + "<numSerie>"+getNumSerie()+"</numSerie>"
            + "<marca>"+getMarca()+"</marca>"
            + "<modelo>"+getModelo()+"</modelo>"    
            + "<id_sistema_operativo>"
            + "<id>"+getIdSistemaOperativo()+"</id>"
            +"</id_sistema_operativo>"         
            + "</portatil>", getNumSerie());
        
        portatiles = Arrays.asList(portatilClient.findAll_XML(Portatil[].class));
        return SUCCESS;
    }
}
