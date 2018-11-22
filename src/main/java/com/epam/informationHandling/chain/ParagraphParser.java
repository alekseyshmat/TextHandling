package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {

    private Parser sentenceParser;
    private static final String PARAGRAPH_REGEXP = "\\t|\\s{4}";

    public ParagraphParser(Parser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    @Override
    public void parse(Component component, String inputData) {
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(inputData);
        while (matcher.find()) {
            String value = matcher.group();
            Component paragraph = new Composite();
            component.addComponent(paragraph);
            sentenceParser.parse(paragraph, value);
        }
    }

}//todo
