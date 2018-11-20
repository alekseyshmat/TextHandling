package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component, Value {
    private List<Component> sentences;
    private String value;
    private boolean expression;

    public Paragraph(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
        sentences = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        sentences.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return sentences;
    }

    @Override
    public String getValue() {
        return value;
    }
}
