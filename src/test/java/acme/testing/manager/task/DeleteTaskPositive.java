
package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class DeleteTaskPositive extends AcmePlannerTest {

	//Test cases----------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteTasks.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksPositive(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {

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

		//Comprobar el valor del atributo
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("periodInitial", periodInitial);
		super.checkInputBoxHasValue("periodFinal", periodFinal);
		super.checkInputBoxHasValue("workloadInHours", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("isPublic", String.valueOf(isPublic));
		super.clickOnSubmitButton("Delete");
		
		super.signOut();

	}
}
