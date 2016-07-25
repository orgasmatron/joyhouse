/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Rooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AlshevskiYV
 */
@Stateless
public class RoomsFacade extends AbstractFacade<Rooms> {

    @PersistenceContext(unitName = "Cortez1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoomsFacade() {
        super(Rooms.class);
    }
    
}
