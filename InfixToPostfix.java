import java.util.Scanner;
import java.util.Stack;
/**
 * InfixToPostfix - takes input of an infix expression and converts it
 * to reverse Polish notation (postfix)
 *
 * @author Carissa Lau
 * @version 9/29/23
 */
public class InfixToPostfix
{
    public static void main(String[] args) {
        String infix; //input
        String postfix = ""; //output
        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();

        System.out.print("Enter an infix expression: ");
        infix = scan.nextLine();

        for(int i = 0; i < infix.length(); i++) {
            char symbol = infix.charAt(i);

            if(symbol == ' ' || symbol == '\t') { //tabs are single chars
                continue; //aborts current iteration
            }

            switch(symbol) {
                case '(':
                    stack.push(symbol);
                    break;
                case ')':
                    while(stack.peek() != '(') {
                        postfix += stack.pop();
                    }
                    stack.pop(); //remove the (
                    break;
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                case '^' :
                case '%' :
                    while(!stack.isEmpty() &&
                    precedence(stack.peek()) >= precedence(symbol)) {
                        postfix += stack.pop();
                    }
                    stack.push(symbol);
                    break;
                default: //operand
                    postfix += symbol;
            } //end switch

        } //end while loop to scan expression
        
        while(!stack.isEmpty()) {
            postfix += stack.pop();
        }
        System.out.println("Postfix: " + postfix);
    }

    private static int precedence(char symbol) {
        switch(symbol) {
            case '(' :
                return 0;
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
            case '%' :
                return 2;
            case '^' :
                return 3;
            default : //"else" reassures a last resort scenario
                return -1;
        }//end switch
    }
}
