package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cherokees.jpa.entities.Collaborator;

public class CRUDCollaboratorService {

	@PersistenceContext
	EntityManager em;

	public List<Collaborator> findAllCollaborators() {
		return em.createQuery("SELECT c FROM Collaborator c", Collaborator.class).getResultList();
	}

	private Collaborator findCollaboratorById(int collaboratorId) {
		return em.find(Collaborator.class, collaboratorId);
	}

	public void delete(int id) {
		Collaborator collaborator = findCollaboratorById(id);
		if (collaborator != null)
			em.remove(collaborator);
	}

	public List<Collaborator> search(String firstName, String lastName, String codeAgency) {
		List<Collaborator> collaboratorResult = new ArrayList<>();
		return collaboratorResult;
	}

	public Collaborator createOrUpdate(Collaborator collaborator) {
		if (collaborator.getId() == null)
			em.persist(collaborator);
		else
			collaborator = em.merge(collaborator);
		return collaborator;
	}
}
