package acme.testing.authenticated;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskShowService extends AcmePlannerTest{
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/listTaskAuthenticated.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void taskShowServiceTest(final int recordIndex,final String title,final String description, final String periodInitial, final String periodFinal ,final String workloadInHours, final String Link) {
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Manager", "List my tasks");
		
		super.checkColumnHasValue(recordIndex, 0, periodInitial);
		super.checkColumnHasValue(recordIndex, 1, periodFinal);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("periodInitial", periodInitial);
		super.checkInputBoxHasValue("periodFinal", periodFinal);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("workloadInHours", workloadInHours);
		super.checkInputBoxHasValue("link", Link);
		
		super.signOut();
	}
}
