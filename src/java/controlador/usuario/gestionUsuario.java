package controlador.usuario;

import DAO.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Usuario;

public class gestionUsuario extends ActionSupport {
    
    private String operacion;
    
    private UsuarioDAO usuarioDAO;
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private String fechaNacimiento;
    private String password;
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    public gestionUsuario() {
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    public String execute() throws Exception {
        return operacion;
    }
    
    public String alta() throws ParseException{
        usuarioDAO = new UsuarioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFechaNacimiento());
        usuarioDAO.create(new Usuario(getDni(), getNombre(), getApellidos(), getCorreo(), fecha, getPassword()));
        usuarios = usuarioDAO.list();
        return SUCCESS;
    }
    
    public String baja(){
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.readDni(getDni());
        usuarioDAO.delete(usuario);
        usuarios = usuarioDAO.list();
        return SUCCESS;
    }
    
    public String consultar(){
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.readDni(getDni());
        return SUCCESS;
    }
    
}
