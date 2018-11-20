package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagrhaphParser implements Parser {

    private Parser sentenceParser;
    private final String PARAGRAPH_REGEXP ="(\\t|\\s{4}).+\\s|\\n";

    public ParagrhaphParser(Parser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    @Override
    public void parse(Component component, String inputData) {
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(inputData);
        while (matcher.find()){
            String paragraph = matcher.group();
        }
    }
}//todo
