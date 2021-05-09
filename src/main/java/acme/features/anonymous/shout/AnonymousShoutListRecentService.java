package acme.features.anonymous.shout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousShoutListRecentService implements AbstractListService<Anonymous, Shout> {

	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "moment", "info");
	}

	
	@Override
	public List<Shout> findMany(final Request<Shout> request) {
		assert request != null;
		final List<Shout> res = new ArrayList<>();
		final Collection<Shout> shouts = this.repository.findMany();
		final Date now = new Date();
		for (final Shout s : shouts) {
			if (this.restarMeses(s.getMoment(), 1).after(now)) {
				res.add(s);
			}
		}
		Collections.sort(res, Comparator.comparing(x -> x.getMoment()));
		return res;
	}

	public Date restarMeses(final Date fecha, final int meses) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, meses);
		return calendar.getTime();
	}
}
