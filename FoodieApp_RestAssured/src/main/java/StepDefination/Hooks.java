package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Hooks {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Before(order = 0)
    public void setupExtentReports() {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report/spark.html");
            sparkReporter.config().setReportName("Foodie App Test Report");
            sparkReporter.config().setDocumentTitle("Foodie API Automation");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
        System.out.println("Extent Reports setup completed.");
    }

    @Before(order = 1)
    public void beforeScenario(io.cucumber.java.Scenario scenario) {
        System.out.println("Scenario started: " + scenario.getName());
        extentTest = extentReports.createTest(scenario.getName());
    }

    @After(order = 1)
    public void afterScenario(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.fail("Scenario failed: " + scenario.getName());
        } else {
            extentTest.pass("Scenario passed: " + scenario.getName());
        }
        System.out.println("Scenario finished: " + scenario.getName());
    }

    @After(order = 0)
    public void flushExtentReports() {
        if (extentReports != null) {
            extentReports.flush();
            System.out.println("Extent Reports flushed.");
        }
    }
}
