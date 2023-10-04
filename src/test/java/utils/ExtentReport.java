package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    ExtentReports extentReport;
    ExtentTest extentTest;
    ExtentSparkReporter sparkReporter;
    String reportFilePath;

    public ExtentReport() {
        extentReport = new ExtentReports();
        reportFilePath = "/Users/qa/IdeaProjects/MergeExtentReports/src/main/resources/reports/";

    }

    public void createReport() throws IOException {
        String reportFilePath = "/Users/qa/IdeaProjects/MergeExtentReports/src/main/resources/reports/";

        // Generate a unique timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        // Use the timestamp to create unique filenames
        String fileName = "Spark" + timestamp + ".html";
        String jsonFileName = "extent" + timestamp + ".json";

        // Set the paths for report and JSON file
        sparkReporter = new ExtentSparkReporter(reportFilePath + fileName);
        String jsonPath = reportFilePath + jsonFileName;
        JsonFormatter json = new JsonFormatter(jsonPath);

        // Create a new report domain from the JSON file

        extentReport.createDomainFromJsonArchive(jsonFileName);
        extentReport.attachReporter(json);
        extentReport.attachReporter(sparkReporter);

    }

    public void flushReport() {
        extentReport.flush();
    }

    public void createTest(String testName, String testDescription) {
        extentTest = extentReport.createTest(testName, testDescription);
    }

    public void passTest() {
        extentTest.pass("Test Passed");
    }


    public void mergeReports(){

        // Initialize the ExtentSparkReporter and ExtentReports
        ExtentSparkReporter mergedSpark = new ExtentSparkReporter("spark.html");
        ExtentReports extentMerged = new ExtentReports();


        // Get JSON files from the specified folder and process them
        File jsonOPDirectory = new File(reportFilePath);
        if (jsonOPDirectory.exists() && jsonOPDirectory.isDirectory()) {
            File[] jsonFiles = jsonOPDirectory.listFiles();
            if (jsonFiles != null) {
                for (File jsonFile : jsonFiles) {
                    if (jsonFile.isFile() && jsonFile.getName().endsWith(".json")) {
                        try {
                            extentMerged.createDomainFromJsonArchive(jsonFile.getPath());
                            System.out.println("Processed JSON file: " + jsonFile.getName());
                        } catch (IOException e) {
                            System.err.println("Error processing JSON file: " + jsonFile.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        extentMerged.attachReporter(mergedSpark);
        // Flush the ExtentReports
        extentMerged.flush();
    }
}
