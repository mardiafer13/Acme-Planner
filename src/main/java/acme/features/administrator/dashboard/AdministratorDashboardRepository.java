/*
 * AdministratorDashboardRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double averageNumberOfJobsPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double averageNumberOfApplicationsPerWorker();

	@Query("select avg(select count(a) from Application a where exists(select j from Job j where j.employer.id = e.id and a.job.id = j.id)) from Employer e")
	Double averageNumberOfApplicationsPerEmployer();

	@Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.PENDING")
	Double ratioOfPendingApplications();

	@Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.ACCEPTED")
	Double ratioOfAcceptedApplications();

	@Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.REJECTED")
	Double ratioOfRejectedApplications();
	
	
	//Parte del entregable
	@Query("select t from Task t")
	Collection<Task> findTasks();
	
	
	@Query("select 1.0 * count(t) from Task t  where t.isPublic= 1")
	Double numberPublicTask();
	
	@Query("select 1.0 * count(t) from Task t  where t.isPublic = 0")
	Double numberPrivateTask();
	
	@Query("select avg(t.workloadInHours) from Task t")
	Double averageWorkloadTasks();
	
	@Query("select stddev(t.workloadInHours) from Task t")
	Double deviationWorkloadTasks();
	
	@Query("select min(t.workloadInHours) from Task t")
	Double minimumWorkloadTasks();
	
	@Query("select max(t.workloadInHours) from Task t")
	Double maximumWorkloadTasks();
	

}
