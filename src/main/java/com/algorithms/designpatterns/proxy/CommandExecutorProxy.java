package com.algorithms.designpatterns.proxy;

public class CommandExecutorProxy implements CommandExecutor {
    private CommandExecutor executor;
    private String user;

    public CommandExecutorProxy(String user) {
        this.user = user;
        this.executor = new CommandExecutorImpl();
    }

    @Override
    public void executeCommand(String command) {
        if (isAdmin()) {
            executor.executeCommand(command);
        } else {
            System.out.println("You don't have permission to execute this command.");
        }
    }

    private boolean isAdmin() {
        return "admin".equalsIgnoreCase(user);
    }   
}
