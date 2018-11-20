package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Lexeme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser<Lexeme> {

    private Parser wordParser;
    private static final String LEXEME_REGEXP = "\\s";

    public LexemeParser() {
        wordParser = new WordParser();
    }

    @Override
    public List<Lexeme> parse(String text) {
        List<Lexeme> result = new ArrayList<>();
        Pattern paragraphPattern = Pattern.compile(LEXEME_REGEXP);
        Matcher matcher = paragraphPattern.matcher(text);

        while (matcher.find()) {
            String value = matcher.group();
            Lexeme lexeme = new Lexeme(value);
            result.add(lexeme);
        }

        return result;
    }
}//todo
