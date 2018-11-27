package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;

public interface Parser {
    Component parse(String inputData);
}