package tests;

import base.BaseClass;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;

public class DummyTestTwo extends BaseClass {
    @Test(testName = "Page Two Test", description = "Test of the Page two")
    public void pageTwoTest() throws IOException, InterruptedException {
        extentReport = new ExtentReport();
        extentReport.createReport();
        Thread.sleep(1000);
        extentReport.createTest("Page Two Test", "Test of the Page one");
        System.out.println("Assassin Creed is best RPG Game");
        extentReport.passTest();
        extentReport.flushReport();
    }
}
