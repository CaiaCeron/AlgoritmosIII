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
@Table(name = "endere\u00e7o")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endere\u00e7o.findAll", query = "SELECT e FROM Endere\u00e7o e")
    , @NamedQuery(name = "Endere\u00e7o.findByCep", query = "SELECT e FROM Endere\u00e7o e WHERE e.cep = :cep")
    , @NamedQuery(name = "Endere\u00e7o.findByRua", query = "SELECT e FROM Endere\u00e7o e WHERE e.rua = :rua")
    , @NamedQuery(name = "Endere\u00e7o.findByLogradouro", query = "SELECT e FROM Endere\u00e7o e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "Endere\u00e7o.findByNumero", query = "SELECT e FROM Endere\u00e7o e WHERE e.numero = :numero")
    , @NamedQuery(name = "Endere\u00e7o.findByComplemento", query = "SELECT e FROM Endere\u00e7o e WHERE e.complemento = :complemento")
    , @NamedQuery(name = "Endere\u00e7o.findByNomeCidade", query = "SELECT e FROM Endere\u00e7o e WHERE e.nomeCidade = :nomeCidade")})
public class Endereço implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CEP")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Logradouro")
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
    @JoinColumn(name = "UF_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uf uFid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endere\u00e7oCEP")
    private Collection<Funcionarios> funcionariosCollection;

    public Endereço() {
    }

    public Endereço(String cep) {
        this.cep = cep;
    }

    public Endereço(String cep, String rua, String logradouro, String numero, String nomeCidade) {
        this.cep = cep;
        this.rua = rua;
        this.logradouro = logradouro;
        this.numero = numero;
        this.nomeCidade = nomeCidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
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

    public Uf getUFid() {
        return uFid;
    }

    public void setUFid(Uf uFid) {
        this.uFid = uFid;
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
        if (!(object instanceof Endereço)) {
            return false;
        }
        Endereço other = (Endereço) object;
        if ((this.cep == null && other.cep != null) || (this.cep != null && !this.cep.equals(other.cep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.Endere\u00e7o[ cep=" + cep + " ]";
    }
    
}
