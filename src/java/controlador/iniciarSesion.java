package controlador;

import com.opensymphony.xwork2.ActionSupport;
import entidades.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import servicios.*;

/**
 *
 * @author josel
 */
public class iniciarSesion extends ActionSupport {

    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private RolJerseyClient rolClient = new RolJerseyClient();

    private String correo;
    private String password;

    private Usuario usuario;
    private Rol rol;

    public iniciarSesion() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session.getAttribute("usuario") != null) {
            usuario = (Usuario) session.getAttribute("usuario");
            rol = (Rol) session.getAttribute("rol");
            return "logado";
        }
        return SUCCESS;
    }

    public String iniciarSesion() {
        
        usuario = buscarPorCorreo(correo);

        if (usuario != null) {
            if (!usuario.getPassword().equals(getPassword())) {
                return ERROR;
            } else {

                rol = buscarPorDominio(usuario.getCorreo().split("@")[1]);

                if (rol == null) {
                    setRol(new Rol(usuario.getCorreo().split("@")[1], "Invitado"));
                }

                HttpSession session = ServletActionContext.getRequest().getSession();

                session.setAttribute("usuario", usuario);

                session.setAttribute("rol", rol);

                Date fechaActual = new Date();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                String fechaFormateada = formatoFecha.format(fechaActual);
                String horaFormateada = formatoHora.format(fechaActual);

                EmailAutomaticoJerseyClient client = new EmailAutomaticoJerseyClient();
                client.enviarCorreo(String.class,
                        usuario.getCorreo(),
                        "Inicio de sesión en BiblioUpo",
                        "Has iniciado sesión en BiblioUpo hoy día " + fechaFormateada + " a las " + horaFormateada + ".");
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public Usuario buscarPorCorreo(String correo) {
        Usuario[] usuarios = usuarioClient.findAll_XML(Usuario[].class);

        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    }

    public Rol buscarPorDominio(String dominio) {
        Rol[] roles = rolClient.findAll_XML(Rol[].class);

        for (Rol r : roles) {
            if (r.getDominio().equals(dominio)) {
                return r;
            }
        }
        return null;
    }

}
