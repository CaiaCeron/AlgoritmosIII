package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Cliente;
import com.mycompany.versaobeta.models.Funcionarios;
import com.mycompany.versaobeta.models.ProdutoEstoque;
import com.mycompany.versaobeta.models.Produtosaida;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:54:21")
@StaticMetamodel(Vendas.class)
public class Vendas_ { 

    public static volatile SingularAttribute<Vendas, String> formaPagamento;
    public static volatile SingularAttribute<Vendas, Cliente> clienteId;
    public static volatile CollectionAttribute<Vendas, ProdutoEstoque> produtoEstoqueCollection;
    public static volatile SingularAttribute<Vendas, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Vendas, Integer> quantProdutos;
    public static volatile SingularAttribute<Vendas, Integer> id;
    public static volatile SingularAttribute<Vendas, Funcionarios> funcionariosCpf;
    public static volatile SingularAttribute<Vendas, Produtosaida> produtoSaidaid;

}