package controlador.usuario;

import com.opensymphony.xwork2.ActionSupport;

public class formGestionUsuario extends ActionSupport {
    
    private String operacion;
    
    public formGestionUsuario() {
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
    
}
