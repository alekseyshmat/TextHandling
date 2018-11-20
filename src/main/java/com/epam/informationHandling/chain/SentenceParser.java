package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private final String SENTENSE_REGEXP = "[A-Z].+([!]|[?]|[.]|[...])";
    private Parser lexemeParser;

    public SentenceParser(Parser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    @Override
    public void parse(Component component, String inputData) {
        Pattern sentencePattern = Pattern.compile(SENTENSE_REGEXP);
        Matcher matcher = sentencePattern.matcher(inputData);
        while (matcher.find()){
            String sentence = matcher.group();
        }
    }
}//todo
