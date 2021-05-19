package acme.testing.administrator.configuration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorConfigurationList extends AcmePlannerTest {

	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListRecent(final int recordIndex,final String spam, final Double threshold) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "List spam words");
		
		super.checkColumnHasValue(recordIndex, 0, spam);
//		super.checkColumnHasValue(recordIndex, 0, spam);
		
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("spamWords", spam);
//		super.checkInputBoxHasValue("spamThreshold", threshold.toString());

		super.signOut();
	}
}
