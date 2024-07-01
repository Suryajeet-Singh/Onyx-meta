package com.bwp.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//			Create directory where we want to generate reports.
		String path = System.getProperty("user.dir") + "/Reports/" + myDateObj.format(myFormatObj)
				+ "__ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

//			Set Report Name
		reporter.config().setReportName("Onyx Meta Automation Report");

//			Set Document title
		reporter.config().setDocumentTitle("Cedcommerce(Onyx Meta Automation)");

//			Creating class that drives all the reporting execution.
		extent = new ExtentReports();
		extent.attachReporter(reporter);

//			Adding tester name
		extent.setSystemInfo("Tester", "Yatindra_Kinker_2096");
		return extent;
	}
}