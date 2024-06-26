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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "sistema_operativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaOperativo.findAll", query = "SELECT s FROM SistemaOperativo s")
    , @NamedQuery(name = "SistemaOperativo.findById", query = "SELECT s FROM SistemaOperativo s WHERE s.id = :id")
    , @NamedQuery(name = "SistemaOperativo.findByNombre", query = "SELECT s FROM SistemaOperativo s WHERE s.nombre = :nombre")})
public class SistemaOperativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSistemaOperativo")
    private Collection<Portatil> portatilCollection;

    public SistemaOperativo() {
    }

    public SistemaOperativo(Integer id) {
        this.id = id;
    }

    public SistemaOperativo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Portatil> getPortatilCollection() {
        return portatilCollection;
    }

    public void setPortatilCollection(Collection<Portatil> portatilCollection) {
        this.portatilCollection = portatilCollection;
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
        if (!(object instanceof SistemaOperativo)) {
            return false;
        }
        SistemaOperativo other = (SistemaOperativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SistemaOperativo[ id=" + id + " ]";
    }
    
}
