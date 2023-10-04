package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.EmptyFolder;
import utils.ExtentReport;

import java.io.IOException;

public class BaseClass {

    protected ExtentReport extentReport;

    @BeforeSuite
    public void setUp() {
        String jsonFolderPath = "reportsFilePath";
        EmptyFolder emptyFolder = new EmptyFolder();
        emptyFolder.clearFolder(jsonFolderPath);
    }

    @AfterSuite
    public void flush() throws IOException {
        extentReport.mergeReports();
    }
}
