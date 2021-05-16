
package administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator-dashboard/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final Double numberPublicTask, final Double numberPrivateTask, final Double numberFinalTask, final Double numberNoFinalTask, final Double averageDurationPeriodTasks, final Double deviationDurationPeriodTasks,
		final Double minimumDurationPeriodTasks, final Double maximumDurationPeriodTasks, final Double averageWorkloadTasks, final Double deviationWorkloadTasks, final Double minimumWorkloadTasks, final Double maximumWorkloadTasks) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("administrator", "dashboard");
		
	

	}
}
