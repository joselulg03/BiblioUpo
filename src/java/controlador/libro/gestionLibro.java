/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.libro;

import DAO.LibroDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Idioma;
import modelo.Libro;
import modelo.Recurso;

/**
 *
 * @author josel
 */
public class gestionLibro extends ActionSupport {
    
    private LibroDAO libroDAO;

    private String isbn;
     private Autor autor;
     private Categoria categoria;
     private Editorial editorial;
     private Idioma idioma;
     private Recurso recurso;
     private String titulo;
     private String descripcion;
     private Date fecha;
     private int cantidad;

    private Libro libro;
    private List<Libro> libros;
    
    public gestionLibro() {
    }

    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String filtrar(){
        return SUCCESS;
    }
    
}
