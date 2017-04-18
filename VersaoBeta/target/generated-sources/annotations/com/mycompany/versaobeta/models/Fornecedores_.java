package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Endereco;
import com.mycompany.versaobeta.models.ProdutoEstoque;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:14:32")
@StaticMetamodel(Fornecedores.class)
public class Fornecedores_ { 

    public static volatile SingularAttribute<Fornecedores, String> informação;
    public static volatile SingularAttribute<Fornecedores, String> telefone;
    public static volatile CollectionAttribute<Fornecedores, ProdutoEstoque> produtoEstoqueCollection;
    public static volatile CollectionAttribute<Fornecedores, Endereco> enderecoCollection;
    public static volatile SingularAttribute<Fornecedores, String> nome;
    public static volatile SingularAttribute<Fornecedores, Integer> id;
    public static volatile SingularAttribute<Fornecedores, String> cnpj;
    public static volatile SingularAttribute<Fornecedores, String> eMail;

}