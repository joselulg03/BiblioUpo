/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.libro;

import DAO.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import modelo.*;


/**
 *
 * @author josel
 */
public class gestionLibro extends ActionSupport {

    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private CategoriaDAO categoriaDAO;
    private IdiomaDAO idiomaDAO;
    private RecursoDAO recursoDAO;

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
    
    private String filtro;
    private String seleccion;
    private String operacion;

    private Libro libro;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Editorial> editoriales;
    private List<Categoria> categorias;
    private List<Idioma> idiomas;
    

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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public AutorDAO getAutorDAO() {
        return autorDAO;
    }

    public void setAutorDAO(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public EditorialDAO getEditorialDAO() {
        return editorialDAO;
    }

    public void setEditorialDAO(EditorialDAO editorialDAO) {
        this.editorialDAO = editorialDAO;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public IdiomaDAO getIdiomaDAO() {
        return idiomaDAO;
    }

    public void setIdiomaDAO(IdiomaDAO idiomaDAO) {
        this.idiomaDAO = idiomaDAO;
    }

    public RecursoDAO getRecursoDAO() {
        return recursoDAO;
    }

    public void setRecursoDAO(RecursoDAO recursoDAO) {
        this.recursoDAO = recursoDAO;
    }

    public List<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editorial> editoriales) {
        this.editoriales = editoriales;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }
    
    
    
    

    public String execute() throws Exception {
        
        if(operacion.equals("alta")){
            autorDAO = new AutorDAO();
            editorialDAO = new EditorialDAO();
            categoriaDAO = new CategoriaDAO();
            idiomaDAO = new IdiomaDAO();
            
            autores = autorDAO.list();
            editoriales = editorialDAO.list();
            categorias = categoriaDAO.list();
            idiomas = idiomaDAO.list();
        }
        
        return operacion;
    }

    public String filtrar() {
        if(seleccion != null){
            libroDAO = new LibroDAO();
            if(seleccion.equals("Titulo")){
                libro = libroDAO.readTitulo(filtro);
                if(libro == null){
                    return ERROR;
                }
            }
            else if(seleccion.equals("Autor")){
                AutorDAO autorDAO = new AutorDAO();
                autor = autorDAO.read(filtro);
            }
        }
        return SUCCESS;
    }

}
