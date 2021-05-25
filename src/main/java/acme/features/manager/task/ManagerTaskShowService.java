/*
 * AuthenticatedTaskShowService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerTaskShowService implements AbstractShowService<Manager, Task> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerTaskRepository repository;

	// AbstractShowService<Administrator, Announcement> interface --------------


	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		final Task tarea = this.findOne(request);
		final Integer id = tarea.getManager().getId();
		if(request.getPrincipal().getActiveRoleId() != id) {
			return false;
		}else {
			return true;
		}
	//	return true;
		
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "isPublic", "link", "periodFinal", "periodInitial", "title", "workloadInHours");		
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;

		Task result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneTaskById(id);

		return result;
	}

}
