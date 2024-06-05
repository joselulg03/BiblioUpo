/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.reserva;

import DAO.RecursoDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Libro;
import modelo.Recurso;
import modelo.Reserva;
import modelo.Usuario;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author josel
 */
public class gestionReserva extends ActionSupport {
    
    private ReservaDAO reservaDAO = new ReservaDAO();
    
    private Reserva reserva;
    
    private Integer idRecurso;
    
    private List<Reserva> reservas;
    
    
    public gestionReserva() {
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }

    public void setReservaDAO(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
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
    
    
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String alta(){
        RecursoDAO recursoDAO = new RecursoDAO();
        HttpSession session = ServletActionContext.getRequest().getSession();
        Recurso recurso = recursoDAO.read(idRecurso);
        if(!recurso.getLibros().isEmpty()){
            Libro l = (Libro) recurso.getLibros().iterator().next();
            l.setCantidad(l.getCantidad() - 1);
        }
        reserva = new Reserva(recurso, (Usuario) session.getAttribute("usuario"), new Date(), 72, false);
        reservaDAO.create(reserva);
        reservas = reservaDAO.list();
        return SUCCESS;
    }
    
}
