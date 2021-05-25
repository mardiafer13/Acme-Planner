package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskDelete extends AcmePlannerTest {

	//Test cases----------------------

	// En este test se va comprobar que se pueden eliminar todas las tareas de un manager.
	// El resultado esperado es que cada una de dichas tareas se elimine correctamente.
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/delete.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksPositive(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

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
		super.checkInputBoxHasValue("workloadInHours", workloadInHours);
		super.checkInputBoxHasValue("link", link);
		super.clickOnSubmitButton("Delete");
		
		super.signOut();

	}
	
	
	//Test delete negativo de anonymous
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksNegativeAnonymous(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

		// Clica en el menú para acceder a las tareas del manager
		this.driver.get("localhost:8080/Acme-Planner/manager/task/show?id=20");
		
		super.checkPanicExists();

	}
	
	//Test delete negativo de administrador
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksNegativeAdministrator(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("administrator", "administrator");

		// Clica en el menú para acceder a las tareas del manager
		this.driver.get("localhost:8080/Acme-Planner/manager/task/show?id=20");
		
		super.checkPanicExists();
		
		super.signOut();

	}
	
	//Test delete negativo de employer
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksNegativeEmployer(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("employer1", "employer1");

		// Clica en el menú para acceder a las tareas del manager
		this.driver.get("localhost:8080/Acme-Planner/manager/task/show?id=20");
		
		super.checkPanicExists();

		super.signOut();

	}
	
	//Test delete negativo de worker
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksNegativeWorker(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("worker1", "worker1");

		// Clica en el menú para acceder a las tareas del manager
		this.driver.get("localhost:8080/Acme-Planner/manager/task/show?id=20");
		
		super.checkPanicExists();
		
		super.signOut();
	}
	
	//Test delete negativo de otro manager
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/deleteNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void deleteTasksNegativeManager(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String link, final Boolean isPublic) {

		// Se logea con el usuario manager
		super.signIn("manager2", "manager2");

		// Clica en el menú para acceder a las tareas del manager
		this.driver.get("localhost:8080/Acme-Planner/manager/task/show?id=20");
		
		super.checkPanicExists();
		
		super.signOut();
	}
	
	
}
