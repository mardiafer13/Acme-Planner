package acme.features.administrator.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorConfigurationShowService implements AbstractShowService<Administrator, Configuration>{

	@Autowired
	private AdministratorConfigurationRepository repository;


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
	public Configuration findOne(final Request<Configuration> request) {
		assert request != null;
		Configuration result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}
}
