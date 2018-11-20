package com.epam.informationHandling.chain;

import com.epam.informationHandling.composite.Component;

import java.util.List;

public interface Parser<T extends Component>  {
    //    void parse(Component component, String inputData);
    List<T> parse(String text);
}
