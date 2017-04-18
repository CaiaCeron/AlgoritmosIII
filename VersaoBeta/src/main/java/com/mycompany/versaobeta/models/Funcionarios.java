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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexandre Schmidt
 */
@Entity
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f")
    , @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf")
    , @NamedQuery(name = "Funcionarios.findByNome", query = "SELECT f FROM Funcionarios f WHERE f.nome = :nome")
    , @NamedQuery(name = "Funcionarios.findByDataNascimento", query = "SELECT f FROM Funcionarios f WHERE f.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Funcionarios.findByRg", query = "SELECT f FROM Funcionarios f WHERE f.rg = :rg")
    , @NamedQuery(name = "Funcionarios.findByFone", query = "SELECT f FROM Funcionarios f WHERE f.fone = :fone")
    , @NamedQuery(name = "Funcionarios.findByEMail", query = "SELECT f FROM Funcionarios f WHERE f.eMail = :eMail")
    , @NamedQuery(name = "Funcionarios.findBySexo", query = "SELECT f FROM Funcionarios f WHERE f.sexo = :sexo")
    , @NamedQuery(name = "Funcionarios.findByCargo", query = "SELECT f FROM Funcionarios f WHERE f.cargo = :cargo")
    , @NamedQuery(name = "Funcionarios.findByLogin", query = "SELECT f FROM Funcionarios f WHERE f.login = :login")
    , @NamedQuery(name = "Funcionarios.findBySenha", query = "SELECT f FROM Funcionarios f WHERE f.senha = :senha")
    , @NamedQuery(name = "Funcionarios.findBySalario", query = "SELECT f FROM Funcionarios f WHERE f.salario = :salario")})
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private Integer cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fone")
    private String fone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "e-mail")
    private String eMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha")
    private String senha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    @OneToMany(mappedBy = "funcionariosCpf")
    private Collection<Vendas> vendasCollection;
    @JoinColumn(name = "endereco_cep", referencedColumnName = "cep")
    @ManyToOne
    private Endereco enderecoCep;

    public Funcionarios() {
    }

    public Funcionarios(Integer cpf) {
        this.cpf = cpf;
    }

    public Funcionarios(Integer cpf, String nome, Date dataNascimento, String rg, String fone, Character sexo, String cargo, String login, String senha, BigDecimal salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.fone = fone;
        this.sexo = sexo;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.salario = salario;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    public Endereco getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(Endereco enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.versaobeta.models.Funcionarios[ cpf=" + cpf + " ]";
    }
    
}
