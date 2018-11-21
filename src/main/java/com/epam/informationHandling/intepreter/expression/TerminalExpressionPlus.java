package com.epam.informationHandling.intepreter.expression;

import com.epam.informationHandling.intepreter.Context;

public class TerminalExpressionPlus extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
