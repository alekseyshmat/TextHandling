package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private static final String SENTENSE_REGEXP = "[A-Z].+([!]|[?]|[.]|[...])";
    private Parser lexemeParser;

    public SentenceParser(Parser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }


    @Override
    public void parse(Component component, String inputData) {
        Pattern sentencePattern = Pattern.compile(SENTENSE_REGEXP);
        Matcher matcher = sentencePattern.matcher(inputData);
        while (matcher.find()) {
            String value = matcher.group();
            Component sentence = new Composite();
            component.addComponent(sentence);
            lexemeParser.parse(component, value);
        }
    }
}//todo
