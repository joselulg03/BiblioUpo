/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.reserva;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Reserva;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import servicios.ReservaJerseyClient;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author jpguz
 */
public class gestionReserva extends ActionSupport {

    private ReservaJerseyClient reservaClient = new ReservaJerseyClient();
    
    private Reserva reserva;
        
    private List<Reserva> reservas;
   
    public gestionReserva() {
    }

    public ReservaJerseyClient getReservaClient() {
        return reservaClient;
    }

    public void setReservaClient(ReservaJerseyClient reservaClient) {
        this.reservaClient = reservaClient;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método para listar todas las reservas
    public String listar() {
        try {
            reservas = reservaClient.findAll_JSON(List.class);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al listar las reservas: " + e.getMessage());
            return ERROR;
        }
    }

    // Método para crear una nueva reserva
    public String crear() {
        try {
            reservaClient.create_JSON(reserva);
            addActionMessage("Reserva creada exitosamente.");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al crear la reserva: " + e.getMessage());
            return ERROR;
        }
    }

    // Método para editar una reserva existente
    public String editar() {
        try {
            reservaClient.edit_JSON(reserva, reserva.getId().toString());
            addActionMessage("Reserva editada exitosamente.");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al editar la reserva: " + e.getMessage());
            return ERROR;
        }
    }

    // Método para eliminar una reserva
    public String eliminar() {
        try {
            reservaClient.remove(reserva.getId().toString());
            addActionMessage("Reserva eliminada exitosamente.");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al eliminar la reserva: " + e.getMessage());
            return ERROR;
        }
    }

    // Método para buscar una reserva por ID
    public String buscar() {
        try {
            reserva = reservaClient.find_JSON(Reserva.class, reserva.getId().toString());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al buscar la reserva: " + e.getMessage());
            return ERROR;
        }
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
