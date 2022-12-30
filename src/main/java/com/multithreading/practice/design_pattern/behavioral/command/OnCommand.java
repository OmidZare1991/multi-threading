package com.multithreading.practice.design_pattern.behavioral.command;

import javax.xml.stream.events.StartElement;

public class OnCommand implements Command{
    private Television television;

    public OnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        this.television.on();
    }
}
