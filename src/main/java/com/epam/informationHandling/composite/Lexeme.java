package com.epam.informationHandling.composite;

import java.util.List;

public class Lexeme implements Component, Value {
    private String value;
    private boolean expression;

    public Lexeme(String value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void addComponent(Component component) {

    }

    @Override
    public List<Component> getChildren() {
        return null;
    }
}
