package acme.testing.authenticated;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskShowService extends AcmePlannerTest{
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/listTaskAuthenticated.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void taskShowServiceTest(final int recordIndex,final String title, final String description,final String periodInitial, final String periodFinal, final String workload, final String link) {
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Manager", "List my tasks");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, periodInitial);
		super.checkColumnHasValue(recordIndex, 3, periodFinal);
		super.checkColumnHasValue(recordIndex, 4, workload);
		super.checkColumnHasValue(recordIndex, 5, link);
		
		
		
		
		super.signOut();
	}
}
