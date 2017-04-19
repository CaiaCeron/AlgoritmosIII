/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.versaobeta.facade;

import com.mycompany.versaobeta.models.Vendas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexandre Schmidt
 */
@Stateless
public class VendasFacade extends AbstractFacade<Vendas> {

    @PersistenceContext(unitName = "com.mycompany_VersaoBeta_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendasFacade() {
        super(Vendas.class);
    }
    
}
