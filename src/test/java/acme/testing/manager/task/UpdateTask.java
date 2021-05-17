package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;


public class UpdateTask extends AcmePlannerTest{
	
		//Test cases----------------------
		
		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/task/listFinishPublicTasks.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void updateTasksPositive(final int recordIndex,final String title, final String description,final String periodInitial, final String periodFinal, final String workload, final String link, final Boolean isPublic) {
			//Con que usuario entramos
			super.signIn("manager1", "manager1");
			
			//Donde debe entrar para hacer la comprobacion
			super.clickOnMenu("Manager", "List my tasks");
			
			//Comprobar en que posicion del listado se encuentra el atributo
			super.checkColumnHasValue(recordIndex, 0, periodInitial);
			super.checkColumnHasValue(recordIndex, 1, periodFinal);
			super.checkColumnHasValue(recordIndex, 2, title);
			
			//Clica
			super.clickOnListingRecord(recordIndex);
						
			//Esto es si final se necesita poner final algo en final el input
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("periodInitial", periodInitial);
			super.fillInputBoxIn("periodFinal", periodFinal);
			super.fillInputBoxIn("description", description);
			super.fillInputBoxIn("link", link);
			super.fillInputBoxIn("isPublic", String.valueOf(isPublic));
			super.clickOnSubmitButton("Update");
			super.checkErrorsExist();
			
			super.signOut();
			
		}
}
