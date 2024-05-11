/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.LibroDAO;
import DAO.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Libro;
import modelo.Usuario;

/**
 *
 * @author josel
 */
public class gestion extends ActionSupport {
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private LibroDAO libroDAO = new LibroDAO();
    
    private String entidad;
    private String rol;
    
    private List<Usuario> usuarios;
    private List<Libro> libros;
    
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
    
    
    
    
    public String execute() throws Exception {
        if(entidad.equals("usuarios")){
            usuarios = usuarioDAO.list();
            //System.out.println("-- USUARIOS --");
        }
        else if(entidad.equals("libros")){
            libros = libroDAO.list();
        }
        return entidad;
    }
    
}
