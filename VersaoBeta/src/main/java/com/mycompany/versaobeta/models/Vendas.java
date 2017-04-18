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
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v")
    , @NamedQuery(name = "Vendas.findById", query = "SELECT v FROM Vendas v WHERE v.id = :id")
    , @NamedQuery(name = "Vendas.findByQuantProdutos", query = "SELECT v FROM Vendas v WHERE v.quantProdutos = :quantProdutos")
    , @NamedQuery(name = "Vendas.findByValorTotal", query = "SELECT v FROM Vendas v WHERE v.valorTotal = :valorTotal")
    , @NamedQuery(name = "Vendas.findByFormaPagamento", query = "SELECT v FROM Vendas v WHERE v.formaPagamento = :formaPagamento")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quant_produtos")
    private int quantProdutos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @ManyToMany(mappedBy = "vendasCollection")
    private Collection<ProdutoEstoque> produtoEstoqueCollection;
    @JoinColumn(name = "funcionarios_cpf", referencedColumnName = "cpf")
    @ManyToOne
    private Funcionarios funcionariosCpf;
    @JoinColumn(name = "produtoSaida_id", referencedColumnName = "id")
    @ManyToOne
    private Produtosaida produtoSaidaid;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteId;

    public Vendas() {
    }

    public Vendas(Integer id) {
        this.id = id;
    }

    public Vendas(Integer id, int quantProdutos, BigDecimal valorTotal, String formaPagamento) {
        this.id = id;
        this.quantProdutos = quantProdutos;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantProdutos() {
        return quantProdutos;
    }

    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @XmlTransient
    public Collection<ProdutoEstoque> getProdutoEstoqueCollection() {
        return produtoEstoqueCollection;
    }

    public void setProdutoEstoqueCollection(Collection<ProdutoEstoque> produtoEstoqueCollection) {
        this.produtoEstoqueCollection = produtoEstoqueCollection;
    }

    public Funcionarios getFuncionariosCpf() {
        return funcionariosCpf;
    }

    public void setFuncionariosCpf(Funcionarios funcionariosCpf) {
        this.funcionariosCpf = funcionariosCpf;
    }

    public Produtosaida getProdutoSaidaid() {
        return produtoSaidaid;
    }

    public void setProdutoSaidaid(Produtosaida produtoSaidaid) {
        this.produtoSaidaid = produtoSaidaid;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.Vendas[ id=" + id + " ]";
    }
    
}
