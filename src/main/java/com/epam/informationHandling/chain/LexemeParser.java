package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {

    private static final String WORD_REGEXP = "[a-zA-Z]+(,\\.[.]{0,3}|!|[?])?";
    private static final String EXPRESSION_REGEXP = "(\\d)+([+*/-]+)";

    public LexemeParser() {
    }

    @Override
    public Component parse(String inputData) {
        Pattern expressionPattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher expressionMatcher = expressionPattern.matcher(inputData);
        Pattern wordPattern = Pattern.compile(WORD_REGEXP);
        Matcher wordMatcher = wordPattern.matcher(inputData);

        Component lexemeC = new Composite();
        Component lexeme;
            while (wordMatcher.find()) {
                String value = wordMatcher.group();
                lexeme = Lexeme.word(value, false);
                lexemeC.addComponent(lexeme);
            }

            while (expressionMatcher.find()) {
                String expression = expressionMatcher.group();
                lexeme = Lexeme.expression(expression, true);
                lexemeC.addComponent(lexeme);
            }
        return lexemeC;
    }
}
