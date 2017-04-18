/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta.models;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexandre Schmidt
 */
@Entity
@Table(name = "produto_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoEstoque.findAll", query = "SELECT p FROM ProdutoEstoque p")
    , @NamedQuery(name = "ProdutoEstoque.findById", query = "SELECT p FROM ProdutoEstoque p WHERE p.id = :id")
    , @NamedQuery(name = "ProdutoEstoque.findByCod", query = "SELECT p FROM ProdutoEstoque p WHERE p.cod = :cod")
    , @NamedQuery(name = "ProdutoEstoque.findByNome", query = "SELECT p FROM ProdutoEstoque p WHERE p.nome = :nome")
    , @NamedQuery(name = "ProdutoEstoque.findByDescricao", query = "SELECT p FROM ProdutoEstoque p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "ProdutoEstoque.findByQuant", query = "SELECT p FROM ProdutoEstoque p WHERE p.quant = :quant")
    , @NamedQuery(name = "ProdutoEstoque.findByValorUnit", query = "SELECT p FROM ProdutoEstoque p WHERE p.valorUnit = :valorUnit")
    , @NamedQuery(name = "ProdutoEstoque.findByQuantMin", query = "SELECT p FROM ProdutoEstoque p WHERE p.quantMin = :quantMin")})
public class ProdutoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private int cod;
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
    @Column(name = "quant_min")
    private int quantMin;
    @ManyToMany(mappedBy = "produtoEstoqueCollection")
    private Collection<Fornecedores> fornecedoresCollection;
    @JoinTable(name = "vendas_produto", joinColumns = {
        @JoinColumn(name = "produto_cod", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "vendas_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Vendas> vendasCollection;
    @JoinColumn(name = "produtoEntrada_id", referencedColumnName = "id")
    @ManyToOne
    private Produtoentrada produtoEntradaid;

    public ProdutoEstoque() {
    }

    public ProdutoEstoque(Integer id) {
        this.id = id;
    }

    public ProdutoEstoque(Integer id, int cod, String nome, String descricao, int quant, BigDecimal valorUnit, int quantMin) {
        this.id = id;
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.quant = quant;
        this.valorUnit = valorUnit;
        this.quantMin = quantMin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public int getQuantMin() {
        return quantMin;
    }

    public void setQuantMin(int quantMin) {
        this.quantMin = quantMin;
    }

    @XmlTransient
    public Collection<Fornecedores> getFornecedoresCollection() {
        return fornecedoresCollection;
    }

    public void setFornecedoresCollection(Collection<Fornecedores> fornecedoresCollection) {
        this.fornecedoresCollection = fornecedoresCollection;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    public Produtoentrada getProdutoEntradaid() {
        return produtoEntradaid;
    }

    public void setProdutoEntradaid(Produtoentrada produtoEntradaid) {
        this.produtoEntradaid = produtoEntradaid;
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
        if (!(object instanceof ProdutoEstoque)) {
            return false;
        }
        ProdutoEstoque other = (ProdutoEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.ProdutoEstoque[ id=" + id + " ]";
    }
    
}
