/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.ejbs;

import capsoft.entities.TransactionTypes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author informatica
 */
@Stateless
public class TransactionTypesFacade extends AbstractFacade<TransactionTypes> {

    @PersistenceContext(unitName = "daybookPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionTypesFacade() {
        super(TransactionTypes.class);
    }
    
}
