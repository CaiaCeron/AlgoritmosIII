package com.mycompany.versaobeta;

import com.mycompany.versaobeta.Endereço;
import com.mycompany.versaobeta.Vendas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T11:29:51")
@StaticMetamodel(Funcionarios.class)
public class Funcionarios_ { 

    public static volatile SingularAttribute<Funcionarios, Double> salario;
    public static volatile SingularAttribute<Funcionarios, String> nome;
    public static volatile SingularAttribute<Funcionarios, String> login;
    public static volatile SingularAttribute<Funcionarios, Endereço> endereçoCEP;
    public static volatile CollectionAttribute<Funcionarios, Vendas> vendasCollection;
    public static volatile SingularAttribute<Funcionarios, String> eMail;
    public static volatile SingularAttribute<Funcionarios, String> fone;
    public static volatile SingularAttribute<Funcionarios, String> senha;
    public static volatile SingularAttribute<Funcionarios, String> rg;
    public static volatile SingularAttribute<Funcionarios, Integer> cpf;
    public static volatile SingularAttribute<Funcionarios, Date> dataNascimento;
    public static volatile SingularAttribute<Funcionarios, Character> sexo;
    public static volatile SingularAttribute<Funcionarios, String> cargo;

}