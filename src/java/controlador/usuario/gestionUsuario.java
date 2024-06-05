package controlador.usuario;

import com.opensymphony.xwork2.ActionSupport;
import entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import servicios.*;

public class gestionUsuario extends ActionSupport {

    private String operacion;
    
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private RolJerseyClient rolClient = new RolJerseyClient();
    private EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();

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


    public UsuarioJerseyClient getUsuarioClient() {
        return usuarioClient;
    }

    public void setUsuarioClient(UsuarioJerseyClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public RolJerseyClient getRolClient() {
        return rolClient;
    }

    public void setRolClient(RolJerseyClient rolClient) {
        this.rolClient = rolClient;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public EmailAutomaticoJerseyClient getClient() {
        return client;
    }

    public void setClient(EmailAutomaticoJerseyClient client) {
        this.client = client;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    

    public String execute() throws Exception {
        roles = Arrays.asList(rolClient.findAll_XML(Rol[].class));

        if (getDni() != null) {
            usuario = usuarioClient.find_XML(Usuario.class, dni);
        }
        return operacion;
    }

    public String alta() throws ParseException {
        
        rol = rolClient.find_XML(Rol.class, String.valueOf(getIdRol())).getTipo();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFechaNacimiento());

        String c = generarCorreo(getNombre(), getApellidos(), rol);

        usuarioClient.create_XML(
                "<usuario>"
                + "<apellidos>"+getApellidos()+"</apellidos>"
                + "<correo>"+c+"</correo>"
                + "<dni>"+getDni()+"</dni>"
                + "<fechaNacimiento>"+fecha+"</fechaNacimiento>"
                + "<nombre>"+getNombre()+"</nombre>"
                + "<password>"+getPassword()+"</password>"
                + "</usuario>"
        );

        usuarios = Arrays.asList(usuarioClient.findAll_XML(Usuario[].class));
        
        client.enviarCorreo(String.class,
                getCorreo(),
                "Bienvenido a BiblioUpo!",
                "Hola " + getNombre() + " " + getApellidos() + ", ya formas parte de BiblioUpo.\n"
                + "Accede a nuestra web para iniciar sesión.\n"
                + "Sus credenciales son:\nUsuario: " + c + "\nContraseña: " + getPassword() + ".");
        return SUCCESS;
    }

    public String baja() {
        usuarioClient.remove(getDni());
        
        usuarios = Arrays.asList(usuarioClient.findAll_XML(Usuario[].class));

        client.enviarCorreo(String.class,
                getCorreo(),
                "Hasta pronto!",
                "Hola, ya no formas parte de BiblioUpo.\n"
                + "Esperamos que vuelvas pronto.\n");
        return SUCCESS;
    }

    public String consultar() {
        usuario = usuarioClient.find_XML(Usuario.class, dni);
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        usuario = usuarioClient.find_XML(Usuario.class, dni);

        usuario.setNombre(getNombre());
        usuario.setApellidos(getApellidos());
        usuario.setCorreo(getCorreo());

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(getFechaNacimiento());

        usuario.setFechaNacimiento(fecha);
        usuario.setPassword(getPassword());

        client.enviarCorreo(String.class, "", "BiblioUpo ha actualizado su perfil", "Hola " + getNombre() + " " + getApellidos() + ", el administrador de BiblioUpo ha modificado su perfil. Su nueva contraseña es " + getPassword() + ".");

        usuarios = Arrays.asList(usuarioClient.findAll_XML(Usuario[].class));
        return SUCCESS;
    }

    private static String generarCorreo(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        servicios.GeneracionCorreos_Service service = new servicios.GeneracionCorreos_Service();
        servicios.GeneracionCorreos port = service.getGeneracionCorreosPort();
        return port.generarCorreo(arg0, arg1, arg2);
    }

    public void validate() {

        if (operacion.equals("alta") || operacion.equals("modificacion")) {
            if (getDni() == null || getDni().equals("")) {
                addFieldError("dni", getText("campo.requerido"));
            }

            if (getNombre() == null || getNombre().equals("")) {
                addFieldError("nombre", getText("campo.requerido"));
            }

            if (getApellidos() == null || getApellidos().equals("")) {
                addFieldError("apellidos", getText("campo.requerido"));
            }

            if (getFechaNacimiento() == null || getFechaNacimiento().equals("")) {
                addFieldError("fecha", getText("campo.requerido"));
            }
        }
    }
}
