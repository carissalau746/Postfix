import java.util.Stack;
import java.util.Scanner;
/**
 * post fix evaluator
 *
 * @author Carissa
 * @version 10/3/23
 */
public class PostfixEvaluator
{
    public static int evaluate(String expression) throws PostfixException {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner reader = new Scanner(expression);
        while(reader.hasNext()) {
            if(reader.hasNextInt()) 
                stack.push(reader.nextInt());
            else {
                String operator = reader.next();
                if(stack.size() < 2) {
                    throw new PostfixException("you suck at postfix!");
                }
                int x = stack.pop();
                int y = stack.pop();
                stack.push(operate(operator,x,y));
            }
        }
        if(stack.size() != 1) {
            throw new PostfixException("you suck at postfix!");
        }
        return stack.peek();
    }

    public static int operate(String o, int a, int b) {
        switch(o) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                return -1;
        }
    }
}
