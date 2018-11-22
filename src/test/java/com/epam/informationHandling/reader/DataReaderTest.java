package com.epam.informationHandling.reader;

import com.epam.informationHandling.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReaderTest {

    private static final String PATH = "src/test/resources/testFile.txt";
    private DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @DataProvider(name = "dataForReadFilePositiveTest")
    public Object[][] dataForReadFilePositiveTest() {
        return new Object[][]{
                {
                        "    My name Aleksey. I'm 19 years old.\n" +
                                "    Today is thursday. 22.11.2018"
                }
        };
    }

    @Test(dataProvider = "dataForReadFilePositiveTest")
    public void readFilePositiveTest(String expectedString) throws ReadingFileException {
        String actual = dataReader.readFile(PATH);
        Assert.assertEquals(actual, expectedString);
    }
}