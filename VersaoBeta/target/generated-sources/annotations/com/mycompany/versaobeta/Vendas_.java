package com.mycompany.versaobeta;

import com.mycompany.versaobeta.Funcionarios;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:29:51")
@StaticMetamodel(Vendas.class)
public class Vendas_ { 

    public static volatile SingularAttribute<Vendas, String> formaPagamento;
    public static volatile SingularAttribute<Vendas, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Vendas, Integer> quantProdutos;
    public static volatile SingularAttribute<Vendas, Integer> id;
    public static volatile SingularAttribute<Vendas, Funcionarios> funcionarioscpf;

}