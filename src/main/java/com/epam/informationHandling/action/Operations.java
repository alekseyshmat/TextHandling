package com.epam.informationHandling.action;

import com.epam.informationHandling.composite.Component;

import java.util.Comparator;
import java.util.List;

public class Operations {

    public Component sortParagraphsByCountOfSentence(Component component) {
        Component text = component;
        List<Component> components = text.getChildren();
        components.sort(Comparator.comparing(p -> p.getChildren().size()));
        return text;
    }

    public Component sortWordByByLength(Component component) {
        Component text = component;
        List<Component> components = text.getChildren();
        for (Component paragraph : components) {
            List<Component> sentences = paragraph.getChildren();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort(Comparator.comparing(lexeme -> lexeme.getValue().length()));
            }
        }
        return text;
    }

    public Component sortLexeme(char symbol, Component component) {
        Component text = component;
        List<Component> lexemes = text.getChildren();
        lexemes.sort((first, second) -> {
            String firstLexeme = first.getValue();
            String secondLexeme = second.getValue();

            int value;
            long firstCounter = firstLexeme.chars().filter(ch -> ch == symbol).count();
            long secondCounter = secondLexeme.chars().filter(ch -> ch == symbol).count();

            if (firstCounter == 0 && secondCounter == 0 || firstCounter == secondCounter) {
                value = firstLexeme.compareToIgnoreCase(secondLexeme);
            } else {
                value = Long.compare(firstCounter, secondCounter);
                if (value >= 1) {
                    value = -1;
                } else if (value <= -1) {
                    value = 1;
                }
            }
            return value;
        });
        return text;
    }
}
