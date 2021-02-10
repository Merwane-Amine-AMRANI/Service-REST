package org.amrani.exo4;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommuneEJB {

	@PersistenceContext(unitName = "tp-javaee")
	private EntityManager em;

	public Commune findbyCodePostal(String codePostal) {
		return em.find(Commune.class, codePostal);
	}

	public boolean insertIntoBase(Commune commune) {
		Commune com = em.find(Commune.class, commune.getCodePostal());
		if (com != null) {
			return true;
		} else {
			em.persist(commune);
			return false;
		}
	}

	public void deleteByCodePostal(String codePostal) {
		Commune commune = this.findbyCodePostal(codePostal);
		em.remove(commune);
	}

	public void updatebycodePostal(String name, String codePostal) {
		Commune commune = this.findbyCodePostal(codePostal);
		commune.setName(name);
	}

}
