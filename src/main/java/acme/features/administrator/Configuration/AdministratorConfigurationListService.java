package acme.features.administrator.Configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorConfigurationListService implements AbstractListService<Administrator, Configuration>{

	@Autowired
	AdministratorConfigurationRepository repository;


	@Override
	public boolean authorise(final Request<Configuration> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "spamWords","spamThreshold");
	}

	@Override
	public Collection<Configuration> findMany(final Request<Configuration> request) {
		assert request != null;
		Collection<Configuration> result;
		result = this.repository.findManyAll();
		return result;
	}

}

