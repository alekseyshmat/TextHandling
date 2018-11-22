package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;

public interface Parser  {
        void parse(Component component, String inputData);
}