package controlador.libro;

import DAO.*;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.*;

/**
 *
 * @author josel
 */
public class gestionLibro extends ActionSupport {

    private LibroDAO libroDAO = new LibroDAO();
    private AutorDAO autorDAO = new AutorDAO();
    private EditorialDAO editorialDAO = new EditorialDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private IdiomaDAO idiomaDAO = new IdiomaDAO();
    private RecursoDAO recursoDAO = new RecursoDAO();

    private String isbn;
    private Autor autor;
    private Categoria categoria;
    private Editorial editorial;
    private Idioma idioma;
    private Recurso recurso;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int cantidad;

    private String filtro;
    private String seleccion;
    private String operacion;

    private int idAutor;
    private int idEditorial;
    private int idCategoria;
    private int idIdioma;
    private String isbnLibro;

    private Libro libro;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Editorial> editoriales;
    private List<Categoria> categorias;
    private List<Idioma> idiomas;

    private File imagen;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    private void inicializarDAOs() {
        autores = autorDAO.list();
        editoriales = editorialDAO.list();
        categorias = categoriaDAO.list();
        idiomas = idiomaDAO.list();
    }

    public String execute() throws Exception {
        inicializarDAOs();
        if (operacion.equals("modificacion")) {
            libro = libroDAO.read(getIsbnLibro());
        }
        return operacion;
    }

    public String alta() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFecha());

        Recurso r = new Recurso(true);
        recursoDAO.create(r);

        libro = new Libro(getIsbn(), autorDAO.readId(getIdAutor()), categoriaDAO.readId(getIdCategoria()), editorialDAO.readId(getIdEditorial()), idiomaDAO.readId(getIdIdioma()), r, getTitulo(), getDescripcion(), fecha, getCantidad());
        libroDAO.create(libro);
        
        libros = libroDAO.list();

        return SUCCESS;
    }

    public String baja() {
        if (getIsbnLibro() != null) {
            libro = libroDAO.read(getIsbnLibro());
            libroDAO.delete(libro);
            
            libros = libroDAO.list();
            
            return SUCCESS;
        }
        return ERROR;
    }

    public String modificar() throws ParseException {
        if (getIsbnLibro() != null) {
<<<<<<< HEAD
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(getFecha());
            
            libroClient.edit_XML("<libro>"
                + "<cantidad>"+getCantidad()+"</cantidad>"
                + "<descripcion>"+getDescripcion()+"</descripcion>"
                + "<fecha>"+fecha+"</fecha>"
                + "<idAutor>"
                + "<id>"+getIdAutor()+"</id>"
                + "</idAutor>"
                + "<idCategoria>"
                + "<id>"+getIdCategoria()+"</id>"
                + "</idCategoria>"
                + "<idEditorial>"
                + "<id>"+getIdEditorial()+"</id>"
                + "</idEditorial>"
                + "<idIdioma>"
                + "<id>"+getIdioma().getId()+"</id>"
                + "</idIdioma>"
                + "<isbn>"+getIsbn()+"</isbn>"
                + "<titulo>"+getTitulo()+"</titulo>"
                + "</libro>", getIsbnLibro());
            
            libros = libroClient.findAll_XML(Libro[].class);
=======
            libro = libroDAO.read(getIsbnLibro());
            libro.setTitulo(getTitulo());
            libro.setDescripcion(getDescripcion());
            libro.setRecurso(getRecurso());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(getFecha());

            libro.setFecha(fecha);
            libro.setCantidad(getCantidad());

            libro.setAutor(autorDAO.readId(getIdAutor()));
            libro.setCategoria(categoriaDAO.readId(getIdCategoria()));
            libro.setEditorial(editorialDAO.readId(getIdEditorial()));
            libro.setIdioma(idiomaDAO.readId(getIdIdioma()));

            libroDAO.update(libro);
            
            libros = libroDAO.list();
>>>>>>> parent of 96e1dfb (Merge branch '1.3' of https://github.com/joselulg03/BiblioUpo into 1.3)
            
            return SUCCESS;
        }
        return ERROR;
    }

    public String filtrar() {
        if (seleccion != null) {
            if (seleccion.equals("Titulo")) {
                libro = readTitulo(filtro);
                
                if (libro == null) {
                    return ERROR;
                }
            } else if (seleccion.equals("Autor")) {
                libros = readAutor(filtro);
            } else if (seleccion.equals("Editorial")) {
                libros = readEditorial(filtro);
            }
        }
        return SUCCESS;
    }

    public String subidaImagen() {
        if (getIsbnLibro() != null && getImagen() != null) {
            String rutaImagen = getImagen().getPath();
            subirImagen(getIsbnLibro(), rutaImagen);
        }
        return SUCCESS;
    }

    private static String subirImagen(java.lang.String arg0, java.lang.String arg1) {
        servicios.GeneracionCorreos_Service service = new servicios.GeneracionCorreos_Service();
        servicios.GeneracionCorreos port = service.getGeneracionCorreosPort();
        return port.subirImagen(arg0, arg1);
    }

    private Libro readTitulo(String filtro) {
        libros = libroClient.findAll_XML(Libro[].class);
        
        for(Libro l : libros){
            if(l.getTitulo().equals(filtro)){
                return l;
            }
        }
        return null;
    }

    private Libro[] readAutor(String filtro) {
        libros = libroClient.findAll_XML(Libro[].class);
        
        Libro [] libs = new Libro[0];
        
        for(Libro l : libros){
            if(l.getIdAutor().getId() == Integer.parseInt(filtro)){
                libs[libs.length] = l;
            }
        }
        return libs;
    }

    private Libro[] readEditorial(String filtro) {
        libros = libroClient.findAll_XML(Libro[].class);
        
        Libro [] libs = new Libro[0];
        
        for(Libro l : libros){
            if(l.getIdEditorial().getId() == Integer.parseInt(filtro)){
                libs[libs.length] = l;
            }
        }
        return libs;
    }
}
