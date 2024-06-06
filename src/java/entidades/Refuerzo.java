/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "refuerzo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refuerzo.findAll", query = "SELECT r FROM Refuerzo r")
    , @NamedQuery(name = "Refuerzo.findById", query = "SELECT r FROM Refuerzo r WHERE r.id = :id")
    , @NamedQuery(name = "Refuerzo.findByDescripcion", query = "SELECT r FROM Refuerzo r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Refuerzo.findByAsignatura", query = "SELECT r FROM Refuerzo r WHERE r.asignatura = :asignatura")
    , @NamedQuery(name = "Refuerzo.findByTipo", query = "SELECT r FROM Refuerzo r WHERE r.tipo = :tipo")})
public class Refuerzo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "asignatura")
    private String asignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "dni_usuario", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario dniUsuario;
    @JoinColumn(name = "id_recurso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recurso idRecurso;
    @JoinColumn(name = "nombre_sala", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Sala nombreSala;

    public Refuerzo() {
    }

    public Refuerzo(Integer id) {
        this.id = id;
    }

    public Refuerzo(Integer id, String descripcion, String asignatura, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.asignatura = asignatura;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(Usuario dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Recurso getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Recurso idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Sala getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(Sala nombreSala) {
        this.nombreSala = nombreSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refuerzo)) {
            return false;
        }
        Refuerzo other = (Refuerzo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Refuerzo[ id=" + id + " ]";
    }
    
}
