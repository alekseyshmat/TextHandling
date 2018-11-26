package com.epam.informationHandling.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Composite implements Component {
    private List<Component> components;

    public Composite() {
        components = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Composite composite = (Composite) obj;
        return composite.getChildren().equals(this.getChildren());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = new Random().nextInt(255);
        result = prime * result + this.getChildren().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components = " + components +
                "}";
    }
}
