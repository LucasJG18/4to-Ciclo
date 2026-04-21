/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author LucasJG
 */
@Entity
@Table(name = "turnos")
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t"),
    @NamedQuery(name = "Turnos.findByIdTurn", query = "SELECT t FROM Turnos t WHERE t.idTurn = :idTurn"),
    @NamedQuery(name = "Turnos.findByCodigo", query = "SELECT t FROM Turnos t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Turnos.findByDescripcion", query = "SELECT t FROM Turnos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Turnos.findByIdVel", query = "SELECT t FROM Turnos t WHERE t.idVel = :idVel")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurn")
    private Integer idTurn;
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "idVel")
    private int idVel;

    public Turnos() {
    }

    public Turnos(Integer idTurn) {
        this.idTurn = idTurn;
    }

    public Turnos(Integer idTurn, String codigo, String descripcion, int idVel) {
        this.idTurn = idTurn;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.idVel = idVel;
    }
    
    public Turnos(String codigo, String descripcion, int idVel) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.idVel = idVel;
    }

    public Integer getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Integer idTurn) {
        this.idTurn = idTurn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdVel() {
        return idVel;
    }

    public void setIdVel(int idVel) {
        this.idVel = idVel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurn != null ? idTurn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idTurn == null && other.idTurn != null) || (this.idTurn != null && !this.idTurn.equals(other.idTurn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Turnos[ idTurn=" + idTurn + " ]";
    }
    
}
