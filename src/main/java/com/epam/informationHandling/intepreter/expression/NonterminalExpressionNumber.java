package com.epam.informationHandling.intepreter.expression;

import com.epam.informationHandling.intepreter.Context;

public class NonterminalExpressionNumber extends AbstractMathExpression {
    private int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
