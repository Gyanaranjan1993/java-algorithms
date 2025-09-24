package com.algorithms.designpatterns.solid;

// This class is responsible for sending email notifications about reports.
// It adheres to the Single Responsibility Principle (SRP) by focusing solely on email notifications
public class EmailNotifier {
    public void sendEmail(Report report, String recipient) {
        String subject = "New Report: " + report.getTitle();
        String body = "Content: " + report.getContent();
        // Code to send email (omitted for brevity)
    }
}
