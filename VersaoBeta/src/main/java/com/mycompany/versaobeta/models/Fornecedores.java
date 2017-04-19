/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta.models;

import java.io.Serializable;
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
@Table(name = "fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f")
    , @NamedQuery(name = "Fornecedores.findById", query = "SELECT f FROM Fornecedores f WHERE f.id = :id")
    , @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj")
    , @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fornecedores.findByEmail", query = "SELECT f FROM Fornecedores f WHERE f.email = :email")
    , @NamedQuery(name = "Fornecedores.findByTelefone", query = "SELECT f FROM Fornecedores f WHERE f.telefone = :telefone")
    , @NamedQuery(name = "Fornecedores.findByInformacao", query = "SELECT f FROM Fornecedores f WHERE f.informacao = :informacao")})
public class Fornecedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "informacao")
    private String informacao;
    @JoinTable(name = "fornecedores_produto", joinColumns = {
        @JoinColumn(name = "fornecedores_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "produto_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ProdutoEstoque> produtoEstoqueCollection;
    @ManyToMany(mappedBy = "fornecedoresCollection")
    private Collection<Endereco> enderecoCollection;

    public Fornecedores() {
    }

    public Fornecedores(Integer id) {
        this.id = id;
    }

    public Fornecedores(Integer id, String cnpj, String nome, String email, String telefone, String informacao) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.informacao = informacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    @XmlTransient
    public Collection<ProdutoEstoque> getProdutoEstoqueCollection() {
        return produtoEstoqueCollection;
    }

    public void setProdutoEstoqueCollection(Collection<ProdutoEstoque> produtoEstoqueCollection) {
        this.produtoEstoqueCollection = produtoEstoqueCollection;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
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
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.Fornecedores[ id=" + id + " ]";
    }
    
}
