/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.refuerzo;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Recurso;
import entidades.Refuerzo;
import entidades.Sala;
import entidades.Usuario;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.GenericType;
import servicios.RecursoJerseyClient;
import servicios.RefuerzoJerseyClient;
import servicios.SalaJerseyClient;
import servicios.UsuarioJerseyClient;

/**
 *
 * @author Jose
 */
public class gestionRefuerzo extends ActionSupport{

    private String operacion;
    
    private RefuerzoJerseyClient refuerzoClient = new RefuerzoJerseyClient();
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private SalaJerseyClient salaClient = new SalaJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();
    
    private Refuerzo refuerzo;

    private String id;
    private String descripcion;
    private String asignatura;
    private String tipo;
    private Recurso recurso;
    private Usuario usuario;
    private Sala sala;
    
    private String idRecurso;
    private String dniUsuario;
    private String nombreSala;
    private String idRefuerzo;

    private List<Refuerzo> refuerzos;
    private List<Usuario> usuarios;
    private List<Sala> salas;


    public gestionRefuerzo() {
    }

    public String getOperacion() {
        return operacion;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
    }

    public Refuerzo getRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(Refuerzo refuerzo) {
        this.refuerzo = refuerzo;
    }

    public String getIdRefuerzo() {
        return idRefuerzo;
    }

    public void setIdRefuerzo(String idRefuerzo) {
        this.idRefuerzo = idRefuerzo;
    }
    
    

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public List<Refuerzo> getRefuerzos() {
        return refuerzos;
    }

    public void setRefuerzos(List<Refuerzo> refuerzos) {
        this.refuerzos = refuerzos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public RefuerzoJerseyClient getRefuerzoClient() {
        return refuerzoClient;
    }

    public void setRefuerzoClient(RefuerzoJerseyClient refuerzoClient) {
        this.refuerzoClient = refuerzoClient;
    }

    public UsuarioJerseyClient getUsuarioClient() {
        return usuarioClient;
    }

    public void setUsuarioClient(UsuarioJerseyClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public SalaJerseyClient getSalaClient() {
        return salaClient;
    }

    public void setSalaClient(SalaJerseyClient salaClient) {
        this.salaClient = salaClient;
    }

    public String execute() throws Exception {
        salas = Arrays.asList(salaClient.findAll_XML(Sala[].class));
        usuarios = Arrays.asList(usuarioClient.findAll_XML(Usuario[].class));
        refuerzo = refuerzoClient.find_XML(Refuerzo.class, getId());
        return operacion;
    }
    
    public String alta() throws ParseException {
        
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);
        
        refuerzoClient.create_XML("<refuerzo>"
            + "<id>"+getId()+"</id>"
            + "<descripcion>"+getDescripcion()+"</descripcion>"    
            + "<asignatura>"+getAsignatura()+"</asignatura>"  
            + "<tipo>"+getTipo()+"</tipo>" 
            + "<idRecurso>"
            + "<id>"+r[r.length-1].getId()+"</id>"   
            +"</idRecurso>"
            + "<dniUsuario>"
            + "<dni>"+getDniUsuario()+"</dni>"   
            +"</dniUsuario>"
            + "<nombreSala>"
            + "<nombre>"+getNombreSala()+"</nombre>"   
            +"</nombreSala>" 
            + "</refuerzo>"
        );
        
        refuerzos = Arrays.asList(refuerzoClient.findAll_XML(Refuerzo[].class));
        
        return SUCCESS;
    }
    
    public String baja() {
        refuerzoClient.remove(getId());
        
        refuerzos = (List<Refuerzo>)refuerzoClient.findAll_XML(gtr.getClass());
        
        return SUCCESS;
    }

    public String consultar() {
        refuerzo = refuerzoClient.find_XML(Refuerzo.class, getId());
        return SUCCESS;
    }
    
    public String modificar() throws ParseException {
        refuerzoClient.edit_XML("<refuerzo>"
            + "<id>"+getId()+"</id>"
            + "<descripcion>"+getDescripcion()+"</descripcion>"    
            + "<asignatura>"+getAsignatura()+"</asignatura>"  
            + "<tipo>"+getTipo()+"</tipo>" 
            + "<idRecurso>"
            + "<id>"+getIdRecurso()+"</id>"   
            +"</idRecurso>"
            + "<dniUsuario>"
            + "<dni>"+getDniUsuario()+"</dni>"   
            +"</dniUsuario>"
            + "<nombreSala>"
            + "<nombre>"+getNombreSala()+"</nombre>"   
            +"</nombreSala>" 
            + "</refuerzo>", getIdRefuerzo());
        
        refuerzos = Arrays.asList(refuerzoClient.findAll_XML(Refuerzo[].class));
        return SUCCESS;
    }
}
