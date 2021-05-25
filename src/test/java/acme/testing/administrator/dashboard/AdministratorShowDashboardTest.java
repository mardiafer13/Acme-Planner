
package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.testing.AcmePlannerTest;

public class AdministratorShowDashboardTest extends AcmePlannerTest {

	@Test
	@Order(30)
	public void administratoDashboardPositive() {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");

		By locatorNumberPublicTasks;
		locatorNumberPublicTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td");
		final WebElement numberPublicTasks = this.driver.findElement(locatorNumberPublicTasks);
		Assertions.assertEquals("11.00", numberPublicTasks.getText());

		final By locatorNumberPrivateTask;
		locatorNumberPrivateTask = By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td");
		final WebElement numberPrivateTask = this.driver.findElement(locatorNumberPrivateTask);
		Assertions.assertEquals("1.00", numberPrivateTask.getText());

		By locatorNumberFinalTask;
		locatorNumberFinalTask = By.xpath("/html/body/div[2]/div/table/tbody/tr[3]/td");
		final WebElement numberFinalTask = this.driver.findElement(locatorNumberFinalTask);
		Assertions.assertEquals("6.00", numberFinalTask.getText());

		final By locatorNumberNoFinalTask;
		locatorNumberNoFinalTask = By.xpath("/html/body/div[2]/div/table/tbody/tr[4]/td");
		final WebElement numberNoFinalTask = this.driver.findElement(locatorNumberNoFinalTask);
		Assertions.assertEquals("6.00", numberNoFinalTask.getText());

		final By locatorAverageDurationPeriodTasks;
		locatorAverageDurationPeriodTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[5]/td");
		final WebElement averageDurationPeriodTasks = this.driver.findElement(locatorAverageDurationPeriodTasks);
		Assertions.assertEquals("20,623.00", averageDurationPeriodTasks.getText());

		By locatorDeviationDurationPeriodTasks;
		locatorDeviationDurationPeriodTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[6]/td");
		final WebElement deviationDurationPeriodTasks = this.driver.findElement(locatorDeviationDurationPeriodTasks);
		Assertions.assertEquals("1,522.43", deviationDurationPeriodTasks.getText());

		By locatorMinimumDurationPeriodTasks;
		locatorMinimumDurationPeriodTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[7]/td");
		final WebElement minimumDurationPeriodTasks = this.driver.findElement(locatorMinimumDurationPeriodTasks);
		Assertions.assertEquals("1.00", minimumDurationPeriodTasks.getText());

		By locatorMaximumDurationPeriodTasks;
		locatorMaximumDurationPeriodTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[8]/td");
		final WebElement maximumDurationPeriodTasks = this.driver.findElement(locatorMaximumDurationPeriodTasks);
		Assertions.assertEquals("3,673.00", maximumDurationPeriodTasks.getText());

		By locatorAverageWorkloadTasks;
		locatorAverageWorkloadTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[9]/td");
		final WebElement averageWorkloadTasks = this.driver.findElement(locatorAverageWorkloadTasks);
		Assertions.assertEquals("1.37", averageWorkloadTasks.getText());

		By locatorDeviationWorkloadTasks;
		locatorDeviationWorkloadTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[10]/td");
		final WebElement deviationWorkloadTasks = this.driver.findElement(locatorDeviationWorkloadTasks);
		Assertions.assertEquals("1.37", deviationWorkloadTasks.getText());

		By locatorMinimumWorkloadTasks;
		locatorMinimumWorkloadTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[11]/td");
		final WebElement minimumWorkloadTasks = this.driver.findElement(locatorMinimumWorkloadTasks);
		Assertions.assertEquals("0.14", minimumWorkloadTasks.getText());

		final By locatorMaximumWorkloadTasks;
		locatorMaximumWorkloadTasks = By.xpath("/html/body/div[2]/div/table/tbody/tr[12]/td");
		final WebElement maximumWorkloadTasks = this.driver.findElement(locatorMaximumWorkloadTasks);
		Assertions.assertEquals("6.18", maximumWorkloadTasks.getText());

	}

	@Test
	@Order(10)
	public void managerDashboardNegative() {

	
		super.signIn("manager1", "manager1");

		super.driver.get(super.baseUrl + "/administrator/dashboard/show");
		super.checkPanicExists();

		super.signOut();
	}

}
