package com.sopra.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cherokees.jpa.entities.Training;

public class CRUDTrainingService {

	@PersistenceContext
	EntityManager em;

	public List<Training> findAllTrainings() {
		return em.createQuery("SELECT t from Training t", Training.class).getResultList();
	}

	private Training findTrainingById(int trainingId) {
		return em.find(Training.class, trainingId);
	}

	public void delete(int id) {
		Training training = findTrainingById(id);
		if (training != null)
			em.remove(training);
	}

	public List<Training> search(BigDecimal nbDays, String place, String trainingName, Date dueDate, Date realDate,
			String provider) {
		List<Training> trainingResult = new ArrayList<>();
		return trainingResult;
	}

	public Training createOrUpdate(Training training) {
		if (training.getId() == null)
			em.persist(training);
		else
			training = em.merge(training);
		return training;
	}
}
