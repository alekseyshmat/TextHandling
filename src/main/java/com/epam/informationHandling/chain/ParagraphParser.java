package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Paragraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser<Paragraph> {

    private Parser sentenceParser;
    private final String PARAGRAPH_REGEXP = "(\\t|\\s{4}).+\\s|\\n";

    public ParagraphParser() {
        sentenceParser = new SentenceParser();
    }

    @Override
    public List<Paragraph> parse(String text) {
        List<Paragraph> result = new ArrayList<>();
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(text);

        while (matcher.find()) {
            String value = matcher.group();
            Paragraph paragraph = new Paragraph(value);
            result.add(paragraph);
        }

        return result;
    }

    public List<Paragraph> parseAll(String text) {
        List<Paragraph> result = parse(text);
        Parser parser = sentenceParser;

        for (Paragraph paragraph : result) {
            paragraph.setChildren(parser.parse(paragraph.getValue()));
        }

        return result;
    }

}//todo
