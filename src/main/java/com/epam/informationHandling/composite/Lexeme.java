package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements Component, Value {
    private List<Component> words;
    private String value;
    private boolean expression;

    public Lexeme(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
        words = new ArrayList<>();
    }

    public Lexeme word(String value) {
        return new Lexeme(value, false);
    }

    public Lexeme expression(String value) {
        return new Lexeme(value, false);
    }

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return value;
    }
}
