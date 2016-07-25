/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Categoryrooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AlshevskiYV
 */
@Stateless
public class CategoryroomsFacade extends AbstractFacade<Categoryrooms> {

    @PersistenceContext(unitName = "Cortez1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryroomsFacade() {
        super(Categoryrooms.class);
    }
    
}
