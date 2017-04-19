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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Alexandre Schmidt
 */
@Entity
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")
    , @NamedQuery(name = "Endereco.findByRua", query = "SELECT e FROM Endereco e WHERE e.rua = :rua")
    , @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero")
    , @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento")
    , @NamedQuery(name = "Endereco.findByNomeCidade", query = "SELECT e FROM Endereco e WHERE e.nomeCidade = :nomeCidade")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private Integer cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_cidade")
    private String nomeCidade;
    @JoinTable(name = "endereco_fornecedores", joinColumns = {
        @JoinColumn(name = "endereco_cep", referencedColumnName = "cep")}, inverseJoinColumns = {
        @JoinColumn(name = "fornecedores_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Fornecedores> fornecedoresCollection;
    @OneToMany(mappedBy = "enderecoCep")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "uf_id", referencedColumnName = "id")
    @ManyToOne
    private Uf ufId;
    @OneToMany(mappedBy = "enderecoCep")
    private Collection<Funcionarios> funcionariosCollection;

    public Endereco() {
    }

    public Endereco(Integer cep) {
        this.cep = cep;
    }

    public Endereco(Integer cep, String rua, String logradouro, String numero, String nomeCidade) {
        this.cep = cep;
        this.rua = rua;
        this.logradouro = logradouro;
        this.numero = numero;
        this.nomeCidade = nomeCidade;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @XmlTransient
    public Collection<Fornecedores> getFornecedoresCollection() {
        return fornecedoresCollection;
    }

    public void setFornecedoresCollection(Collection<Fornecedores> fornecedoresCollection) {
        this.fornecedoresCollection = fornecedoresCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Uf getUfId() {
        return ufId;
    }

    public void setUfId(Uf ufId) {
        this.ufId = ufId;
    }

    @XmlTransient
    public Collection<Funcionarios> getFuncionariosCollection() {
        return funcionariosCollection;
    }

    public void setFuncionariosCollection(Collection<Funcionarios> funcionariosCollection) {
        this.funcionariosCollection = funcionariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cep != null ? cep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.cep == null && other.cep != null) || (this.cep != null && !this.cep.equals(other.cep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.Endereco[ cep=" + cep + " ]";
    }
    
}
