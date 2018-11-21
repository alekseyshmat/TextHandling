package com.epam.informationHandling.intepreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Integer> contextValues;

    public Context() {
        contextValues = new ArrayDeque<>();
    }

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer values) {
        contextValues.push(values);
    }
}
