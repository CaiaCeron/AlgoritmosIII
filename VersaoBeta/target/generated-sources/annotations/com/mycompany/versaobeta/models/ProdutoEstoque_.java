package com.mycompany.versaobeta.models;

import com.mycompany.versaobeta.models.Fornecedores;
import com.mycompany.versaobeta.models.Produtoentrada;
import com.mycompany.versaobeta.models.Vendas;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T20:14:32")
@StaticMetamodel(ProdutoEstoque.class)
public class ProdutoEstoque_ { 

    public static volatile CollectionAttribute<ProdutoEstoque, Fornecedores> fornecedoresCollection;
    public static volatile SingularAttribute<ProdutoEstoque, Produtoentrada> produtoEntradaid;
    public static volatile SingularAttribute<ProdutoEstoque, Integer> quantMin;
    public static volatile SingularAttribute<ProdutoEstoque, Integer> cod;
    public static volatile SingularAttribute<ProdutoEstoque, String> nome;
    public static volatile SingularAttribute<ProdutoEstoque, Integer> id;
    public static volatile SingularAttribute<ProdutoEstoque, Integer> quant;
    public static volatile SingularAttribute<ProdutoEstoque, BigDecimal> valorUnit;
    public static volatile CollectionAttribute<ProdutoEstoque, Vendas> vendasCollection;
    public static volatile SingularAttribute<ProdutoEstoque, String> descricao;

}