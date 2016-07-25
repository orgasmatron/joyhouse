/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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

/**
 *
 * @author AlshevskiYV
 */
@Entity
@Table(name = "categorygirls")
@NamedQueries({
    @NamedQuery(name = "Categorygirls.findAll", query = "SELECT c FROM Categorygirls c"),
    @NamedQuery(name = "Categorygirls.findById", query = "SELECT c FROM Categorygirls c WHERE c.id = :id"),
    @NamedQuery(name = "Categorygirls.findByName", query = "SELECT c FROM Categorygirls c WHERE c.name = :name")})
public class Categorygirls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorygirls")
    private Collection<Girls> girlsCollection;

    public Categorygirls() {
    }

    public Categorygirls(Short id) {
        this.id = id;
    }

    public Categorygirls(Short id, String name) {
        this.id = id;
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Girls> getGirlsCollection() {
        return girlsCollection;
    }

    public void setGirlsCollection(Collection<Girls> girlsCollection) {
        this.girlsCollection = girlsCollection;
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
        if (!(object instanceof Categorygirls)) {
            return false;
        }
        Categorygirls other = (Categorygirls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categorygirls[ id=" + id + " ]";
    }
    
}
