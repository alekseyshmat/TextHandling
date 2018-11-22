package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;
import com.epam.informationHandling.intepreter.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {

    private static final String WORD_REGEXP = "[A-Za-z]+";
    private static final String LEXEME_REGEXP = "\\s";
    private static final String EXPRESSION_REGEXP = "(--)|(\\+\\+)|(\\d)|([+*/])";

    public LexemeParser() {
    }

    @Override
    public void parse(Component component, String inputData) {
        Pattern expressionPattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher expressionMatcher = expressionPattern.matcher(inputData);
        Pattern wordPattern = Pattern.compile(WORD_REGEXP);
        Matcher wordMatcher = wordPattern.matcher(inputData);

        if (expressionMatcher.find()) {
            //count expression
            Client client = new Client();
            String expression = client.calculate(inputData);
            Component lexeme = new Lexeme(expression, true);
            component.addComponent(lexeme);
        } else if (wordMatcher.find()){
            Component word = new Composite();
            component.addComponent(word);
        }
    }
}
