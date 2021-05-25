/*
 * AnonymousShoutCreateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.shout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.shouts.Shout;
import acme.features.administrator.Configuration.AdministratorConfigurationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousShoutRepository			repository;

	@Autowired
	protected AdministratorConfigurationRepository	repositorySpamwords;

	// AbstractCreateService<Administrator, Shout> interface --------------


	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;

		return true;

	}

	@Override
	public void bind(final Request<Shout> request, final Shout entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "info");
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request != null;

		
		Shout result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Shout();
		result.setMoment(moment);

		return result;
	}

	@Override
    public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;

        final List<Configuration> sp = this.repository.findManySpamWord();
        final List<Configuration> lsp = new ArrayList<>();
        lsp.addAll(sp);
        
        for (int i = 0; i < lsp.size(); i++) {
            if(lsp.get(i).isSpam(entity.getText())){
                errors.state(request, false, "text", "anonymous.message.form.error.spam");
            }
            if(lsp.get(i).isSpam(entity.getAuthor())) {
            	 errors.state(request, false, "author", "anonymous.message.form.error.spam.author");
            }
        }
        
	}
	
	
	@Override
	public void create(final Request<Shout> request, final Shout entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
