import java.util.Scanner;
public class InfixPostfixTester

{
    public static void main(String[] args)
    {
        int choice, value;
        Scanner scan = new Scanner(System.in);
        IntegerArrayStack stack = new IntegerArrayStack(30);
        
        while(true)
        {
            System.out.println("1.  Push an element on the stack");
            System.out.println("2.  Pop an element from the stack");
            System.out.println("3.  Display the top element");
            System.out.println("4.  Display all stack elements");
            System.out.println("5.  Display size of stack");
            System.out.println("6.  Quit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            
            if(choice == 6) break;
            switch(choice)
            {
                case 1:
                    System.out.print("Enter element to be pushed: ");
                    value = scan.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    value = stack.pop();
                    System.out.println("Popped element is " + value);
                    break;
                case 3:
                    System.out.println("Element on top is " +  stack.peek());
                    break;
                case 4:
                    System.out.println(stack);
                    break;
                case 5:
                    System.out.println("Size of stack is " + stack.size());
                    break;
                case 6:
                    System.out.print("What value do you want to search for?");
                    value = scan.nextInt();
                    if(stack.search(value) == -1)
                        System.out.println("The value isn't in the stack");
                    else
                        System.out.println(value + " is at position " + stack.search(value));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}