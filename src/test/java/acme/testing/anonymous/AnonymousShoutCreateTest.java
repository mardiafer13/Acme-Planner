
package acme.testing.anonymous;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousShoutCreateTest extends AcmePlannerTest {

	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recodIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "Create a shout");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		
		super.clickOnMenu("Anonymous", "List recent shouts");
		
		super.checkColumnHasValue(recodIndex, 1, author);
		super.checkColumnHasValue(recodIndex, 2, text);
		super.checkColumnHasValue(recodIndex, 3, info);
		
		super.clickOnListingRecord(recodIndex);
		
		super.checkInputBoxHasValue("author", author);
		super.checkInputBoxHasValue("text", text);
		super.checkInputBoxHasValue("info", info);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createNegative(final int recodIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "Create a shout");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		//super.checkErrorsExist();
		
		super.clickOnMenu("Anonymous", "List recent shouts");
		
		super.checkColumnHasValue(recodIndex, 1, author);
		super.checkColumnHasValue(recodIndex, 2, text);
		super.checkColumnHasValue(recodIndex, 3, info);
		
		super.clickOnListingRecord(recodIndex);
		
		super.checkInputBoxHasValue("author", author);
		super.checkInputBoxHasValue("text", text);
		super.checkInputBoxHasValue("info", info);
			
		}
}
