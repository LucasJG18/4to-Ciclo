/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "chip")
@NamedQueries({
    @NamedQuery(name = "Chip.findAll", query = "SELECT c FROM Chip c"),
    @NamedQuery(name = "Chip.findByIdChip", query = "SELECT c FROM Chip c WHERE c.idChip = :idChip"),
    @NamedQuery(name = "Chip.findByNumero", query = "SELECT c FROM Chip c WHERE c.numero = :numero"),
    @NamedQuery(name = "Chip.findBySaldo", query = "SELECT c FROM Chip c WHERE c.saldo = :saldo")})
public class Chip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chip")
    private Integer idChip;
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private BigDecimal saldo;
    @JoinColumn(name = "id_celular", referencedColumnName = "id_celular")
    @ManyToOne
    private Celular idCelular;
    @OneToMany(mappedBy = "idChip")
    private Collection<Recarga> recargaCollection;

    public Chip() {
    }

    public Chip(Integer idChip) {
        this.idChip = idChip;
    }

    public Chip(String numero, BigDecimal saldo, Celular idCelular) {
        this.numero = numero;
        this.saldo = saldo;
        this.idCelular = idCelular;
    }

    public Integer getIdChip() {
        return idChip;
    }

    public void setIdChip(Integer idChip) {
        this.idChip = idChip;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Celular getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(Celular idCelular) {
        this.idCelular = idCelular;
    }

    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChip != null ? idChip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chip)) {
            return false;
        }
        Chip other = (Chip) object;
        if ((this.idChip == null && other.idChip != null) || (this.idChip != null && !this.idChip.equals(other.idChip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Chip[ idChip=" + idChip + " ]";
    }
    
}
