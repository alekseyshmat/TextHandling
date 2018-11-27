package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {

    private static final String WORD_REGEXP = "['\"]?[A-Za-z]+[,!?:;&'\"]?([.]{0,3})?";
    private static final String EXPRESSION_REGEXP = "(\\d)+([+*/-]+)";

    public LexemeParser() {
    }

    @Override
    public Component parse(String inputData) {
        Pattern expressionPattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher expressionMatcher = expressionPattern.matcher(inputData);
        Pattern wordPattern = Pattern.compile(WORD_REGEXP);
        Matcher wordMatcher = wordPattern.matcher(inputData);

        Component lexeme = new Composite();

        while (wordMatcher.find()) {
            String value = wordMatcher.group();
            Component temp = Lexeme.word(value);
            lexeme.addComponent(temp);
        }

        while (expressionMatcher.find()) {
            String expression = expressionMatcher.group();
            Component temp = Lexeme.expression(expression);
            lexeme.addComponent(temp);
        }
        return lexeme;
    }
}
