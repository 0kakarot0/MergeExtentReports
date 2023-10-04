package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;

public class DummyTestOne extends BaseClass {

    @Test(testName = "Page One Test", description = "Test of the Page one")
    public void pageOneTest() throws IOException, InterruptedException {
        extentReport = new ExtentReport();
        extentReport.createReport();
        Thread.sleep(1000);
        extentReport.createTest("Page One Test", "Test of the Page one");
        System.out.println("how you doin");
        extentReport.passTest("how you doin");
        extentReport.flushReport();
    }
}
