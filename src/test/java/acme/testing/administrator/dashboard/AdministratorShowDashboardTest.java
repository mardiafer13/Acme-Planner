
package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@Test
	public void dashboard() {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Dashboard");
		
		super.signOut();
	}
	
	@Test
	public void emptyDashboard() {
		this.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Populate DB (initial)");
		super.clickOnMenu("Administrator", "Dashboard");
		
		super.signOut();
	}
	
}
