/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RolDAO;
import DAO.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import modelo.Rol;
import modelo.Usuario;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author josel
 */
public class iniciarSesion extends ActionSupport {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private RolDAO rolDAO = new RolDAO();

    private String correo;
    private String password;

    private Usuario usuario;
    private Rol rol;

    public iniciarSesion() {
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
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

    public RolDAO getRolDAO() {
        return rolDAO;
    }

    public void setRolDAO(RolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("usuario") != null){
            usuario = (Usuario) session.getAttribute("usuario");
            rol = (Rol) session.getAttribute("rol");
            return "logado";
        }
        return SUCCESS;
    }

    public String iniciarSesion() {
        usuario = usuarioDAO.read(getCorreo());

        if (usuario != null) {
            if (!usuario.getPassword().equals(getPassword())) {
                return ERROR;
            } else {
                
                rol = rolDAO.read(usuario.getCorreo().split("@")[1]);
                
                HttpSession session = ServletActionContext.getRequest().getSession();
                
                session.setAttribute("usuario", usuario);
                
                session.setAttribute("rol", rol);
                
                return SUCCESS;
            }
        }
        return ERROR;
    }

}
