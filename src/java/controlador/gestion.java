package controlador;

import entidades.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import servicios.JerseyClient;

public class gestion extends ActionSupport {
    
    private JerseyClient usuarioClient = new JerseyClient("usuario");
    private JerseyClient libroClient = new JerseyClient("libro");
    private JerseyClient salaClient = new JerseyClient("sala");
    private JerseyClient ordenadorClient = new JerseyClient("ordenador");
    
    private String entidad;
    private String rol;
    
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

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public SalaDAO getSalaDAO() {
        return salaDAO;
    }

    public void setSalaDAO(SalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    public OrdenadorDAO getOrdenadorDAO() {
        return ordenadorDAO;
    }

    public void setOrdenadorDAO(OrdenadorDAO ordenadorDAO) {
        this.ordenadorDAO = ordenadorDAO;
    }

    public List<Ordenador> getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(List<Ordenador> ordenadores) {
        this.ordenadores = ordenadores;
    }
    
    public String execute() throws Exception {
        if(entidad.equals("usuarios")){
            usuarios = usuarioDAO.list();
            //System.out.println("-- USUARIOS --");
        }
        else if(entidad.equals("libros")){
            libros = libroDAO.list();
        } else if(entidad.equals("salas")){
            salas = salaDAO.list();
        } else if(entidad.equals("ordenadores")){
            ordenadores = ordenadorDAO.list();
        }
        return entidad;
    }
    
}
