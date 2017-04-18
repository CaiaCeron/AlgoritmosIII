package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Vendas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:14:32")
@StaticMetamodel(Produtosaida.class)
public class Produtosaida_ { 

    public static volatile SingularAttribute<Produtosaida, Integer> id;
    public static volatile SingularAttribute<Produtosaida, Date> dataSaida;
    public static volatile SingularAttribute<Produtosaida, Integer> quant;
    public static volatile SingularAttribute<Produtosaida, BigDecimal> valorUnit;
    public static volatile CollectionAttribute<Produtosaida, Vendas> vendasCollection;

}