package acme.features.administrator.spamWord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamWords.SpamWord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorSpamWordShowService implements AbstractShowService<Administrator, SpamWord>{

	@Autowired
	private AdministratorSpamWordRepository repository;


	@Override
	public boolean authorise(final Request<SpamWord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<SpamWord> request, final SpamWord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "spanishTranslation", "englishTranslation", "spamThreshold");
	}

	@Override
	public SpamWord findOne(final Request<SpamWord> request) {
		assert request != null;
		SpamWord result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}
}
