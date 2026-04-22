/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LucasJG
 */
@Entity
@Table(name = "celular")
@NamedQueries({
    @NamedQuery(name = "Celular.findAll", query = "SELECT c FROM Celular c"),
    @NamedQuery(name = "Celular.findByIdCelular", query = "SELECT c FROM Celular c WHERE c.idCelular = :idCelular"),
    @NamedQuery(name = "Celular.findByMarca", query = "SELECT c FROM Celular c WHERE c.marca = :marca"),
    @NamedQuery(name = "Celular.findByModelo", query = "SELECT c FROM Celular c WHERE c.modelo = :modelo")})
public class Celular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_celular")
    private Integer idCelular;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @OneToMany(mappedBy = "idCelular")
    private Collection<Chip> chipCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public Celular() {
    }

    public Celular(Integer idCelular) {
        this.idCelular = idCelular;
    }

    public Celular(String marca, String modelo, Usuario idUsuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.idUsuario = idUsuario;
    }

    public Integer getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(Integer idCelular) {
        this.idCelular = idCelular;
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

    public Collection<Chip> getChipCollection() {
        return chipCollection;
    }

    public void setChipCollection(Collection<Chip> chipCollection) {
        this.chipCollection = chipCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCelular != null ? idCelular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celular)) {
            return false;
        }
        Celular other = (Celular) object;
        if ((this.idCelular == null && other.idCelular != null) || (this.idCelular != null && !this.idCelular.equals(other.idCelular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Celular[ idCelular=" + idCelular + " ]";
    }
    
}
