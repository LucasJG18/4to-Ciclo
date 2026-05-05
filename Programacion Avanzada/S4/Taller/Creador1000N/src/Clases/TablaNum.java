/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author LucasJG
 */
@Entity
@Table(name = "tabla_num")
@NamedQueries({
    @NamedQuery(name = "TablaNum.findAll", query = "SELECT t FROM TablaNum t"),
    @NamedQuery(name = "TablaNum.findByCol1", query = "SELECT t FROM TablaNum t WHERE t.col1 = :col1"),
    @NamedQuery(name = "TablaNum.findByCol2", query = "SELECT t FROM TablaNum t WHERE t.col2 = :col2"),
    @NamedQuery(name = "TablaNum.findByCol3", query = "SELECT t FROM TablaNum t WHERE t.col3 = :col3"),
    @NamedQuery(name = "TablaNum.findByCol4", query = "SELECT t FROM TablaNum t WHERE t.col4 = :col4"),
    @NamedQuery(name = "TablaNum.findByCol5", query = "SELECT t FROM TablaNum t WHERE t.col5 = :col5"),
    @NamedQuery(name = "TablaNum.findByIdC", query = "SELECT t FROM TablaNum t WHERE t.idC = :idC")})
public class TablaNum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "col1")
    private int col1;
    @Basic(optional = false)
    @Column(name = "col2")
    private int col2;
    @Basic(optional = false)
    @Column(name = "col3")
    private int col3;
    @Basic(optional = false)
    @Column(name = "col4")
    private int col4;
    @Basic(optional = false)
    @Column(name = "col5")
    private int col5;
    @Id
    @Basic(optional = false)
    @Column(name = "idC")
    private Integer idC;

    public TablaNum(int par, int par1) {
    }

    public TablaNum() {
    }

    public TablaNum(Integer idC) {
        this.idC = idC;
    }

    public TablaNum(int col1, int col2, int col3, int col4, int col5) {
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
        this.col5 = col5;
    }
    
    

    public TablaNum(Integer idC, int col1, int col2, int col3, int col4, int col5) {
        this.idC = idC;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
        this.col5 = col5;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public int getCol3() {
        return col3;
    }

    public void setCol3(int col3) {
        this.col3 = col3;
    }

    public int getCol4() {
        return col4;
    }

    public void setCol4(int col4) {
        this.col4 = col4;
    }

    public int getCol5() {
        return col5;
    }

    public void setCol5(int col5) {
        this.col5 = col5;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaNum)) {
            return false;
        }
        TablaNum other = (TablaNum) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.TablaNum[ idC=" + idC + " ]";
    }
    
}
