package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component, Value {
    private List<Component> sentences;
    private String value;
    private boolean expression;

    public Paragraph(String value) {
        this.value = value;
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
    public void setChildren(List<Component> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String getValue() {
        return value;
    }
}
