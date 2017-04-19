package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Cliente;
import com.mycompany.versaobeta.models.Fornecedores;
import com.mycompany.versaobeta.models.Funcionarios;
import com.mycompany.versaobeta.models.Uf;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:54:21")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile CollectionAttribute<Endereco, Fornecedores> fornecedoresCollection;
    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, String> numero;
    public static volatile SingularAttribute<Endereco, String> logradouro;
    public static volatile SingularAttribute<Endereco, String> nomeCidade;
    public static volatile SingularAttribute<Endereco, Uf> ufId;
    public static volatile CollectionAttribute<Endereco, Funcionarios> funcionariosCollection;
    public static volatile SingularAttribute<Endereco, Integer> cep;
    public static volatile SingularAttribute<Endereco, String> rua;
    public static volatile CollectionAttribute<Endereco, Cliente> clienteCollection;

}