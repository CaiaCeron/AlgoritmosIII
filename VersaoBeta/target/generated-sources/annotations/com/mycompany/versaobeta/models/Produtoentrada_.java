package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.ProdutoEstoque;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:54:21")
@StaticMetamodel(Produtoentrada.class)
public class Produtoentrada_ { 

    public static volatile SingularAttribute<Produtoentrada, Date> dataEntrada;
    public static volatile CollectionAttribute<Produtoentrada, ProdutoEstoque> produtoEstoqueCollection;
    public static volatile SingularAttribute<Produtoentrada, Integer> id;
    public static volatile SingularAttribute<Produtoentrada, Integer> quant;
    public static volatile SingularAttribute<Produtoentrada, BigDecimal> valorUnit;

}