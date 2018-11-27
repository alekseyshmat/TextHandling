package com.epam.informationHandling.action;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextRestoratorTest {

    private static final Lexeme ONE = Lexeme.word("One,");
    private static final Lexeme THREE = Lexeme.word("three,");
    private static final Lexeme FOUR = Lexeme.word("four.");
    private static final Lexeme FIVE = Lexeme.word("Five,");
    private static final Lexeme SIX = Lexeme.word("Six,");
    private static final Lexeme SEVEN = Lexeme.word("seven.");
    private static final Lexeme TEN = Lexeme.word("ten,");
    private static final Lexeme ELEVEN = Lexeme.word("eleven,");
    private static final Lexeme EIGHTEEN = Lexeme.word("eighteen.");

    private TextRestorator textRestorator;

    @BeforeClass
    public void setUp() {
        textRestorator = new TextRestorator();
    }

    @DataProvider(name = "dataForRestorePositiveTest")
    public Object[][] dataForRestorePositiveTest() {
        Component sentenceFirst = new Composite();
        sentenceFirst.addComponent(ONE);
        sentenceFirst.addComponent(THREE);
        sentenceFirst.addComponent(FOUR);

        Component sentenceSecond = new Composite();
        sentenceSecond.addComponent(SIX);
        sentenceSecond.addComponent(SEVEN);

        Component sentenceThird = new Composite();
        sentenceThird.addComponent(FIVE);
        sentenceThird.addComponent(TEN);
        sentenceThird.addComponent(ELEVEN);
        sentenceThird.addComponent(EIGHTEEN);

        Component firstParagraph = new Composite();
        firstParagraph.addComponent(sentenceFirst);
        firstParagraph.addComponent(sentenceSecond);
        firstParagraph.addComponent(sentenceThird);

        Component secondParagraph = new Composite();
        secondParagraph.addComponent(sentenceSecond);

        Component thirdParagraph = new Composite();
        thirdParagraph.addComponent(sentenceThird);

        Component inputComponent = new Composite();
        inputComponent.addComponent(firstParagraph);
        inputComponent.addComponent(secondParagraph);
        inputComponent.addComponent(thirdParagraph);

        return new Object[][]{
                {
                        inputComponent,
                        "\tOne, three, four. Six, seven. Five, ten, eleven, eighteen." +
                                "\n\tSix, seven." +
                                "\n\tFive, ten, eleven, eighteen."
                }
        };
    }

    @Test(dataProvider = "dataForRestorePositiveTest")
    public void restorePositiveTest(Component inputComponent, String expected) {
        String actual = textRestorator.restore(inputComponent);
        Assert.assertEquals(actual, expected);
    }
}
