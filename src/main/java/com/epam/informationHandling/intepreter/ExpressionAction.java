package com.epam.informationHandling.intepreter;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;

import java.util.List;

public class ExpressionAction {

    public Component calculateExpression(Component component) {
        List<Component> components = component.getChildren();
        Component newComponent = new Composite();
        for (Component lexemes : components) {
            Lexeme lexeme = ((Lexeme) lexemes);
            if (lexeme.isExpression()) {
                String value = lexeme.getValue();
                MathOperations mathOperations = new MathOperations();
                String result = mathOperations.calculate(value);
                newComponent.addComponent(Lexeme.word(result));
            } else {
                String value = lexeme.getValue();
                newComponent.addComponent(Lexeme.word(value));
            }
        }
        return newComponent;
    }
}
