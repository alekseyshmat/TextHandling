package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private static final String SENTENCE_REGEXP = "[ a-zA-Z1-9,;:()*/+-]+([.]{3}|[.?!])";
    private Parser lexemeParser;

    public SentenceParser(Parser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    @Override
    public Component parse(String inputData) {
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEXP);
        Matcher matcher = sentencePattern.matcher(inputData);
        Component sentence = new Composite();
        Component lexeme;
        while (matcher.find()) {
            String value = matcher.group();
            lexeme = lexemeParser.parse(value);
            sentence.addComponent(lexeme);
        }
        return sentence;
    }
}
