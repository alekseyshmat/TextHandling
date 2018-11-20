package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements Parser<Word> {

    public static final String WORD_REGEX = "[A-Za-z]+";
    public static final String EXPRESSION_REGEX = "[\\d&()|^<>]+";

    @Override
    public List<Word> parse(String text) {
        List<Word> result = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = sentencePattern.matcher(text);

        while (matcher.find()) {
            String value = matcher.group();
            Word word = new Word(value);
            result.add(word);
        }


        return result;
    }//todo
}
