package com.algorithms.designpatterns.solid;

// This class is responsible for printing reports to the console.
// It adheres to the Single Responsibility Principle (SRP) by focusing solely on report printing
public class ReportPrinter {
    public void printReport(Report report) {
        System.out.println("Title: " + report.getTitle());
        System.out.println("Content: " + report.getContent());
    }
}
