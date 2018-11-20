package com.epam.informationHandling.chain;

public class ParserSuite {
    private Parser wordParser;
    private Parser lexemeParser;
    private Parser sentenceParser;
    private Parser paragraphParser;
    private Parser textParser;

    public ParserSuite() {
        wordParser = new WordParser();
        lexemeParser = new LexemeParser();
        sentenceParser = new SentenceParser();
        paragraphParser = new ParagraphParser();
        textParser = new TextParser();
    }
}
