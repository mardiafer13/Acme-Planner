/*
 * AnonymousShoutController.java
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

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.shouts.Shout;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/shout/")
public class AnonymousShoutController extends AbstractController<Anonymous, Shout> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousShoutListRecentService listRecentService;
	
	@Autowired
	protected AnonymousShoutCreateService	createService;

	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCustomCommand(CustomCommand.LIST_RECENT, BasicCommand.LIST, this.listRecentService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
