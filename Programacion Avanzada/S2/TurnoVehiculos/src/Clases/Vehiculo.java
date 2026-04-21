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
@Table(name = "vehiculo")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVel", query = "SELECT v FROM Vehiculo v WHERE v.idVel = :idVel"),
    @NamedQuery(name = "Vehiculo.findByYear", query = "SELECT v FROM Vehiculo v WHERE v.year = :year"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVel")
    private Integer idVel;
    @Basic(optional = false)
    @Column(name = "Year")
    private int year;
    @Basic(optional = false)
    @Column(name = "Marca")
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVel) {
        this.idVel = idVel;
    }

    public Vehiculo(Integer idVel, int year, String marca) {
        this.idVel = idVel;
        this.year = year;
        this.marca = marca;
    }

    public Vehiculo(int year, String marca) {
        this.year = year;
        this.marca = marca;
    }

    public Integer getIdVel() {
        return idVel;
    }

    public void setIdVel(Integer idVel) {
        this.idVel = idVel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVel != null ? idVel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVel == null && other.idVel != null) || (this.idVel != null && !this.idVel.equals(other.idVel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Vehiculo[ idVel=" + idVel + " ]";
    }
    
}
