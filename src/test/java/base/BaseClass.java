package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.EmptyFolder;
import utils.ExtentReport;

import java.io.IOException;

public class BaseClass {

    protected ExtentReport extentReport;
//    protected static ThreadLocal<ExtentReport> extentReport = ThreadLocal.withInitial(ExtentReport::new);
//    public static String reportName = null;

    @BeforeSuite
    public void setUp() throws IOException {
        String jsonFolderPath = "/Users/qa/IdeaProjects/MergeExtentReports/src/main/resources/reports/";
        EmptyFolder emptyFolder = new EmptyFolder();
        emptyFolder.clearFolder(jsonFolderPath);
    }

    @AfterSuite
    public void flush() throws IOException {
        extentReport.mergeReports();
    }
}
