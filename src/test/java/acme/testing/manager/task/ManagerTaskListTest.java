package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskListTest extends AcmePlannerTest {

	
	@ParameterizedTest
    @CsvFileSource(resources = "/manager/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void taskShowServiceTest(final int recordIndex,final String title,final String description, final String periodInitial, final String periodFinal ,final String workloadInHours, final String Link) {
        
		// Accedemos como manager
		super.signIn("manager1", "manager1");
		
		// Accedemos a la vista de sus tareas
        super.clickOnMenu("Manager", "List my tasks");

        // Comprobamos cada columna
        super.checkColumnHasValue(recordIndex, 0, periodInitial);
        super.checkColumnHasValue(recordIndex, 1, periodFinal);
        super.checkColumnHasValue(recordIndex, 2, title);

        // Accedemos a un registro
        super.clickOnListingRecord(recordIndex);

        // Comprobamos cada valor
        super.checkInputBoxHasValue("periodInitial", periodInitial);
        super.checkInputBoxHasValue("periodFinal", periodFinal);
        super.checkInputBoxHasValue("title", title);
        super.checkInputBoxHasValue("description", description);
        super.checkInputBoxHasValue("workloadInHours", workloadInHours);
        super.checkInputBoxHasValue("link", Link);

        // Cerramos sesion
        super.signOut();
    }
}
