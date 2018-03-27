package com.extentReporters;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;

public class ExtentManager {
    static ExtentReports extent;
    static final String filePath = "Reports/TestReports.html";
    static final String configFilePath = "Reports/config.xml";

    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports("Reports/TestReports.html", true);
            extent.addSystemInfo("DummyAppium", "QA Environment");
            extent.addSystemInfo("Author ", "Jainish Kapadia");
            extent.loadConfig(new File("Reports/config.xml"));
        }
        return extent;
    }
}
