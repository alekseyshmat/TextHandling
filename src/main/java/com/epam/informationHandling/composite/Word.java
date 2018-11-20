package com.epam.informationHandling.composite;

import java.util.List;

public class Word implements Component, Value {
    private String value;
    private boolean expression;

    public Word() {
        value = "";
    }

    public Word(String value) {
        this.value = value;
    }

    @Override
    public void addComponent(Component component) {

    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }
}
