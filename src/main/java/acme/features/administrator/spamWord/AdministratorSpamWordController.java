package acme.features.administrator.spamWord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.configuration.Configuration;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/configuration/")
public class AdministratorSpamWordController extends AbstractController<Administrator, Configuration>{

	
	@Autowired
	private AdministratorSpamWordListService	listService;
	
	@Autowired
	private AdministratorSpamWordUpdateService updateService;
	
	@Autowired
	private AdministratorSpamWordShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}
}
