package controlador;

import entidades.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import servicios.*;

public class gestion extends ActionSupport {
    
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private LibroJerseyClient libroClient = new LibroJerseyClient();
    private SalaJerseyClient salaClient = new SalaJerseyClient();
    private OrdenadorJerseyClient ordenadorClient = new OrdenadorJerseyClient();
    
    private String entidad;
    private String rol;
    
    GenericType<List<Usuario>> gtu = new GenericType<List<Usuario>>(){};
    GenericType<List<Libro>> gtl = new GenericType<List<Libro>>(){};
    GenericType<List<Sala>> gts = new GenericType<List<Sala>>(){};
    GenericType<List<Ordenador>> gto = new GenericType<List<Ordenador>>(){};
    
    private List<Usuario> usuarios;
    private List<Libro> libros;
    private List<Sala> salas;
    private List<Ordenador> ordenadores;
    
    public gestion() {
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    public List<Ordenador> getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(List<Ordenador> ordenadores) {
        this.ordenadores = ordenadores;
    }

    public UsuarioJerseyClient getUsuarioClient() {
        return usuarioClient;
    }

    public void setUsuarioClient(UsuarioJerseyClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public LibroJerseyClient getLibroClient() {
        return libroClient;
    }

    public void setLibroClient(LibroJerseyClient libroClient) {
        this.libroClient = libroClient;
    }

    public SalaJerseyClient getSalaClient() {
        return salaClient;
    }

    public void setSalaClient(SalaJerseyClient salaClient) {
        this.salaClient = salaClient;
    }

    public OrdenadorJerseyClient getOrdenadorClient() {
        return ordenadorClient;
    }

    public void setOrdenadorClient(OrdenadorJerseyClient ordenadorClient) {
        this.ordenadorClient = ordenadorClient;
    }

    

    public GenericType<List<Usuario>> getGtu() {
        return gtu;
    }

    public void setGtu(GenericType<List<Usuario>> gtu) {
        this.gtu = gtu;
    }

    public GenericType<List<Libro>> getGtl() {
        return gtl;
    }

    public void setGtl(GenericType<List<Libro>> gtl) {
        this.gtl = gtl;
    }

    public GenericType<List<Sala>> getGts() {
        return gts;
    }

    public void setGts(GenericType<List<Sala>> gts) {
        this.gts = gts;
    }

    public GenericType<List<Ordenador>> getGto() {
        return gto;
    }

    public void setGto(GenericType<List<Ordenador>> gto) {
        this.gto = gto;
    }
    
    
    
    
    public String execute() throws Exception {
        if(entidad.equals("usuarios")){
            usuarios = (List<Usuario>)usuarioClient.findAll_XML(gtu.getClass());
        }
        else if(entidad.equals("libros")){
            libros = (List<Libro>)libroClient.findAll_XML(gtl.getClass());
        } else if(entidad.equals("salas")){
            salas = (List<Sala>)salaClient.findAll_XML(gts.getClass());
        } else if(entidad.equals("ordenadores")){
            ordenadores = (List<Ordenador>)ordenadorClient.findAll_XML(gto.getClass());
        }
        return entidad;
    }
    
}
