
package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@Test
	public void dashboard() {
		// Accedemos como administrador
		super.signIn("administrator", "administrator");
		// Accedemos al dashboard
		super.clickOnMenu("Administrator", "Dashboard");
		// Cerramos sesion
		super.signOut();
	}
	
	@Test
	public void emptyDashboard() {
		// Accedemos como administrador
		this.signIn("administrator", "administrator");
		// Populamos con datos iniciales
		super.clickOnMenu("Administrator", "Populate DB (initial)");
		// Accedemos al dashboard
		super.clickOnMenu("Administrator", "Dashboard");
		// Cerramos sesion
		super.signOut();
	}
	
}
