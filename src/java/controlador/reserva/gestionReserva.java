package controlador.reserva;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Reserva;
import entidades.Recurso;
import entidades.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import servicios.ReservaJerseyClient;
import servicios.RecursoJerseyClient;
import servicios.UsuarioJerseyClient;
import servicios.EmailAutomaticoJerseyClient;

public class gestionReserva extends ActionSupport {

    private String operacion;

    private ReservaJerseyClient reservaClient = new ReservaJerseyClient();
    private RecursoJerseyClient recursoClient = new RecursoJerseyClient();
    private UsuarioJerseyClient usuarioClient = new UsuarioJerseyClient();
    private EmailAutomaticoJerseyClient emailClient = new EmailAutomaticoJerseyClient();

    private int id;
    private String fecha;
    private double duracionHoras;
    private boolean entregado;
    private int idRecurso;
    private String dniUsuario;

    private Reserva reserva;
    private Reserva[] reservas;

    private Recurso[] recursos;
    private Usuario[] usuarios;

    public gestionReserva() {
    }

    // Getters y setters
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public ReservaJerseyClient getReservaClient() {
        return reservaClient;
    }

    public void setReservaClient(ReservaJerseyClient reservaClient) {
        this.reservaClient = reservaClient;
    }

    public RecursoJerseyClient getRecursoClient() {
        return recursoClient;
    }

    public void setRecursoClient(RecursoJerseyClient recursoClient) {
        this.recursoClient = recursoClient;
    }

    public UsuarioJerseyClient getUsuarioClient() {
        return usuarioClient;
    }

    public void setUsuarioClient(UsuarioJerseyClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public EmailAutomaticoJerseyClient getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(EmailAutomaticoJerseyClient emailClient) {
        this.emailClient = emailClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public Recurso[] getRecursos() {
        return recursos;
    }

    public void setRecursos(Recurso[] recursos) {
        this.recursos = recursos;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    // Métodos de operación
    public String execute() throws Exception {
        recursos = recursoClient.findAll_XML(Recurso[].class);
        usuarios = usuarioClient.findAll_XML(Usuario[].class);

        if (getId() != 0) {
            reserva = reservaClient.find_XML(Reserva.class, String.valueOf(id));
        }
        return operacion;
    }

    public String alta() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = formato.parse(getFecha());

        Reserva newReserva = new Reserva();
        newReserva.setFecha(fechaDate);
        newReserva.setDuracionHoras(getDuracionHoras());
        newReserva.setEntregado(isEntregado());
        newReserva.setIdRecurso(recursoClient.find_XML(Recurso.class, String.valueOf(getIdRecurso())));
        newReserva.setDniUsuario(usuarioClient.find_XML(Usuario.class, getDniUsuario()));

        reservaClient.create_XML(
                "<reserva>"
                + "<fecha>" + formato.format(newReserva.getFecha()) + "</fecha>"
                + "<duracionHoras>" + newReserva.getDuracionHoras() + "</duracionHoras>"
                + "<entregado>" + newReserva.getEntregado() + "</entregado>"
                + "<idRecurso>" + newReserva.getIdRecurso().getId() + "</idRecurso>"
                + "<dniUsuario>" + newReserva.getDniUsuario().getDni() + "</dniUsuario>"
                + "</reserva>"
        );

        reservas = reservaClient.findAll_XML(Reserva[].class);

        Usuario usuario = usuarioClient.find_XML(Usuario.class, dniUsuario);
        if (usuario != null && usuario.getCorreo() != null) {
            emailClient.enviarCorreo(String.class,
                    usuario.getCorreo(),
                    "Reserva confirmada",
                    "Hola, su reserva ha sido confirmada.\n"
                    + "Fecha: " + getFecha() + "\n"
                    + "Duración: " + getDuracionHoras() + " horas.\n");
        }

        return SUCCESS;
    }

    public String baja() {

        reservaClient.remove(String.valueOf(getId()));
        reservas = reservaClient.findAll_XML(Reserva[].class);
        Usuario usuario = usuarioClient.find_XML(Usuario.class, dniUsuario);
        if (usuario != null && usuario.getCorreo() != null) {
            emailClient.enviarCorreo(String.class,
                    usuario.getCorreo(),
                    "Reserva cancelada",
                    "Hola, su reserva ha sido cancelada.\n");
        }

        return SUCCESS;
    }

    public String consultar() {
        reserva = reservaClient.find_XML(Reserva.class, String.valueOf(id));
        return SUCCESS;
    }

    public String modificar() throws ParseException {
        reserva = reservaClient.find_XML(Reserva.class, String.valueOf(id));

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = formato.parse(getFecha());

        reserva.setFecha(fechaDate);
        reserva.setDuracionHoras(getDuracionHoras());
        reserva.setEntregado(isEntregado());
        reserva.setIdRecurso(recursoClient.find_XML(Recurso.class, String.valueOf(getIdRecurso())));
        reserva.setDniUsuario(usuarioClient.find_XML(Usuario.class, getDniUsuario()));

        reservaClient.edit_XML(reserva, String.valueOf(id));

        Usuario usuario = usuarioClient.find_XML(Usuario.class, dniUsuario);
        if (usuario != null && usuario.getCorreo() != null) {
            emailClient.enviarCorreo(String.class,
                    usuario.getCorreo(),
                    "Reserva modificada",
                    "Hola, su reserva ha sido modificada.\n"
                    + "Nueva fecha: " + getFecha() + "\n"
                    + "Nueva duración: " + getDuracionHoras() + " horas.\n");
        }
        return SUCCESS;

    }
}
