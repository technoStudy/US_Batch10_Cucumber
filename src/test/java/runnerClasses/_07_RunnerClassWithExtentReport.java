package runnerClasses;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class _07_RunnerClassWithExtentReport extends AbstractTestNGCucumberTests {

    // This class controls our test(e.g. @Smoke Test). So @BeforeClass runs before everything in this class(Features, Scenarios...)
    // @AfterClass runs after everything in this class.
    @BeforeClass
    public void setUp() {
        System.out.println("Test is starting");
    }


    @AfterClass
    public void terminate() {
        System.out.println("Test is ended");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name")); // Adds the info about operating system
        ExtentService.getInstance().setSystemInfo("Tester Name", System.getProperty("user.name")); // Adds the info of the tester
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone")); // Adds time zone info of the user
        ExtentService.getInstance().setSystemInfo("Application Name","Campus v 2.0.3");
        ExtentService.getInstance().setSystemInfo("Department Name", "QA");
        ExtentService.getInstance().setSystemInfo("Team Name", "QA Team 1");
    }
}
