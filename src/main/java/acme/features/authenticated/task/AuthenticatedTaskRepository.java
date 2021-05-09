/*
 * AuthenticatedAnnouncementRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.task;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);

	@Query("select t from Task t where t.isPublic = 1")
	Collection<Task> findPublicTasks();

	@Query("select t from Task t where t.isPublic = 1 and t.periodFinal < ?1")
	Collection<Task> findPublicFinishedTasks(Date now);
}
