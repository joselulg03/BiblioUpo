package controlador.libro;

import com.opensymphony.xwork2.ActionSupport;
import entidades.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import servicios.*;

/**
 *
 * @author josel
 */
public class gestionLibro extends ActionSupport {
    
    private LibroJerseyClient libroClient = new LibroJerseyClient();
    private AutorJerseyClient autorClient = new AutorJerseyClient();
    private EditorialJerseyClient editorialClient = new EditorialJerseyClient();
    private CategoriaJerseyClient categoriaClient = new CategoriaJerseyClient();
    private IdiomaJerseyClient idiomaClient = new IdiomaJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();
    
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

    public LibroJerseyClient getLibroClient() {
        return libroClient;
    }

    public void setLibroClient(LibroJerseyClient libroClient) {
        this.libroClient = libroClient;
    }

    public AutorJerseyClient getAutorClient() {
        return autorClient;
    }

    public void setAutorClient(AutorJerseyClient autorClient) {
        this.autorClient = autorClient;
    }

    public EditorialJerseyClient getEditorialClient() {
        return editorialClient;
    }

    public void setEditorialClient(EditorialJerseyClient editorialClient) {
        this.editorialClient = editorialClient;
    }

    public CategoriaJerseyClient getCategoriaClient() {
        return categoriaClient;
    }

    public void setCategoriaClient(CategoriaJerseyClient categoriaClient) {
        this.categoriaClient = categoriaClient;
    }

    public IdiomaJerseyClient getIdiomaClient() {
        return idiomaClient;
    }

    public void setIdiomaClient(IdiomaJerseyClient idiomaClient) {
        this.idiomaClient = idiomaClient;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
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

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }
    
    
    
    public String execute(){
        autores = Arrays.asList(autorClient.findAll_XML(Autor[].class));
        editoriales = Arrays.asList(editorialClient.findAll_XML(Editorial[].class));
        categorias = Arrays.asList(categoriaClient.findAll_XML(Categoria[].class));
        idiomas = Arrays.asList(idiomaClient.findAll_XML(Idioma[].class));
        
        libro = libroClient.find_XML(Libro.class, getIsbnLibro());
        return operacion;
    }
    
    public String alta() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFecha());
        
        recursoClient.create_XML("<recurso>"
                + "<disponible>true</disponible>"
                + "</recurso>");

        Recurso[] r = recursoClient.findAll_XML(Recurso[].class);
        
        libroClient.create_XML("<libro>"
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
                + "<id>"+getIdIdioma()+"</id>"
                + "</idIdioma>"
                + "<idRecurso>"
                + "<id>"+r[r.length-1].getId()+"</id>"
                + "</idRecurso>"
                + "<isbn>"+getIsbn()+"</isbn>"
                + "<titulo>"+getTitulo()+"</titulo>"
                + "</libro>");
        
        libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));

        return SUCCESS;
    }
    
    public String baja() {
        if (getIsbnLibro() != null) {
            
            libroClient.remove(getIsbnLibro());
            
            libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
            
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String modificar() throws ParseException {

        if (getIsbn() != null) {
            
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
                + "<id>"+getIdIdioma()+"</id>"
                + "</idIdioma>"
                + "<isbn>"+getIsbn()+"</isbn>"
                + "<titulo>"+getTitulo()+"</titulo>"
                + "</libro>", getIsbnLibro());
            
            
            libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
            
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
        libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
        
        for(Libro l : libros){
            if(l.getTitulo().equals(filtro)){
                return l;
            }
        }
        return null;
    }

    private List<Libro> readAutor(String filtro) {
        libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
        
        List<Libro> libs = new ArrayList<>();
        for(Libro l : libros){
            if(l.getIdAutor().getId() == Integer.parseInt(filtro)){
                libs.add(l);
            }
        }
        return libs;
    }

    private List<Libro> readEditorial(String filtro) {
        libros = Arrays.asList(libroClient.findAll_XML(Libro[].class));
        
        List<Libro> libs = new ArrayList<>();
        for(Libro l : libros){
            if(l.getIdEditorial().getId() == Integer.parseInt(filtro)){
                libs.add(l);
            }
        }
        return libs;
    }
}
