/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author LucasJG
 */
@Entity
@Table(name = "recarga")
@NamedQueries({
    @NamedQuery(name = "Recarga.findAll", query = "SELECT r FROM Recarga r"),
    @NamedQuery(name = "Recarga.findByIdRecarga", query = "SELECT r FROM Recarga r WHERE r.idRecarga = :idRecarga"),
    @NamedQuery(name = "Recarga.findByValor", query = "SELECT r FROM Recarga r WHERE r.valor = :valor"),
    @NamedQuery(name = "Recarga.findByFecha", query = "SELECT r FROM Recarga r WHERE r.fecha = :fecha")})
public class Recarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recarga")
    private Integer idRecarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_chip", referencedColumnName = "id_chip")
    @ManyToOne
    private Chip idChip;

    public Recarga() {
    }

    public Recarga(Integer idRecarga) {
        this.idRecarga = idRecarga;
    }

    public Recarga(Integer idRecarga, BigDecimal valor) {
        this.idRecarga = idRecarga;
        this.valor = valor;
    }

    public Recarga(BigDecimal valor, Date fecha, Chip idChip) {
        this.valor = valor;
        this.fecha = fecha;
        this.idChip = idChip;
    }

    public Integer getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(Integer idRecarga) {
        this.idRecarga = idRecarga;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Chip getIdChip() {
        return idChip;
    }

    public void setIdChip(Chip idChip) {
        this.idChip = idChip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecarga != null ? idRecarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recarga)) {
            return false;
        }
        Recarga other = (Recarga) object;
        if ((this.idRecarga == null && other.idRecarga != null) || (this.idRecarga != null && !this.idRecarga.equals(other.idRecarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Recarga[ idRecarga=" + idRecarga + " ]";
    }
    
}
