package evaluatorExpresii;

import java.util.*;

public class EvaluatorExpresii {

    static class OperatorList {
        private static List<Character> operators = new ArrayList<Character>();

        OperatorList() {
            operators.add('+');
            operators.add('-');
            operators.add('*');
            operators.add('/');
            operators.add('^');
        }


        public List<Character> getList() {
            return operators;
        }
    }
    public static String convertPostfix(Scanner sc) {
        Deque<Character> operatorStack = new ArrayDeque<Character>();
        OperatorList operators = new OperatorList();
        String expression = sc.nextLine();
        String postfix = "";
        String errMessage = "error";
        String auxiliary = readExpression(expression, postfix, operators, operatorStack);

        if (auxiliary == null) {
            return errMessage;
        } else {
            postfix = auxiliary;
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return errMessage;
            } else {
                postfix += operatorStack.pop();
            }
        }
        return postfix;
    }

    static String readExpression(String expression, String postfix, OperatorList operators,
                                 Deque<Character> operatorStack) {

        for (int i = 0; i < expression.length(); i++) {
            char exChar = expression.charAt(i);
            if (Character.isWhitespace(exChar)) { //performance
                continue;
            }

            if (Character.isLetter(exChar)) { // performance
                return null;
            }


            if (Character.isDigit(exChar)) {
                postfix += exChar;
            } else if (operators.getList().contains(exChar)) {
                while (!operatorStack.isEmpty() && (operatorStack.peek() != '(' && (getPrecedence(operatorStack.peek()) > getPrecedence(exChar))
                        || (getPrecedence(operatorStack.peek()) == getPrecedence(exChar) && getPrecedence(exChar) != 3))) {
                    postfix += operatorStack.pop();
                }
                operatorStack.push(exChar);
            } else if (exChar == '(') {
                operatorStack.push(exChar);
            } else if (exChar == ')') {
                while (operatorStack.peek() != '(') {
                    postfix += operatorStack.pop();
                }
                if (operatorStack.isEmpty()) {
                    return null;
                }
                operatorStack.pop();
            }
        }
        return postfix;
    }

    public static void postfixEval(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result;
        char exChar = Character.MIN_VALUE;
        OperatorList operators = new OperatorList();
        System.out.println(expression);
        for (int i = 0; i < expression.length(); i++) {
            exChar = expression.charAt(i);
            if (Character.isDigit(exChar)) {
                stack.push(Character.getNumericValue(exChar));
            } else if (operators.getList().contains(exChar)) {
                containOperatorsSwitch(stack, exChar);
            }
        }
        result = stack.pop();
        System.out.println(result);
    }

    static void containOperatorsSwitch(Deque<Integer> stack, char exChar) {
       int op2 = stack.pop();
       int op1 = stack.pop();
        switch (exChar) {
            case '+' -> stack.push(op1 + op2);
            case '-' -> stack.push(op1 - op2);
            case '*' -> stack.push(op1 * op2);
            case '/' -> stack.push(op1 / op2);
            case '^' -> {
                if (op2 == 0) {
                    stack.push(1);
                    break;
                } else if (op2 == 1) {
                    stack.push(op1);
                    break;
                }
                int temp = op1;
                while (--op2 > 0) {
                    op1 *= temp;
                }
                stack.push(op1);
            }
        }
    }

    static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = convertPostfix(sc);
        System.out.println(expression);
        sc.close();
        postfixEval(expression);

    }
}
