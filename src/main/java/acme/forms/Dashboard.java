/*
 * Dashboard.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Double						averageNumberOfJobsPerEmployer;
	Double						averageNumberOfApplicationsPerWorker;
	Double						avegageNumberOfApplicationsPerEmployer;
	Double						ratioOfPendingApplications;
	Double						ratioOfAcceptedApplications;
	Double						ratioOfRejectedApplications;
	
	//Esto es para la tabla relacionado con las tareas
	Double                      numberPublicTask;
	Double                      numberPrivateTask;
	Double						numberFinalTask;
	Double						numberNoFinalTask;
	Double						averageDurationPeriodTasks;
	Double						deviationDurationPeriodTasks;
	Double						minimumDurationPeriodTasks;
	Double						maximumDurationPeriodTasks;
	Double						averageWorkloadTasks;
	Double						deviationWorkloadTasks;
	Double						minimumWorkloadTasks;
	Double						maximumWorkloadTasks;                   
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
