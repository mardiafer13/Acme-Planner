
package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class UpdateTaskPositive extends AcmePlannerTest {

	//Test cases----------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/updateTasksPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateTasksPositive(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("manager1", "manager1");

		// Clica en el menú para acceder a las tareas del manager
		super.clickOnMenu("Manager", "List my tasks");

		// Checkea que se cumple que las columnas coinciden con los valores que indicamos
		super.checkColumnHasValue(recordIndex, 0, periodInitial);
		super.checkColumnHasValue(recordIndex, 1, periodFinal);
		super.checkColumnHasValue(recordIndex, 2, title);

		// Recorre cada uno de los valores
		super.clickOnListingRecord(recordIndex);

		// Los actualiza con los valores establecidos en el csv
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("periodInitial", periodInitial);
		super.fillInputBoxIn("periodFinal", periodFinal);
		super.fillInputBoxIn("workloadInHours", workload);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("isPublic", String.valueOf(isPublic));
		super.clickOnSubmitButton("Update");

		// Vuelve a recorrer los valores
		super.clickOnListingRecord(recordIndex);

		// Y por ultimo, comprueba que los valores se han actualizado correctamente
		// y coinciden con los del csv
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("periodInitial", periodInitial);
		super.checkInputBoxHasValue("periodFinal", periodFinal);
		super.checkInputBoxHasValue("workloadInHours", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("isPublic", String.valueOf(isPublic));

		super.signOut();

	}

	//	@ParameterizedTest
	//	@CsvFileSource(resources = "/manager/task/updateTasksPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	//	@Order(20)
	//	public void checkFieldsAreUpdated(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {
	//		// Se logea con el usuario manager
	//		super.signIn("manager1", "manager1");
	//
	//		// Clica en el menú para acceder a las tareas del manager
	//		super.clickOnMenu("Manager", "List my tasks");
	//		// Vuelve a recorrer los valores
	//		super.clickOnListingRecord(recordIndex);
	//
	//		// Y por ultimo, comprueba que los valores se han actualizado correctamente
	//		// y coinciden con los del csv
	//		super.checkInputBoxHasValue("title", title);
	//		super.checkInputBoxHasValue("description", description);
	//		super.checkInputBoxHasValue("periodInitial", periodInitial);
	//		super.checkInputBoxHasValue("periodFinal", periodFinal);
	//		super.checkInputBoxHasValue("workloadInHours", workload);
	//		super.checkInputBoxHasValue("link", link);
	//		super.checkInputBoxHasValue("isPublic", String.valueOf(isPublic));
	//
	//		//super.checkErrorsExist();
	//		
	//		super.signOut();
	//	}

//	@ParameterizedTest
//	@CsvFileSource(resources = "/manager/task/updateTasksNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
//	@Order(20)
//	public void updateTasksNegative(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {
//
//		// Se logea con el usuario manager
//		super.signIn("manager1", "manager1");
//
//		// Clica en el menú para acceder a las tareas del manager
//		super.clickOnMenu("Manager", "List my tasks");
//
//		// Checkea que se cumple que las columnas coinciden con los valores que indicamos
//		super.checkColumnHasValue(recordIndex, 0, periodInitial);
//		super.checkColumnHasValue(recordIndex, 1, periodFinal);
//		super.checkColumnHasValue(recordIndex, 2, title);
//
//		// Recorre cada uno de los valores
//		super.clickOnListingRecord(recordIndex);
//
//		// Los actualiza con los valores establecidos en el csv
//
//		super.fillInputBoxIn("title", title);
//		super.fillInputBoxIn("description", description);
//		super.fillInputBoxIn("periodInitial", periodInitial);
//		super.fillInputBoxIn("periodFinal", periodFinal);
//		super.fillInputBoxIn("workloadInHours", workload);
//		super.fillInputBoxIn("link", link);
//		super.fillInputBoxIn("isPublic", String.valueOf(isPublic));
//		super.clickOnSubmitButton("Update");
//
//		super.checkErrorsExist();
//
//		super.signOut();
//
//	}
}
