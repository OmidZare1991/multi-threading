package com.multithreading.practice.design_pattern.behavioral.command;

public class RemoteController {
    private Command command;

    public void pressButton() {
        this.command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
