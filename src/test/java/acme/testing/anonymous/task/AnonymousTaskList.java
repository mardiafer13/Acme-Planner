package acme.testing.anonymous.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousTaskList extends AcmePlannerTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListRecent(final int recordIndex,final String title, final String description, final String InitialPeriod, final String FinalPeriod, final String Link) {
		
		
		super.clickOnMenu("Anonymous", "List unfinished tasks");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, InitialPeriod);
		super.checkColumnHasValue(recordIndex, 3, FinalPeriod);
		super.checkColumnHasValue(recordIndex, 3, Link);
		
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("initialPeriod", InitialPeriod);
		super.checkInputBoxHasValue("finalPeriod", FinalPeriod);
		super.checkInputBoxHasValue("title", Link);
	}
	
}
