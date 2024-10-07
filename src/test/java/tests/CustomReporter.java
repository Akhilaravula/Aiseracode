package test.java.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        try {
            outputDirectory = "C:\\Users\\AkhilaReddy\\IdeaProjects\\Google Application\\test-output";
            String currentTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
            String template = readTemplate("C:\\Users\\AkhilaReddy\\IdeaProjects\\Google Application\\src\\test\\resource\\customreport.html");

            StringBuilder tableRows = new StringBuilder();
            StringBuilder failureDetails = new StringBuilder();

            for (ISuite suite : suites) {
                String suiteName = suite.getName();
                Map<String, ISuiteResult> suiteResults = suite.getResults();

                for (ISuiteResult sr : suiteResults.values()) {
                    ITestContext tc = sr.getTestContext();

                    // Initialize counters for various test statuses
                    int totalTests = tc.getAllTestMethods().length;
                    int passedTests = tc.getPassedTests().getAllResults().size();
                    int failedTests = tc.getFailedTests().getAllResults().size();
                    int skippedTests = tc.getSkippedTests().getAllResults().size();
                    // Assuming there is a custom method to get warned tests
                    int warnedTests = 0;

                    // Print counts for verification
                    System.out.println("Total Tests: " + totalTests);
                    System.out.println("Passed Tests: " + passedTests);
                    System.out.println("Failed Tests: " + failedTests);
                    System.out.println("Skipped Tests: " + skippedTests);
                    System.out.println("Warned Tests: " + warnedTests);

                    // Iterate over failed tests to build failure details
                    for (ITestResult failedTest : tc.getFailedTests().getAllResults()) {
                        String methodName = failedTest.getMethod().getMethodName();
                        String failureMessage = failedTest.getThrowable() != null ? failedTest.getThrowable().getMessage() : "No message";
                        failureDetails.append("<tr class=\"failed-test\">")
                                .append("<td>").append(methodName).append("</td>")
                                .append("<td>").append(failureMessage).append("</td>")
                                .append("</tr>");
                    }

                    // Calculate duration and percentage passed
                    long totalDuration = tc.getEndDate().getTime() - tc.getStartDate().getTime();
                    String duration = formatDuration(totalDuration);
                    String minMaxAveDuration = getMinMaxAveDuration(tc);
                    double percentPassed = (totalTests > 0) ? (passedTests * 100.0 / totalTests) : 0;

                    // Append the test result row to tableRows
                    tableRows.append("<tr>")
                            .append("<td>").append(suiteName).append("</td>")
                            .append("<td>").append("App Name Placeholder").append("</td>")
                            .append("<td>").append(totalTests).append("</td>")
                            .append("<td>").append(passedTests).append("</td>")
                            .append("<td>").append(skippedTests).append("</td>")
                            .append("<td>").append(warnedTests).append("</td>")
                            .append("<td>").append(failedTests).append("</td>")
                            .append("<td>").append(duration).append("</td>")
                            .append("<td>").append(minMaxAveDuration).append("</td>")
                            .append("<td>").append(String.format("%.2f%%", percentPassed)).append("</td>")
                            .append("</tr>");
                }
            }

            String report = template.replace("${currentTime}", currentTime)
                    .replace("${tableRows}", tableRows.toString())
                    .replace("${failureDetails}", failureDetails.toString()); // Replace failure details

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + "/CustomReport01.html"));
            writer.write(report);
            writer.close();
            System.out.println("Report generated successfully at: " + outputDirectory + "/CustomReport.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readTemplate(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append(System.lineSeparator());
        }
        reader.close();
        return content.toString();
    }

    private String formatDuration(long duration) {
        long seconds = duration / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        minutes %= 60;
        seconds %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private String getMinMaxAveDuration(ITestContext tc) {
        long minDuration = Long.MAX_VALUE;
        long maxDuration = Long.MIN_VALUE;
        long totalDuration = 0;
        int count = 0;

        for (ITestResult result : tc.getPassedTests().getAllResults()) {
            long duration = result.getEndMillis() - result.getStartMillis();
            totalDuration += duration;
            if (duration < minDuration) minDuration = duration;
            if (duration > maxDuration) maxDuration = duration;
            count++;
        }
        for (ITestResult result : tc.getFailedTests().getAllResults()) {
            long duration = result.getEndMillis() - result.getStartMillis();
            totalDuration += duration;
            if (duration < minDuration) minDuration = duration;
            if (duration > maxDuration) maxDuration = duration;
            count++;
        }
        for (ITestResult result : tc.getSkippedTests().getAllResults()) {
            long duration = result.getEndMillis() - result.getStartMillis();
            totalDuration += duration;
            if (duration < minDuration) minDuration = duration;
            if (duration > maxDuration) maxDuration = duration;
            count++;
        }

        long aveDuration = (count > 0) ? totalDuration / count : 0;
        return String.format("%s / %s / %s", formatDuration(minDuration), formatDuration(maxDuration), formatDuration(aveDuration));
    }
}
