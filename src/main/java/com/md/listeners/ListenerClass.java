package com.md.listeners;

import com.md.reports.ExtentLogger;
import com.md.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public final class ListenerClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" is passed");
    }

    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+" is passed");
        ExtentLogger.fail(result.getThrowable().toString());
    }

    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName()+" is passed");
    }

}
