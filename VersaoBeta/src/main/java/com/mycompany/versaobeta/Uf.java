/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "uf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u")
    , @NamedQuery(name = "Uf.findById", query = "SELECT u FROM Uf u WHERE u.id = :id")
    , @NamedQuery(name = "Uf.findByNome", query = "SELECT u FROM Uf u WHERE u.nome = :nome")
    , @NamedQuery(name = "Uf.findBySigla", query = "SELECT u FROM Uf u WHERE u.sigla = :sigla")})
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2)
    @Column(name = "sigla")
    private String sigla;
    @JoinColumn(name = "Pais_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais paisid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uFid")
    private Collection<Endereço> endereçoCollection;

    public Uf() {
    }

    public Uf(Integer id) {
        this.id = id;
    }

    public Uf(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPaisid() {
        return paisid;
    }

    public void setPaisid(Pais paisid) {
        this.paisid = paisid;
    }

    @XmlTransient
    public Collection<Endereço> getEndereçoCollection() {
        return endereçoCollection;
    }

    public void setEndereçoCollection(Collection<Endereço> endereçoCollection) {
        this.endereçoCollection = endereçoCollection;
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
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.Uf[ id=" + id + " ]";
    }
    
}