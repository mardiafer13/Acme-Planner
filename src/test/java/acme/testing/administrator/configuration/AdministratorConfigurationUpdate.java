package acme.testing.administrator.configuration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorConfigurationUpdate extends AcmePlannerTest{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatepositive(final int recordIndex,final String spam, final Double threshold) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "List spam words");
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("spamWords", spam);
		super.fillInputBoxIn("spamThreshold", threshold + "");
		super.clickOnSubmitButton("Update");
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("spamWords", spam);
		//super.checkInputBoxHasValue("spamThreshold", threshold+ "");

		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatenegative(final int recordIndex,final String spam, final Double threshold) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "List spam words");
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("spamWords", spam);
		super.fillInputBoxIn("spamThreshold", threshold + "");
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
		
		super.signOut();
	}
}
