package com.epam.informationHandling.composite;

import com.epam.informationHandling.chain.LexemeParser;
import com.epam.informationHandling.chain.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceParserTest {

    private static Component FIRST_COMPONENT = new Composite();
    private SentenceParser sentenceParser;
    private LexemeParser lexemeParser;

    @BeforeClass
    public void setUp() {
        lexemeParser = new LexemeParser();
        sentenceParser = new SentenceParser(lexemeParser);
    }

    @DataProvider(name = "dataForParsePositiveTest")
    public Object[][] dataForParsePositiveTest() {
        Component lexeme = new Composite();
        lexeme.addComponent(Lexeme.word("My", false));
        lexeme.addComponent(Lexeme.word("name", false));
        lexeme.addComponent(Lexeme.word("Aleksey", false));
        FIRST_COMPONENT.addComponent(lexeme);
        return new Object[][]{
                {
                        "My name Aleksey.",
                        FIRST_COMPONENT
                }
        };
    }

    @Test(dataProvider = "dataForParsePositiveTest")
    public void parsePositiveTest(String inputData, Component expected) {
        Component actual = sentenceParser.parse(inputData);
        Assert.assertEquals(actual, expected);
    }
}
