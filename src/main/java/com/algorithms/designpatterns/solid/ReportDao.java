package com.algorithms.designpatterns.solid;

import java.io.FileWriter;
import java.io.IOException;

// This class is responsible for saving reports to a file.
// It adheres to the Single Responsibility Principle (SRP) by focusing solely on file operations
public class ReportDao {
    public void saveToFile(Report report, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Title: " + report.getTitle() + "\n");
            writer.write("Content: " + report.getContent() + "\n");
        }
    }
}
