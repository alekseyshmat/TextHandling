package com.epam.informationHandling.interpret;

import com.epam.informationHandling.intepreter.Client;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClientTest {

    private Client client;
    private static final String FIRST_EXPRESSION = "8274+*-";
    private static final String SECOND_EXPRESSION = "274+*";

    @BeforeClass
    public void setUp() {
        client = new Client();
    }

    @DataProvider(name = "dataForClientPositiveTest")
    public Object[][] dataForClientPositiveTest() {
        return new Object[][]{
                {
                        FIRST_EXPRESSION,
                        14
                },
                {
                        SECOND_EXPRESSION,
                        22
                }
        };
    }

    @Test(dataProvider = "dataForClientPositiveTest")
    public void calculateTest(String expression, Number expectedValue) {
        String actualValue = client.calculate(expression);
        Assert.assertEquals(actualValue, expectedValue);
    }
}
