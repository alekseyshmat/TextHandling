package com.epam.informationHandling.composite;

import java.util.List;

public interface Component {
    void addComponent(Component component);

    List<Component> getChildren();

}
