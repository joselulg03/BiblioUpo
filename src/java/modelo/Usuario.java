package modelo;

import DAO.RolDAO;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Usuario implements java.io.Serializable {

    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private Date fechaNacimiento;
    private String password;
    private Set reservas = new HashSet(0);
    private Set refuerzos = new HashSet(0);

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellidos, String correo, Date fechaNacimiento, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    public Usuario(String dni, String nombre, String apellidos, String correo, Date fechaNacimiento, String password, Set reservas, Set refuerzos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.reservas = reservas;
        this.refuerzos = refuerzos;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getReservas() {
        return this.reservas;
    }

    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }

    public Set getRefuerzos() {
        return this.refuerzos;
    }

    public void setRefuerzos(Set refuerzos) {
        this.refuerzos = refuerzos;
    }
}
