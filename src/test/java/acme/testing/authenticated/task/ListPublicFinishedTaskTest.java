package acme.testing.authenticated.task;

import org.junit.jupiter.api.BeforeAll;

import acme.framework.helpers.StringHelper;
import acme.testing.AcmeTest;

public abstract class ListPublicFinishedTaskTest extends AcmeTest {

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(false);

		this.navigateHome();
		this.signIn("manager1", "manager1");
		super.clickOnMenu("Authenticated", "List finished tasks");
		super.checkAlertExists(true);
		this.signOut();
	}

	//Business methods --------------------

	protected void signIn(final String username, final String password) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);

		super.navigateHome();
		super.clickOnMenu("Sign in", null);
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("remember", "true");
		super.clickOnSubmitButton("Sign in");
		super.checkSimplePath("/master/welcome");
		super.checkLinkExists("Account");

	}
	
	protected void signOut() {
		super.navigateHome();
		super.clickOnMenu("Sign out", null);
		super.checkSimplePath("/master/welcome");
	}

}

