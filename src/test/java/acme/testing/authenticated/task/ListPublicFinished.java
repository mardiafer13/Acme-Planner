
package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ListPublicFinished extends AcmePlannerTest {

	//Test cases----------------------

	// En este test se va comprobar que se listan correctamente todas las tareas públicas y finalizadas de un usuario autenticado.
	// Lo esperado es que cada un de los campos de una tarea coincidan con los establecidos en el archivo csv.
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/listFinishPublicTasks.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListPublicFinishedTasks(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link) {

		super.signIn("manager1", "manager1");

		super.clickOnMenu("Authenticated", "List finished tasks");

		super.checkColumnHasValue(recordIndex, 0, periodInitial);
		super.checkColumnHasValue(recordIndex, 1, periodFinal);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("periodInitial", periodInitial);
		super.checkInputBoxHasValue("periodFinal", periodFinal);
		super.checkInputBoxHasValue("workloadInHours", workload);
		super.checkInputBoxHasValue("link", link);

		super.signOut();

	}
}
