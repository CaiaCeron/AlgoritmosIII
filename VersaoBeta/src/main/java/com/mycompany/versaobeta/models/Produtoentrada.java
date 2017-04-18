/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexandre Schmidt
 */
@Entity
@Table(name = "produtoentrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoentrada.findAll", query = "SELECT p FROM Produtoentrada p")
    , @NamedQuery(name = "Produtoentrada.findById", query = "SELECT p FROM Produtoentrada p WHERE p.id = :id")
    , @NamedQuery(name = "Produtoentrada.findByQuant", query = "SELECT p FROM Produtoentrada p WHERE p.quant = :quant")
    , @NamedQuery(name = "Produtoentrada.findByValorUnit", query = "SELECT p FROM Produtoentrada p WHERE p.valorUnit = :valorUnit")
    , @NamedQuery(name = "Produtoentrada.findByDataEntrada", query = "SELECT p FROM Produtoentrada p WHERE p.dataEntrada = :dataEntrada")})
public class Produtoentrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quant")
    private int quant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unit")
    private BigDecimal valorUnit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @OneToMany(mappedBy = "produtoEntradaid")
    private Collection<ProdutoEstoque> produtoEstoqueCollection;

    public Produtoentrada() {
    }

    public Produtoentrada(Integer id) {
        this.id = id;
    }

    public Produtoentrada(Integer id, int quant, BigDecimal valorUnit, Date dataEntrada) {
        this.id = id;
        this.quant = quant;
        this.valorUnit = valorUnit;
        this.dataEntrada = dataEntrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @XmlTransient
    public Collection<ProdutoEstoque> getProdutoEstoqueCollection() {
        return produtoEstoqueCollection;
    }

    public void setProdutoEstoqueCollection(Collection<ProdutoEstoque> produtoEstoqueCollection) {
        this.produtoEstoqueCollection = produtoEstoqueCollection;
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
        if (!(object instanceof Produtoentrada)) {
            return false;
        }
        Produtoentrada other = (Produtoentrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.Produtoentrada[ id=" + id + " ]";
    }
    
}
