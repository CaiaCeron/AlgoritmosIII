/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta.facads;

import com.mycompany.versaobeta.models.Produtosaida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexandre Schmidt
 */
@Stateless
public class ProdutosaidaFacade extends AbstractFacade<Produtosaida> {

    @PersistenceContext(unitName = "com.mycompany_VersaoBeta_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutosaidaFacade() {
        super(Produtosaida.class);
    }
    
}
