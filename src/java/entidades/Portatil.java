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
@Table(name = "portatil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portatil.findAll", query = "SELECT p FROM Portatil p")
    , @NamedQuery(name = "Portatil.findByNumSerie", query = "SELECT p FROM Portatil p WHERE p.numSerie = :numSerie")
    , @NamedQuery(name = "Portatil.findByMarca", query = "SELECT p FROM Portatil p WHERE p.marca = :marca")
    , @NamedQuery(name = "Portatil.findByModelo", query = "SELECT p FROM Portatil p WHERE p.modelo = :modelo")})
public class Portatil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_serie")
    private String numSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "id_recurso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recurso idRecurso;
    @JoinColumn(name = "id_sistema_operativo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SistemaOperativo idSistemaOperativo;

    public Portatil() {
    }

    public Portatil(String numSerie) {
        this.numSerie = numSerie;
    }

    public Portatil(String numSerie, String marca, String modelo) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Recurso getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Recurso idRecurso) {
        this.idRecurso = idRecurso;
    }

    public SistemaOperativo getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(SistemaOperativo idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSerie != null ? numSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portatil)) {
            return false;
        }
        Portatil other = (Portatil) object;
        if ((this.numSerie == null && other.numSerie != null) || (this.numSerie != null && !this.numSerie.equals(other.numSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Portatil[ numSerie=" + numSerie + " ]";
    }
    
}
