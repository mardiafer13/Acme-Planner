package acme.testing.authenticated;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskCreateTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/taskPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex,final String title,final String description, final String begin, final String end ,final String workload, final String Link) {
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Manager", "Create a task");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("begin", begin);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("link", Link);
		super.clickOnSubmitButton("Create");

		super.clickOnMenu("Manager", "List my tasks");
		
		super.checkColumnHasValue(recordIndex, 1, begin);
		super.checkColumnHasValue(recordIndex, 2, end);
		super.checkColumnHasValue(recordIndex, 3, title);
		
	}
	
//	@ParameterizedTest
//	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
//	@Order(10)
//	public void createNegative(final int recodIndex, final String author, final String text, final String info) {
//		
//		super.clickOnMenu("Anonymous", "Create a shout");
//		super.fillInputBoxIn("author", author);
//		super.fillInputBoxIn("text", text);
//		super.fillInputBoxIn("info", info);
//		super.clickOnSubmitButton("Shout!");
//		super.checkErrorsExist();
//		
//	
//			
//		}
}
