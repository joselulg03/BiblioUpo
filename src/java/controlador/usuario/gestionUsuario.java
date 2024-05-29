package controlador.usuario;

import DAO.RolDAO;
import DAO.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;
import servicios.EmailAutomaticoJerseyClient;

public class gestionUsuario extends ActionSupport {

    private String operacion;

    private UsuarioDAO usuarioDAO;
    private RolDAO rolDAO;

    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private String fechaNacimiento;
    private String password;
    private String rol;
    
    private int idRol;

    private Usuario usuario;
    private List<Usuario> usuarios;
    
    private List<Rol> roles;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public RolDAO getRolDAO() {
        return rolDAO;
    }

    public void setRolDAO(RolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
 
    public String execute() throws Exception {
        
        if(operacion.equals("alta")){
            rolDAO = new RolDAO();
            roles = rolDAO.list();
        }
        
        if (getDni() != null) {
            usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.readDni(getDni());
        }
        return operacion;
    }

    public String alta() throws ParseException {
        rolDAO = new RolDAO();
        rol = rolDAO.readId(getIdRol()).getTipo();
        
        usuarioDAO = new UsuarioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFechaNacimiento());
        
        String c = generarCorreo(getNombre(), getApellidos(), rol);

        usuarioDAO.create(new Usuario(getDni(), getNombre(), getApellidos(), c, fecha, getPassword()));
        usuarios = usuarioDAO.list();

        EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
        client.enviarCorreo(String.class,
                getCorreo(),
                "Bienvenido a BiblioUpo!",
                "Hola "+getNombre()+" "+getApellidos()+", ya formas parte de BiblioUpo.\n"
                        + "Accede a nuestra web para iniciar sesión.\n"
                        + "Sus credenciales son:\nUsuario: "+c+"\nContraseña: "+getPassword()+".");
        return SUCCESS;
    }

    public String baja() {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.readDni(getDni());
        usuarioDAO.delete(usuario);
        usuarios = usuarioDAO.list();
        
        EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
        client.enviarCorreo(String.class,
                getCorreo(),
                "Hasta pronto!",
                "Hola, ya no formas parte de BiblioUpo.\n"
                        + "Esperamos que vuelvas pronto.\n");
        return SUCCESS;
    }

    public String consultar() {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.readDni(getDni());
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        System.out.println("HOLA" + getNombre());

        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.readDni(getDni());
        System.out.println("DNI: " + usuario.getDni());
        usuario.setNombre(getNombre());
        usuario.setApellidos(getApellidos());
        usuario.setCorreo(getCorreo());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFechaNacimiento());
        usuario.setFechaNacimiento(fecha);
        usuario.setPassword(getPassword());
        EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
        client.enviarCorreo(String.class, "", "BiblioUpo ha actualizado su perfil", "Hola " + getNombre() + " " + getApellidos() + ", el administrador de BiblioUpo ha modificado su perfil. Su nueva contraseña es " + getPassword() + ".");

        usuarios = usuarioDAO.list();
        return SUCCESS;
    }

    private static String generarCorreo(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        servicios.GeneracionCorreos_Service service = new servicios.GeneracionCorreos_Service();
        servicios.GeneracionCorreos port = service.getGeneracionCorreosPort();
        return port.generarCorreo(arg0, arg1, arg2);
    }


}
