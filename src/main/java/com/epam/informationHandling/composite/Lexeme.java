package com.epam.informationHandling.composite;

import java.util.List;

public class Lexeme implements Component, Value {
    private String value;
    private boolean expression;

    public Lexeme(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
    }


    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    public boolean isExpression() {
        return expression;
    }

    public void setExpression(boolean expression) {
        this.expression = expression;
    }
}
