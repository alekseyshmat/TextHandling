package com.epam.informationHandling.interpret;

import com.epam.informationHandling.composite.Component;
import com.epam.informationHandling.composite.Composite;
import com.epam.informationHandling.composite.Lexeme;
import com.epam.informationHandling.intepreter.ExpressionAction;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpressionActionTest {

    private ExpressionAction expressionAction;

    @BeforeClass
    public void setUp() {
        expressionAction = new ExpressionAction();
    }

    @DataProvider(name = "dataForExpressionPositiveTest")
    public Object[][] dataForExpressionPositiveTest() {
        Component inputComponent = new Composite();
        inputComponent.addComponent(Lexeme.word("Counting", false));
        inputComponent.addComponent(Lexeme.word("this", false));
        inputComponent.addComponent(Lexeme.word("expression", false));
        inputComponent.addComponent(Lexeme.expression("8274+*-", true));

        Component expectedComponent = new Composite();
        expectedComponent.addComponent(Lexeme.word("Counting", false));
        expectedComponent.addComponent(Lexeme.word("this", false));
        expectedComponent.addComponent(Lexeme.word("expression", false));
        expectedComponent.addComponent(Lexeme.word("14", false));
        return new Object[][]{
                {
                        inputComponent,
                        expectedComponent
                }
        };
    }

    @Test(dataProvider = "dataForExpressionPositiveTest")
    public void calculateExpressionPositiveTest(Component inputComponent, Component expected) {
        Component actual = expressionAction.calculateExpression(inputComponent);
        Assert.assertEquals(actual, expected);
    }
}
