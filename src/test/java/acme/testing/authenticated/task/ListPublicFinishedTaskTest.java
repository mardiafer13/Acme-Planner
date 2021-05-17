package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ListPublicFinishedTaskTest extends AcmePlannerTest {

	
	//Lifecycle management------------------
	
	//Test cases----------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListPublicFinished(final int recordIndex,final String title, final String periodInitial, final String periodFinal, final String description, final String link, final String workload) {
		//Con que usuario entramos
		super.signIn("manager1", "manager1");
		
		//Donde debe entrar para hacer la comprobacion
		super.clickOnMenu("Authenticated", "List finished tasks");
		
		//Esto es si se necesita poner algo en el input
		//super.fillInputBoxIn("title", title);
		//super.fillInputBoxIn("periodInitial", periodInitial);
		//super.fillInputBoxIn("periodFinal", periodFinal);
		//super.fillInputBoxIn("description", description);
		//super.fillInputBoxIn("link", link);
		//super.fillInputBoxIn("isPublic", isPublic);
		
		//Comprobar en que posicion del listado se encuentra el atributo
		super.checkColumnHasValue(recordIndex, 0, periodInitial);
		super.checkColumnHasValue(recordIndex, 1, periodFinal);
		super.checkColumnHasValue(recordIndex, 2, title);
		
		//Clica
		super.clickOnListingRecord(recordIndex);
		
		//Comprobar el valor del atributo
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("begin", periodInitial);
		super.checkInputBoxHasValue("end", periodFinal);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		
		
		super.signOut();
	}
}

