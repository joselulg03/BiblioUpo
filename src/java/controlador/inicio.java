/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import modelo.Rol;
import modelo.Usuario;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author josel
 */
public class inicio extends ActionSupport {
    
    public inicio() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
    
}