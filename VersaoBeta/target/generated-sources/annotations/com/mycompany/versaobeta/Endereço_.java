package com.mycompany.versaobeta;

import com.mycompany.versaobeta.Funcionarios;
import com.mycompany.versaobeta.Uf;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:29:51")
@StaticMetamodel(Endereço.class)
public class Endereço_ { 

    public static volatile SingularAttribute<Endereço, String> complemento;
    public static volatile SingularAttribute<Endereço, String> numero;
    public static volatile SingularAttribute<Endereço, String> logradouro;
    public static volatile SingularAttribute<Endereço, String> nomeCidade;
    public static volatile SingularAttribute<Endereço, Uf> uFid;
    public static volatile CollectionAttribute<Endereço, Funcionarios> funcionariosCollection;
    public static volatile SingularAttribute<Endereço, String> cep;
    public static volatile SingularAttribute<Endereço, String> rua;

}