package com.epam.informationHandling.composite;

import com.epam.informationHandling.chain.LexemeParser;
import com.epam.informationHandling.chain.ParagraphParser;
import com.epam.informationHandling.chain.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParagraphParserTest {

    private static Component EXPECTED_COMPONENT = new Composite();
    private ParagraphParser paragraphParser;

    @BeforeClass
    public void setUp() {
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        paragraphParser = new ParagraphParser(sentenceParser);
    }

    @DataProvider(name = "dataForParsePositiveTest")
    public Object[][] dataForParsePositiveTest() {
        Component firstParagraph = new Composite();
        Component secondParagraph = new Composite();

        Component sentenceFirst = new Composite();
        sentenceFirst.addComponent(Lexeme.word("One", false));
        sentenceFirst.addComponent(Lexeme.word("two", false));
        sentenceFirst.addComponent(Lexeme.word("three", false));

        Component sentenceSecond = new Composite();
        sentenceSecond.addComponent(Lexeme.word("Six", false));
        sentenceSecond.addComponent(Lexeme.word("seven", false));
        sentenceSecond.addComponent(Lexeme.word("nine", false));

        firstParagraph.addComponent(sentenceFirst);
        secondParagraph.addComponent(sentenceSecond);

        EXPECTED_COMPONENT.addComponent(firstParagraph);
        EXPECTED_COMPONENT.addComponent(secondParagraph);
        return new Object[][]{
                {
                        "\t One, two, three.\tSix, seven, nine.",
                        EXPECTED_COMPONENT
                }
        };
    }

    @Test(dataProvider = "dataForParsePositiveTest")
    public void parsePositiveTest(String inputData, Component expected) {
        Component actual = paragraphParser.parse(inputData);
        Assert.assertEquals(actual, expected);
    }
}
