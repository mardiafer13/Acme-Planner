package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskCreateTest extends AcmePlannerTest{
	
	@ParameterizedTest
    @CsvFileSource(resources = "/manager/task/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void createPositive(final int recordIndex,final String title,final String description, final String periodInitial, final String periodFinal ,final String workloadInHours, final String Link, final Boolean isPublic) {
        
		// Accedemos como manager
		super.signIn("manager1", "manager1");
		
		// Accedemos al formulario de crear una tarea
        super.clickOnMenu("Manager", "Create a task");
        
        // Añadimos los valores
        super.fillInputBoxIn("title", title);
        super.fillInputBoxIn("description", description);
        super.fillInputBoxIn("periodInitial", periodInitial);
        super.fillInputBoxIn("periodFinal", periodFinal);
        super.fillInputBoxIn("workloadInHours", workloadInHours);
        super.fillInputBoxIn("link", Link);
        super.fillInputBoxIn("isPublic", String.valueOf(isPublic));
    
        // Pulsamos el boton
        super.clickOnSubmitButton("Create");
    }
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createNegative(final int recordIndex, final String title, final String description, final String periodInitial, final String periodFinal, final String workloadInHours, final String Link, final Boolean isPublic) {

		// Accedemos como manager
		super.signIn("manager1", "manager1");

		// Accedemos al formulario de crear una tarea
		super.clickOnMenu("Manager", "Create a task");

		// Añadimos los valores
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("periodInitial", periodInitial);
		super.fillInputBoxIn("periodFinal", periodFinal);
		super.fillInputBoxIn("workloadInHours", workloadInHours);
		super.fillInputBoxIn("link", Link);
		super.fillInputBoxIn("isPublic", String.valueOf(isPublic));

		// Pulsamos el boton
		super.clickOnSubmitButton("Create");

		// Debe haber errores
		super.checkErrorsExist();
	}
}
