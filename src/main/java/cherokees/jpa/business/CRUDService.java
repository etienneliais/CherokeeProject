package cherokees.jpa.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.manager.EmFactory;

public class CRUDService {

	
	public List<Collaborator> findAllCollaborators(){
		EntityManager emCollaborators = EmFactory.createEntityManager();
		List<Collaborator> searchedCollaborators =  new ArrayList();
		return emCollaborators.createQuery("select c from Collaborator c", Collaborator.class).getResultList();
		
	}
	
	
	public List<Collaborator> findCollaboratorById(int id){
		EntityManager emCollaborator = EmFactory.createEntityManager();
		List<Collaborator> searchedCollaborator =  new ArrayList();
		Query q =emCollaborator.createQuery("select c from Collaborator c where id=:id", Collaborator.class);
		q.setParameter("id", id);
		searchedCollaborator = (List<Collaborator>) q.getResultList();
		return searchedCollaborator;
		
	}
	
	
}
