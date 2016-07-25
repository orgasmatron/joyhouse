/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Girls;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AlshevskiYV
 */
@Stateless
public class GirlsFacade extends AbstractFacade<Girls> {

    @PersistenceContext(unitName = "Cortez1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirlsFacade() {
        super(Girls.class);
    }
    
}
