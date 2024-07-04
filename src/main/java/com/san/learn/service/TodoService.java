package com.san.learn.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.san.learn.entity.Todo;

@Transactional
public class TodoService {

	@PersistenceContext
	EntityManager entityManager;

	public Todo create(Todo todo) {
		entityManager.persist(todo);
		return todo;
	}

	public Todo update(Todo todo) {
		entityManager.merge(todo);
		return todo;
	}

	public List<Todo> getTodos() {
		return entityManager
				.createQuery("SELECT t FROM Todo t", Todo.class)
				.getResultList();
	}

	public Todo findById(Long id) {
		return entityManager
				.createNamedQuery("Todo.findById", Todo.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
