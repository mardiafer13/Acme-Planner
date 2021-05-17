
package administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator-dashboard/dashboard.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String numberPublicTask, final String numberPrivateTask, final String numberFinalTask, final String numberNoFinalTask, final String averageDurationPeriodTasks, final String deviationDurationPeriodTasks, final String minimumDurationPeriodTasks,
		final String maximumDurationPeriodTasks, final String averageWorkloadTasks, final String deviationWorkloadTasks, final String minimumWorkloadTasks, final String maximumWorkloadTasks) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");

		super.checkColumnHasValue(recordIndex, 0, numberPublicTask);
		super.checkColumnHasValue(recordIndex, 1, numberPrivateTask);
		super.checkColumnHasValue(recordIndex, 2, numberFinalTask);
		super.checkColumnHasValue(recordIndex, 3, numberNoFinalTask);
		super.checkColumnHasValue(recordIndex, 4, averageDurationPeriodTasks);
		super.checkColumnHasValue(recordIndex, 5, deviationDurationPeriodTasks);
		super.checkColumnHasValue(recordIndex, 6, minimumDurationPeriodTasks);
		super.checkColumnHasValue(recordIndex, 7, maximumDurationPeriodTasks);
		super.checkColumnHasValue(recordIndex, 8, averageWorkloadTasks);
		super.checkColumnHasValue(recordIndex, 9, deviationWorkloadTasks);
		super.checkColumnHasValue(recordIndex, 10, minimumWorkloadTasks);
		super.checkColumnHasValue(recordIndex, 11, maximumWorkloadTasks);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("numberPublicTask", numberPublicTask);
		super.checkInputBoxHasValue("numberPrivateTask", numberPrivateTask);
		super.checkInputBoxHasValue("numberFinalTask", numberFinalTask);
		super.checkInputBoxHasValue("numberNoFinalTask", numberNoFinalTask);
		super.checkInputBoxHasValue("averageDurationPeriodTasks", averageDurationPeriodTasks);
		super.checkInputBoxHasValue("deviationDurationPeriodTasks", deviationDurationPeriodTasks);
		super.checkInputBoxHasValue("minimumDurationPeriodTasks", minimumDurationPeriodTasks);
		super.checkInputBoxHasValue("maximumDurationPeriodTasks", maximumDurationPeriodTasks);
		super.checkInputBoxHasValue("averageWorkloadTasks", averageWorkloadTasks);
		super.checkInputBoxHasValue("deviationWorkloadTasks", deviationWorkloadTasks);
		super.checkInputBoxHasValue("minimumWorkloadTasks", minimumWorkloadTasks);
		super.checkInputBoxHasValue("maximumWorkloadTasks", maximumWorkloadTasks);

		this.signOut();

	}
}
