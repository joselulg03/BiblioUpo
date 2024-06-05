/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.portatil;

import static com.opensymphony.xwork2.Action.*;
import java.text.ParseException;
import java.util.List;
import entidades.Portatil;
import entidades.Recurso;
import entidades.SistemaOperativo;
import entidades.Usuario;
import javax.ws.rs.core.GenericType;
import servicios.SistemaOperativoJerseyClient;

/**
 *
 * @author Jose
 */
public class gestionPortatil {

    private String operacion;

    private JerseyClient portatilClient = new JerseyClient("portatil");
    private SistemaOperativoJerseyClient sistemaOperativoClient = new JSistemaOperativoerseyClient();
    private JerseyClient recursoClient = new JerseyClient("recurso");

    private String numSerie;
    private Recurso recurso;
    private SistemaOperativo sistemaOperativo;
    private String marca;
    private String modelo;
    
    private int idSistemaOperativo;

    private Portatil portatil;
    private List<Portatil> portatiles;
    private List<SistemaOperativo> sistemasOperativos;
    
    GenericType<List<Portatil>> gtp = new GenericType<List<Portatil>>(){};
    GenericType<List<SistemaOperativo>> gtso = new GenericType<List<SistemaOperativo>>(){};


    public gestionPortatil() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public JerseyClient getPortatilClient() {
        return portatilClient;
    }

    public void setPortatilClient(JerseyClient portatilClient) {
        this.portatilClient = portatilClient;
    }

    public JerseyClient getSistemaOperativoClient() {
        return sistemaOperativoClient;
    }

    public void setSistemaOperativoClient(JerseyClient sistemaOperativoClient) {
        this.sistemaOperativoClient = sistemaOperativoClient;
    }

    public JerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(JerseyClient recursoClient) {
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

    public GenericType<List<Portatil>> getGtp() {
        return gtp;
    }

    public void setGtp(GenericType<List<Portatil>> gtp) {
        this.gtp = gtp;
    }

    public GenericType<List<SistemaOperativo>> getGtso() {
        return gtso;
    }

    public void setGtso(GenericType<List<SistemaOperativo>> gtso) {
        this.gtso = gtso;
    }

    public String execute() throws Exception {
        sistemasOperativos = (List<SistemaOperativo>)sistemaOperativoClient.findAll_XML(gtso.getClass());
        if (getNumSerie() != null) {
            portatil = portatilClient.find_XML(Portatil.class, getNumSerie());
        }
        return operacion;
    }

    public String alta() throws ParseException {
        
        Recurso r = recursoClient.find_XML(Recurso.class, "1");
        
        portatilClient.create_XML("<portatil>"
            + "<marca>"+getMarca()+"</marca>"
            + "<modelo>"+getModelo()+"</modelo>"    
            + "<id_sistema_operativo>"+getIdSistemaOperativo()+"</id_sistema_operativo>"  
            + "<id_recurso>"+r.getId()+"</id_recurso>"        
            + "</portatil>"
        );
        
        portatiles = (List<Portatil>)portatilClient.findAll_XML(gtp.getClass());
        
        return SUCCESS;
    }

    public String baja() {
        portatilClient.remove(numSerie);
        
        portatiles = (List<Portatil>)portatilClient.findAll_XML(gtp.getClass());
        
        return SUCCESS;
    }

    public String consultar() {
        portatil = portatilClient.find_XML(Portatil.class, numSerie);
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        portatil = portatilClient.find_XML(Portatil.class, numSerie);
        
        portatil.setIdSistemaOperativo(getIdSistemaOperativo());
        portatil.setMarca(getMarca());
        portatil.setModelo(modelo);
        
        portatiles = (List<Portatil>)portatilClient.findAll_XML(gtp.getClass());
        return SUCCESS;
    }
}
