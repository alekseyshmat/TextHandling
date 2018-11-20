package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Paragraph;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphParserTest {
    private Parser parser;

    @BeforeClass
    public void setUp() {
        parser = new ParagraphParser();
    }

    @DataProvider(name = "dataForParseTestPositive")
    public Object[][] dataForParseTestPositive() {
        return new Object[][]{
                {
                        "\t Aaa\tBoo",
                        Arrays.asList(
                                new Paragraph("Aaa"),
                                new Paragraph("Boo")
                        )
                }
        };
    }

    @Test(dataProvider = "dataForParseTestPositive")
    public void parseTestPositive(String text, List<Paragraph> expectedList) {
        List<Paragraph> actualList = parser.parse(text);
        Assert.assertEquals(actualList, expectedList);
    }
}