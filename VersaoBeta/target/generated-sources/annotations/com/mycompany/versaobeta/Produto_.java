package com.mycompany.versaobeta;

import com.mycompany.versaobeta.ProdutoPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:29:51")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, ProdutoPK> produtoPK;
    public static volatile SingularAttribute<Produto, BigDecimal> valorCompra;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> quant;
    public static volatile SingularAttribute<Produto, BigDecimal> valorUnit;
    public static volatile SingularAttribute<Produto, String> descricao;

}