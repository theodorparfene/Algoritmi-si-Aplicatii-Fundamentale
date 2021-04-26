package StivaCozi;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                     break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                     break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println("Is the input valid? " + vp.isValid("(())"));
    }
}
