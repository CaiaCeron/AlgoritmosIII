package com.mycompany.versaobeta;

import com.mycompany.versaobeta.Endereço;
import com.mycompany.versaobeta.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:29:51")
@StaticMetamodel(Uf.class)
public class Uf_ { 

    public static volatile SingularAttribute<Uf, Pais> paisid;
    public static volatile SingularAttribute<Uf, String> sigla;
    public static volatile SingularAttribute<Uf, String> nome;
    public static volatile CollectionAttribute<Uf, Endereço> endereçoCollection;
    public static volatile SingularAttribute<Uf, Integer> id;

}