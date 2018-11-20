package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component, Value {
    private List<Component> paragraphs;
    private String value;
    private boolean expression;

    public Text(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
        paragraphs = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        paragraphs.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return paragraphs;
    }

    @Override
    public String getValue() {
        return value;
    }
}
