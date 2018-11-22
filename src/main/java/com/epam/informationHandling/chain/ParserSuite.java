package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;

public class ParserSuite {
    private ParagraphParser paragraphParser;
    private SentenceParser sentenceParser;
    private LexemeParser lexemeParser;
    private Component text;

    public ParserSuite() {
        lexemeParser = new LexemeParser();
        sentenceParser = new SentenceParser(lexemeParser);
        paragraphParser = new ParagraphParser(sentenceParser);
        text = new Composite();
    }

    public Component parse(String inputData) {
        paragraphParser.parse(text, inputData);
        return text;
    }
}
