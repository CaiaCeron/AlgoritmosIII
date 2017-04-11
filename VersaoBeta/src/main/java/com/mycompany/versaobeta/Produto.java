/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.produtoPK.id = :id")
    , @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produto.findByQuant", query = "SELECT p FROM Produto p WHERE p.quant = :quant")
    , @NamedQuery(name = "Produto.findByValorUnit", query = "SELECT p FROM Produto p WHERE p.valorUnit = :valorUnit")
    , @NamedQuery(name = "Produto.findByValorCompra", query = "SELECT p FROM Produto p WHERE p.valorCompra = :valorCompra")
    , @NamedQuery(name = "Produto.findByCod", query = "SELECT p FROM Produto p WHERE p.produtoPK.cod = :cod")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoPK produtoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
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
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;

    public Produto() {
    }

    public Produto(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public Produto(ProdutoPK produtoPK, String nome, String descricao, int quant, BigDecimal valorUnit, BigDecimal valorCompra) {
        this.produtoPK = produtoPK;
        this.nome = nome;
        this.descricao = descricao;
        this.quant = quant;
        this.valorUnit = valorUnit;
        this.valorCompra = valorCompra;
    }

    public Produto(int id, int cod) {
        this.produtoPK = new ProdutoPK(id, cod);
    }

    public ProdutoPK getProdutoPK() {
        return produtoPK;
    }

    public void setProdutoPK(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoPK != null ? produtoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produtoPK == null && other.produtoPK != null) || (this.produtoPK != null && !this.produtoPK.equals(other.produtoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.Produto[ produtoPK=" + produtoPK + " ]";
    }
    
}
