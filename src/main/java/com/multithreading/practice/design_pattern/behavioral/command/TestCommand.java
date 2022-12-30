package com.multithreading.practice.design_pattern.behavioral.command;

public class TestCommand {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();
        Television television = new Television();
        Command command = new OnCommand(television);
        remoteController.setCommand(command);
        remoteController.pressButton();
    }

}
