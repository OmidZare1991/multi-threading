package com.multithreading.practice.design_pattern.behavioral.command;

public class OffCommand implements Command{
    private Television television;

    public OffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        this.television.off();
    }
}
