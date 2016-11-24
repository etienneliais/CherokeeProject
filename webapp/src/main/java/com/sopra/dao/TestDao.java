package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cherokees.jpa.entities.Collaborator;

@Stateless
public class TestDao {
	@PersistenceContext(unitName = "cherokee")
	EntityManager em;

	public List<Collaborator> test() {
		return em.createQuery("from Collaborator c", Collaborator.class).getResultList();
	}

	public Collaborator findCollaboratorById(int collaboratorId) {
		return em.find(Collaborator.class, collaboratorId);
	}

	public List<Collaborator> findAll() {
		return em.createQuery("SELECT c FROM Collaborator c", Collaborator.class).getResultList();
	}

	public void delete(int id) {
		Collaborator f = findCollaboratorById(id);
		if (f != null) {
			em.remove(f);
		}
	}

	public Collaborator createOrUpdate(Collaborator collaborator) {
		System.out.println("collaborator is " + collaborator);
		if (collaborator.getId() == null)
			em.persist(collaborator);
		else
			collaborator = em.merge(collaborator);
		return collaborator;
	}

	public List<Collaborator> search(String firstName, String lastName, String codeAgency) {
		List<Collaborator> result = new ArrayList<>();

		return result;
	}
}
