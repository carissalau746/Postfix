
/**
 * IntegerArrayStack - this class allows us to create stacks of Integers,
 * implemented by using an array
 *
 * @author Carissa
 * @version 9/13
 */
public class IntegerArrayStack implements StackInterface<Integer> 
{
    private int[] stack;
    private int size; //logical size of stack (amount currently inside)
    
    public IntegerArrayStack() {
        stack = new int[0];
        size = 0;
    }
    
    public IntegerArrayStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean empty() {
        if(size == 0)
            return true;
        return false;
    }
    public Integer peek() throws StackUnderflowException {
        if(size == 0) {
            throw new StackUnderflowException("too small"); 
        }
        return stack[size-1];
        }
    public Integer pop() throws StackUnderflowException {
        if(size == 0) {
            throw new StackUnderflowException("too small");
        }
        int a = stack[size-1];
        stack[size-1] = 0;
        size--;
        return a;
    }
    public Integer push(Integer item) {
        stack[size] = item;
        size++;
        return item;
    }
    public void clear() {
        for(int i = 0; i < size; i++) {
            stack[i] = 0;
        }
        size = 0;
    }
    public int search(Integer search) {
        for(int i = 0; i < size; i++) {
            if(stack[i] == search)
                return i;
        }
        return 0;
    }
    public String toString() {
        if(empty())
            return "Stack is empty";
        String output = "Stack is: \n";
        for(int i = size - 1; i >= 0; i--) {
            output += stack[i] + "\n";
        }
        return output;
    }
}
