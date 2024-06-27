package com.md.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.md.constants.FrameworkConstants;
import com.md.exceptions.InvalidFilePathException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;
    public static void initReport(){
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("API Demos");
            spark.config().setDocumentTitle("Mobile Automation");
        }

    }

    public static void flushReport(){
        if(Objects.nonNull(extent)){
            extent.flush();
            ExtentManager.unload();

            try {
                Desktop.getDesktop().browse(new File("index.html").toURI());
            } catch (IOException e) {
                throw new InvalidFilePathException("Failed to open file index.html");
            }

        }

    }

    public static void createTest(String testcaseName){
        ExtentManager.setExtentTest(extent.createTest(testcaseName));
    }


}
