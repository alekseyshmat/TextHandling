package com.epam.informationHandling.intepreter.expression;

import com.epam.informationHandling.intepreter.Context;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
