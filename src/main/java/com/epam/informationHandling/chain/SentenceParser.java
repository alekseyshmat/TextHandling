package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser<Sentence> {
    private final String SENTENSE_REGEXP = "[A-Z].+([!]|[?]|[.]|[...])";
    private Parser lexemeParser;

    public SentenceParser() {
        lexemeParser = new LexemeParser();
    }


    @Override
    public List<Sentence> parse(String text) {
        List<Sentence> result = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile(SENTENSE_REGEXP);
        Matcher matcher = sentencePattern.matcher(text);
        while (matcher.find()) {
            String value = matcher.group();
            Sentence sentence = new Sentence(value);
            result.add(sentence);
        }

        return result;
    }
}//todo
