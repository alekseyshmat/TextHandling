package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component, Value {
    private List<Component> lexemes;
    private String value;
    private boolean expression;

    public Sentence(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
        lexemes = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        lexemes.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return lexemes;
    }

    @Override
    public String getValue() {
        return value;
    }
}
