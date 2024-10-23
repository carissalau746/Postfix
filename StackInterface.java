
/**
 * StackInterface - methods for stacks
 *
 * @author Carissa
 * @version 9/13/23
 */
public interface StackInterface<T> {
    public int size();
    public boolean empty();
    public T peek() throws StackUnderflowException;
    public T pop() throws StackUnderflowException;
    public T push(T item);
    public void clear();
    public int search(T search);
}

