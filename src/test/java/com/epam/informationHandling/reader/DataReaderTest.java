package com.epam.informationHandling.reader;

import com.epam.informationHandling.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataReaderTest {

    private static final Path VALID_PATH = Paths.get("src/test/resources/testFile.txt");
    private static final Path INVALID_PATH = Paths.get("src/test/resources/noTestFile.txt");
    private DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @DataProvider(name = "dataForReadFilePositiveTest")
    public Object[][] dataForReadFilePositiveTest() {
        return new Object[][]{
                {
                        "    My name Aleksey. I'm 19 years old."
                }
        };
    }


    @Test(dataProvider = "dataForReadFilePositiveTest")
    public void readFilePositiveTest(String expectedString) {
        String actual = null;
        try {
            actual = dataReader.readFile(VALID_PATH);
        } catch (ReadingFileException e) {
        }
        Assert.assertEquals(actual, expectedString);
    }

    @Test(expectedExceptions = ReadingFileException.class)
    public void readFileNegativeTest() throws ReadingFileException {
        String actual = dataReader.readFile(INVALID_PATH);
    }
}
