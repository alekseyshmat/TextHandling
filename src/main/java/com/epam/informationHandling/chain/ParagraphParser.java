package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {

    private Parser sentenceParser;
    private static final String PARAGRAPH_REGEXP = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

    public ParagraphParser(Parser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    @Override
    public Component parse(String inputData) {
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(inputData);
        Component paragraph = new Composite();
        while (matcher.find()) {
            String value = matcher.group();
            Component sentence = sentenceParser.parse(value);
            paragraph.addComponent(sentence);
        }
        return paragraph;
    }
}


