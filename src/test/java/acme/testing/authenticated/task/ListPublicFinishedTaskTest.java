package acme.testing.authenticated.task;

import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public abstract class ListPublicFinishedTaskTest extends AcmePlannerTest {

	
	//Lifecycle management
	
	//Test cases
	
	@ParameterizedTest
	@CsvFileSource()
	@Order(10)
	public void createPositive(final int recordIndex,final String title, final Date periodInitial, final Date periodFinal, final String description, final String link, final Boolean isPublic) {
		//Con que usuario entramos
		super.signIn(this.contextHome, this.baseUrl);
		
		//Donde debe entrar para hacer la comprobacion
		super.clickOnMenu("Authenticate", "List all tasks");
		
//Esto es si se necesita poner algo en el input
//		super.fillInputBoxIn("title", title);
////		super.fillInputBoxIn("periodInitial", periodInitial);
////		super.fillInputBoxIn("periodFinal", periodFinal);
//		super.fillInputBoxIn("description", description);
//		super.fillInputBoxIn("link", link);
////		super.fillInputBoxIn("isPublic", isPublic);
		
		//Comprobar en que posicion del listado se encuentra el atributo
		super.checkColumnHasValue(recordIndex, 1, title);
		
		//Comprobar el valor del atributo
		super.checkInputBoxHasValue("title", title);
		
		super.signOut();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	@BeforeAll
//	public void beforeAll() {
//		super.beforeAll();
//
//		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
//		super.setAutoPausing(false);
//
//		this.navigateHome();
//		this.signIn("manager1", "manager1");
//		super.clickOnMenu("Authenticated", "List finished tasks");
//		super.checkAlertExists(true);
//		this.signOut();
//	}
//
//	//Business methods --------------------
//
//	protected void signIn(final String username, final String password) {
//		assert !StringHelper.isBlank(username);
//		assert !StringHelper.isBlank(password);
//
//		super.navigateHome();
//		super.clickOnMenu("Sign in", null);
//		super.fillInputBoxIn("username", username);
//		super.fillInputBoxIn("password", password);
//		super.fillInputBoxIn("remember", "true");
//		super.clickOnSubmitButton("Sign in");
//		super.checkSimplePath("/master/welcome");
//		super.checkLinkExists("Account");
//
//	}
//	
//	protected void signOut() {
//		super.navigateHome();
//		super.clickOnMenu("Sign out", null);
//		super.checkSimplePath("/master/welcome");
//	}

}

