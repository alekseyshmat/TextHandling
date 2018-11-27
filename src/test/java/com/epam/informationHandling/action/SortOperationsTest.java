package com.epam.informationHandling.action;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortOperationsTest {

    private static final Lexeme ONE = Lexeme.word("one", false);
    private static final Lexeme THREE = Lexeme.word("three", false);
    private static final Lexeme FOUR = Lexeme.word("four", false);
    private static final Lexeme FIVE = Lexeme.word("five", false);
    private static final Lexeme SIX = Lexeme.word("six", false);
    private static final Lexeme SEVEN = Lexeme.word("seven", false);
    private static final Lexeme TEN = Lexeme.word("ten", false);
    private static final Lexeme ELEVEN = Lexeme.word("eleven", false);
    private static final Lexeme EIGHTEEN = Lexeme.word("eighteen", false);

    private SortOperations sortOperations;

    @BeforeClass
    public void setUp() {
        sortOperations = new SortOperations();
    }

    @DataProvider(name = "dataForSortParagraphsByCountOfSentencePositiveTest")
    public Object[][] dataForSortParagraphsByCountOfSentencePositiveTest() {
        Component sentenceFirst = new Composite();
        sentenceFirst.addComponent(FOUR);
        sentenceFirst.addComponent(THREE);
        sentenceFirst.addComponent(ONE);

        Component sentenceSecond = new Composite();
        sentenceSecond.addComponent(SEVEN);
        sentenceSecond.addComponent(SIX);

        Component sentenceThird = new Composite();
        sentenceThird.addComponent(FIVE);
        sentenceThird.addComponent(TEN);
        sentenceThird.addComponent(EIGHTEEN);
        sentenceThird.addComponent(ELEVEN);

        Component firstParagraph = new Composite();
        firstParagraph.addComponent(sentenceFirst);

        Component secondParagraph = new Composite();
        secondParagraph.addComponent(sentenceFirst);
        secondParagraph.addComponent(sentenceSecond);

        Component thirdParagraph = new Composite();
        thirdParagraph.addComponent(sentenceFirst);
        thirdParagraph.addComponent(sentenceSecond);
        thirdParagraph.addComponent(sentenceThird);

        Component inputComponent = new Composite();
        inputComponent.addComponent(thirdParagraph);
        inputComponent.addComponent(firstParagraph);
        inputComponent.addComponent(secondParagraph);

        Component expectedComponent = new Composite();
        expectedComponent.addComponent(firstParagraph);
        expectedComponent.addComponent(secondParagraph);
        expectedComponent.addComponent(thirdParagraph);

        return new Object[][]{
                {
                        inputComponent,
                        expectedComponent
                }
        };
    }

    @DataProvider(name = "dataForSortWordByByLengthPositiveTest")
    public Object[][] dataForSortWordByByLengthPositiveTest() {
        Component sentenceInputFirst = new Composite();
        sentenceInputFirst.addComponent(FOUR);
        sentenceInputFirst.addComponent(THREE);
        sentenceInputFirst.addComponent(ONE);

        Component sentenceInputSecond = new Composite();
        sentenceInputSecond.addComponent(SEVEN);
        sentenceInputSecond.addComponent(SIX);

        Component firstInputParagraph = new Composite();
        firstInputParagraph.addComponent(sentenceInputFirst);
        firstInputParagraph.addComponent(sentenceInputSecond);

        Component inputComponent = new Composite();
        inputComponent.addComponent(firstInputParagraph);

        Component firstExpectedSentence = new Composite();
        firstExpectedSentence.addComponent(ONE);
        firstExpectedSentence.addComponent(FOUR);
        firstExpectedSentence.addComponent(THREE);

        Component secondExpectedSentence = new Composite();
        secondExpectedSentence.addComponent(SIX);
        secondExpectedSentence.addComponent(SEVEN);

        Component firstExpectedParagraph = new Composite();
        firstExpectedParagraph.addComponent(firstExpectedSentence);
        firstExpectedParagraph.addComponent(secondExpectedSentence);

        Component expectedComponent = new Composite();
        expectedComponent.addComponent(firstExpectedParagraph);
        return new Object[][]{
                {
                        inputComponent,
                        expectedComponent
                }
        };
    }

    @DataProvider(name = "dataForSortLexeme")
    public Object[][] dataForSortLexeme() {
        Component firstSentence = new Composite();
        firstSentence.addComponent(ONE);
        firstSentence.addComponent(ELEVEN);
        firstSentence.addComponent(THREE);

        Component expected = new Composite();
        expected.addComponent(ELEVEN);
        expected.addComponent(THREE);
        expected.addComponent(ONE);

        return new Object[][]{
                {
                        'e',
                        firstSentence,
                        expected
                }
        };
    }

    @Test(dataProvider = "dataForSortParagraphsByCountOfSentencePositiveTest")
    public void sortParagraphsByCountOfSentencePositiveTest(Component inputComponent, Component expected) {
        Component actual = sortOperations.sortParagraphsByCountOfSentence(inputComponent);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForSortWordByByLengthPositiveTest")
    public void sortWordByByLengthPositiveTest(Component inputComponent, Component expected) {
        Component actual = sortOperations.sortWordByByLength(inputComponent);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForSortLexeme")
    public void sortLexeme(char symbol, Component inputComponent, Component expected) {
        Component actual = sortOperations.sortLexeme(symbol, inputComponent);
        Assert.assertEquals(actual, expected);
    }
}
