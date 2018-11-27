package com.epam.informationHandling.action;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Lexeme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextRestorator {
    private static final Logger LOGGER = LogManager.getLogger(TextRestorator.class);

    public String restore(Component component) {
        StringBuilder text = new StringBuilder();

        List<Component> components = component.getChildren();
        int numberParagraphs = components.size();
        for (Component paragraph : components) {
            List<Component> sentences = paragraph.getChildren();
            int numberSentences = sentences.size();
            text.append("\t");
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                int numberLexemes = lexemes.size();
                for (Component lexeme : lexemes) {
                    Lexeme lex = ((Lexeme) lexeme);
                    String value = lex.getValue();
                    text.append(value);
                    if ((numberLexemes-- != 1 && numberSentences >= 1) ||
                            (numberLexemes-- == 0 && numberSentences != 1)) {
                        text.append(" ");
                    }
                }
                numberSentences--;
            }
            if (--numberParagraphs > 0) {
                text.append("\n");
            }
        }
        LOGGER.info("Text from input component waw restored");
        return text.toString();
    }
}
