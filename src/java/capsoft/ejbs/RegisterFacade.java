/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.ejbs;

import capsoft.entities.Register;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author informatica
 */
@Stateless
public class RegisterFacade extends AbstractFacade<Register> {

    @PersistenceContext(unitName = "daybookPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisterFacade() {
        super(Register.class);
    }
    
}