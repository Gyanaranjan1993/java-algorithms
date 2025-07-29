package com.algorithms.designpatterns.solid;

// Dont add all the utility methods here, just the ones that are relevant to the Report class
// This class represents a Report with a title and content.
// It should not handle any file operations or other unrelated tasks.
// This class adheres to the Single Responsibility Principle (SRP).
public class Report {
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
