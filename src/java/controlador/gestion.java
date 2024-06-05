package controlador;

import entidades.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.List;
import servicios.*;

public class gestion extends ActionSupport {
    
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private LibroJerseyClient libroClient = new LibroJerseyClient();
    private SalaJerseyClient salaClient = new SalaJerseyClient();
    private OrdenadorJerseyClient ordenadorClient = new OrdenadorJerseyClient();
    private PortatilJerseyClient portatilClient = new PortatilJerseyClient();
    
    private String entidad;
    private String rol;
    
    private Usuario[] usuarios;
    private List<Libro> libros;
    private Sala[] salas;
    private Ordenador[] ordenadores;
    private Portatil[] portatiles;
    
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

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    

    public Sala[] getSalas() {
        return salas;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public Ordenador[] getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(Ordenador[] ordenadores) {
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

    public PortatilJerseyClient getPortatilClient() {
        return portatilClient;
    }

    public void setPortatilClient(PortatilJerseyClient portatilClient) {
        this.portatilClient = portatilClient;
    }

    public Portatil[] getPortatiles() {
        return portatiles;
    }

    public void setPortatiles(Portatil[] portatiles) {
        this.portatiles = portatiles;
    }
    
    
    
    
    public String execute() throws Exception {
        if(entidad.equals("usuarios")){
            usuarios = usuarioClient.findAll_XML(Usuario[].class);
        }
        else if(entidad.equals("libros")){
            libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
        } else if(entidad.equals("salas")){
            salas = salaClient.findAll_XML(Sala[].class);
        } else if(entidad.equals("ordenadores")){
            ordenadores = ordenadorClient.findAll_XML(Ordenador[].class);
        }
        else if (entidad.equals("portatiles")) {
            portatiles = portatilClient.findAll_XML(Portatil[].class);
        }
        return entidad;
    }
    
}
