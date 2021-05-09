
package acme.features.anonymous.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTaskListService implements AbstractListService<Anonymous, Task> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousTaskRepository repository;

	// AbstractListService<Administrator, Shout> interface --------------


	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "periodInitial", "periodFinal", "description", "link", "isPublic");

	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		final List<Task> res = new ArrayList<>();
		final Collection<Task> tasksPublics = this.repository.findPublicTasks();
		final Date now = new Date();
		for (final Task t : tasksPublics) {
			if (t.getPeriodFinal().after(now)) {
				res.add(t);
			}
		}
		Collections.sort(res, Comparator.comparing(x -> x.getWorkloadInHours()));
		return res;
	}

}
