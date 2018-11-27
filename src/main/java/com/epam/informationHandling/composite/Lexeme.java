package com.epam.informationHandling.composite;

import java.util.List;
import java.util.Random;

public class Lexeme implements Component {
    private String value;
    private boolean expression;

    public Lexeme(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, false);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, true);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) obj;
        return lexeme.getValue().equals(this.getValue());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = new Random().nextInt(255);
        result = prime * result + this.getValue().hashCode();

        return result;
    }


    @Override
    public String toString() {
        return "Lexeme{" +
                "value = " + value +
                "\n expression = " + expression + " }";
    }

    public boolean isExpression() {
        return expression;
    }
}
