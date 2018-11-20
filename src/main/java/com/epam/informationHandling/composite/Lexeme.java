package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements Component, Value {
    private List<Component> words;
    private String value;
    private boolean expression;

    public Lexeme(String value) {
        this.value = value;
        this.expression = expression;
        words = new ArrayList<>();
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
    public void setChildren(List<Component> children) {
        words = children;
    }

    @Override
    public String getValue() {
        return value;
    }
}
