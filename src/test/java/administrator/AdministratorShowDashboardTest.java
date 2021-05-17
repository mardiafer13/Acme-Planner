
package administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator-dashboard/dashboard.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String publicTasks, final String privateTasks, final String finishedTasks, final String nonFinishedTasks, final String averageWorkFlow, final String deviationWorkFlow, final String maxWorkFlow,
		final String minWorkFlow, final String averageExecutionPeriod, final String deviationExecutionPeriod, final String maxExecutionPeriod, final String minExecutionPeriod) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");

		super.checkColumnHasValue(recordIndex, 0, publicTasks);
		super.checkColumnHasValue(recordIndex, 1, privateTasks);
		super.checkColumnHasValue(recordIndex, 2, finishedTasks);
		super.checkColumnHasValue(recordIndex, 3, nonFinishedTasks);
		super.checkColumnHasValue(recordIndex, 4, averageWorkFlow);
		super.checkColumnHasValue(recordIndex, 5, deviationWorkFlow);
		super.checkColumnHasValue(recordIndex, 6, maxWorkFlow);
		super.checkColumnHasValue(recordIndex, 7, minWorkFlow);
		super.checkColumnHasValue(recordIndex, 8, averageExecutionPeriod);
		super.checkColumnHasValue(recordIndex, 9, deviationExecutionPeriod);
		super.checkColumnHasValue(recordIndex, 10, maxExecutionPeriod);
		super.checkColumnHasValue(recordIndex, 11, minExecutionPeriod);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("publicTasks", publicTasks);
		super.checkInputBoxHasValue("privateTasks", privateTasks);
		super.checkInputBoxHasValue("finishedTasks", finishedTasks);
		super.checkInputBoxHasValue("nonFinishedTasks", nonFinishedTasks);
		super.checkInputBoxHasValue("averageWorkFlow", averageWorkFlow);
		super.checkInputBoxHasValue("deviationWorkFlow", deviationWorkFlow);
		super.checkInputBoxHasValue("maxWorkFlow", maxWorkFlow);
		super.checkInputBoxHasValue("minWorkFlow", minWorkFlow);
		super.checkInputBoxHasValue("averageExecutionPeriod", averageExecutionPeriod);
		super.checkInputBoxHasValue("deviationExecutionPeriod", deviationExecutionPeriod);
		super.checkInputBoxHasValue("maxExecutionPeriod", maxExecutionPeriod);
		super.checkInputBoxHasValue("maxExecutionPeriod", minExecutionPeriod);

		this.signOut();

	}
}
