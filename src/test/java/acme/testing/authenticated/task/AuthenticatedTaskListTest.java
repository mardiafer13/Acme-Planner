
package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskListTest extends AcmePlannerTest {

	//Test cases----------------------

	// En este test se va comprobar que se listan correctamente todas las tareas públicas y finalizadas de un usuario autenticado.
	// Lo esperado es que cada un de los campos de una tarea coincidan con los establecidos en el archivo csv.
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPublicFinishedTasks(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link) {

		// Accedemos como manager
		super.signIn("manager1", "manager1");

		// Accedemos a la lista de sus tareas
		super.clickOnMenu("Authenticated", "List finished tasks");

		// Comprobamos cada columna
		super.checkColumnHasValue(recordIndex, 0, periodInitial);
		super.checkColumnHasValue(recordIndex, 1, periodFinal);
		super.checkColumnHasValue(recordIndex, 2, title);

		// Accedemos a un registro
		super.clickOnListingRecord(recordIndex);

		// Comprobamos cada valor
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("periodInitial", periodInitial);
		super.checkInputBoxHasValue("periodFinal", periodFinal);
		super.checkInputBoxHasValue("workloadInHours", workload);
		super.checkInputBoxHasValue("link", link);

		// Cerramos sesion
		super.signOut();

	}
}
