package com.san.learn.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@NamedQueries(
		@NamedQuery(name = "Todo.findById", query = "select t from Todo t where t.id = :id")
)
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String task;
	private LocalDate dueDate;
	private boolean isCompleted;
	private LocalDate dateCompleted;
	private LocalDate dateCreated;

	@PrePersist
	private void init() {
		setDateCreated(LocalDate.now());
	}
}
