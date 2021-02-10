package org.amrani.exo4;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MaireEJB {

	@PersistenceContext(unitName = "tp-javaee")
	private EntityManager em;

	public Maire findbyId(int id) {
		return em.find(Maire.class, id);
	}

}
