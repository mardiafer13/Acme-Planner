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
		
		// Accedemos como administrador
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "List spam words");
		
		// Accedemos a cada registro
		super.clickOnListingRecord(recordIndex);
		
		// Introducimos los nuevos valores
		super.fillInputBoxIn("spamWords", spam);
		super.fillInputBoxIn("spamThreshold", threshold + "");
		super.clickOnSubmitButton("Update");
		
		super.clickOnListingRecord(recordIndex);
		
		// Comprobamos valor de la columna
		super.checkInputBoxHasValue("spamWords", spam);
		//super.checkInputBoxHasValue("spamThreshold", threshold+ "");

		// Cerramos sesión
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatenegative(final int recordIndex,final String spam, final Double threshold) {
		// Accedemos como administrador
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "List spam words");
		
		// Accedemos a cada registro
		super.clickOnListingRecord(recordIndex);
		
		// Introducimos los nuevos valores
		super.fillInputBoxIn("spamWords", spam);
		super.fillInputBoxIn("spamThreshold", threshold + "");
		super.clickOnSubmitButton("Update");
		
		// Comprobamos que hay errores
		super.checkErrorsExist();
		
		//Cerramos sesión
		super.signOut();
	}
}
