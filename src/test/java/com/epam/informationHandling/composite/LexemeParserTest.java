package com.epam.informationHandling.composite;

import com.epam.informationHandling.chain.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexemeParserTest {

    private static Component SECOND_EXPECTED_COMPONENT = new Composite();
    private static Component FIRST_EXPECTED_COMPONENT = new Composite();
    private LexemeParser lexemeParser;

    @BeforeClass
    public void setUp() {
        lexemeParser = new LexemeParser();
    }

    @DataProvider(name = "dataForParsePositiveTest")
    public Object[][] dataForParsePositiveTest() {
        FIRST_EXPECTED_COMPONENT.addComponent(Lexeme.word("My", false));
        SECOND_EXPECTED_COMPONENT.addComponent(Lexeme.expression("223*+", true));
        return new Object[][]{
                {
                        "My",
                        FIRST_EXPECTED_COMPONENT
                },
                {
                        "223*+",
                        SECOND_EXPECTED_COMPONENT
                }
        };
    }

    @Test(dataProvider = "dataForParsePositiveTest")
    public void parsePositiveTest(String inputData, Component expected) {
        Component actual = lexemeParser.parse(inputData);
        Assert.assertEquals(actual, expected);
    }
}

