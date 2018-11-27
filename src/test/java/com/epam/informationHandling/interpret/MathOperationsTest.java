package com.epam.informationHandling.interpret;

import com.epam.informationHandling.intepreter.MathOperations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MathOperationsTest {

    private MathOperations mathOperations;
    private static final String FIRST_EXPRESSION = "8274+*-";
    private static final String SECOND_EXPRESSION = "273+/";

    @BeforeClass
    public void setUp() {
        mathOperations = new MathOperations();
    }

    @DataProvider(name = "dataForClientPositiveTest")
    public Object[][] dataForClientPositiveTest() {
        return new Object[][]{
                {
                        FIRST_EXPRESSION,
                        "14"
                },
                {
                        SECOND_EXPRESSION,
                        "5"
                }
        };
    }

    @Test(dataProvider = "dataForClientPositiveTest")
    public void calculateTest(String expression, String expectedValue) {
        String actualValue = mathOperations.calculate(expression);
        Assert.assertEquals(actualValue, expectedValue);
    }
}
