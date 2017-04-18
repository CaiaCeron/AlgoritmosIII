package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Endereco;
import com.mycompany.versaobeta.models.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:14:32")
@StaticMetamodel(Uf.class)
public class Uf_ { 

    public static volatile SingularAttribute<Uf, Pais> paisId;
    public static volatile SingularAttribute<Uf, String> sigla;
    public static volatile CollectionAttribute<Uf, Endereco> enderecoCollection;
    public static volatile SingularAttribute<Uf, String> nome;
    public static volatile SingularAttribute<Uf, Integer> id;

}