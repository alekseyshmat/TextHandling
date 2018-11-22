package com.epam.informationHandling.intepreter;

import com.epam.informationHandling.intepreter.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private List<AbstractMathExpression> listExpressions;

    public Client() {
        listExpressions = new ArrayList<>();
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpressions.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpressions.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpressions.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNext()) {
                        int tempNumber = scanner.nextInt();
                        listExpressions.add(new NonterminalExpressionNumber(tempNumber));
                    }
            }
        }
    }

    public Number calculate(String expression) {
        parse(expression);
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
