
package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskUpdate extends AcmePlannerTest {

	//Test cases----------------------

	// En este test se va comprobar la edición de las tareas de un manager.
	// Al tratarse de un caso de prueba positivo, todos los valores incluidos en el archivo csv son valores correctos
	// que cumplen las restricciones.
	
	// El resultado esperado es que cada una de las tareas se hayan editado correctamente con los valores establecidos
	// en el archivo csv.

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateTasksPositive(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("manager1", "manager1");

		// Clica en el menú para acceder a las tareas del manager
		super.clickOnMenu("Manager", "List my tasks");

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

		// Cerramos sesion
		super.signOut();

	}
	

		// En este test se va comprobar la edición de las tareas de un manager.
		// Al tratarse de un caso de prueba negativo, van a saltar las restricciones de cada uno de los campos
		// que tiene una tarea. Las restricciones que se van a violar en este test son: dejar el título o
		// la descripción vacías, poner fechas anteriores a la actual, establecer la fecha de inicio de una
		// tarea después de la fecha de fin, usar spam words o incluir una url con formato correcto.
		
		// Lo esperado es que para cada uno de los campos editados con valores incorrectos, salte un error indicando que
		// ese campo viola una restricción
		
		@ParameterizedTest
		@CsvFileSource(resources = "/manager/task/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(20)
		public void updateTasksNegative(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {

			// Se logea con el usuario manager
			super.signIn("manager1", "manager1");

			// Clica en el menú para acceder a las tareas del manager
			super.clickOnMenu("Manager", "List my tasks");

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
			
			// Y comprueba que existen errores
			super.checkErrorsExist();
				
			// Cerramos sesion
			super.signOut();

		}

}
