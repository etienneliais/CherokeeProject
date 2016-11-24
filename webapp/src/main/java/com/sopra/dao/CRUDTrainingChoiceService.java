package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cherokees.jpa.entities.Collaborator;
import cherokees.jpa.entities.Training;
import cherokees.jpa.entities.TrainingChoice;

public class CRUDTrainingChoiceService {

	@PersistenceContext
	EntityManager em;
	
	public List<TrainingChoice> findAllTrainingChoices(){
		return em.createQuery("SELECT tc from TrainingChoice tc", TrainingChoice.class).getResultList();
	}
	private TrainingChoice findTrainingChoiceById(int trainingChoiceId) {
		return em.find(TrainingChoice.class, trainingChoiceId);
	}

	public void delete(int id) {
		TrainingChoice trainingChoice = findTrainingChoiceById(id);
		if (trainingChoice != null)
			em.remove(trainingChoice);
	}

	public List<Training> search(Collaborator collaborator, Training training) {
		List<Training> trainingChoiceResult = new ArrayList<>();
		return trainingChoiceResult;
	}
}
