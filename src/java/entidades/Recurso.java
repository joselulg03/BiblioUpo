/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r")
    , @NamedQuery(name = "Recurso.findById", query = "SELECT r FROM Recurso r WHERE r.id = :id")
    , @NamedQuery(name = "Recurso.findByDisponible", query = "SELECT r FROM Recurso r WHERE r.disponible = :disponible")})
public class Recurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private boolean disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Libro> libroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Ordenador> ordenadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Portatil> portatilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Refuerzo> refuerzoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Sala> salaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecurso")
    private Collection<Reserva> reservaCollection;

    public Recurso() {
    }

    public Recurso(Integer id) {
        this.id = id;
    }

    public Recurso(Integer id, boolean disponible) {
        this.id = id;
        this.disponible = disponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    @XmlTransient
    public Collection<Ordenador> getOrdenadorCollection() {
        return ordenadorCollection;
    }

    public void setOrdenadorCollection(Collection<Ordenador> ordenadorCollection) {
        this.ordenadorCollection = ordenadorCollection;
    }

    @XmlTransient
    public Collection<Portatil> getPortatilCollection() {
        return portatilCollection;
    }

    public void setPortatilCollection(Collection<Portatil> portatilCollection) {
        this.portatilCollection = portatilCollection;
    }

    @XmlTransient
    public Collection<Refuerzo> getRefuerzoCollection() {
        return refuerzoCollection;
    }

    public void setRefuerzoCollection(Collection<Refuerzo> refuerzoCollection) {
        this.refuerzoCollection = refuerzoCollection;
    }

    @XmlTransient
    public Collection<Sala> getSalaCollection() {
        return salaCollection;
    }

    public void setSalaCollection(Collection<Sala> salaCollection) {
        this.salaCollection = salaCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
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
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Recurso[ id=" + id + " ]";
    }
    
}
