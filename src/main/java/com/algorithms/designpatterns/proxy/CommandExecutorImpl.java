package com.algorithms.designpatterns.proxy;

public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(String command) {
        System.out.println("Executing command: " + command);
    }

}
