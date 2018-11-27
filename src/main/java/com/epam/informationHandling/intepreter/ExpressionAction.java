package com.epam.informationHandling.intepreter;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;

import java.util.List;

public class ExpressionAction {

    private Component newComponent;

    public Component calculateExpression(Component component) {
        Component text = component;
        List<Component> components = text.getChildren();
        newComponent = new Composite();
        for (Component lexemes : components) {
            Lexeme lexeme = ((Lexeme) lexemes);
            if (lexeme.isExpression()) {
                String value = lexeme.getValue();
                Client client = new Client();
                String result = client.calculate(value);
                newComponent.addComponent(Lexeme.word(result, false));
            } else {
                String value = lexeme.getValue();
                newComponent.addComponent(Lexeme.word(value, false));
            }
        }
        return newComponent;
    }
}
