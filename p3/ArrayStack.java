/*
who: Dai (Paul) Vuong
what: CS1400.02
when: Nov 1st, 2020
why: Project 2 - Data Structures 
*/

public class ArrayStack {

    private int top;
    private char[] store;
    private final int INIT_SIZE = 10;

    /**
     * Initializes an empty stack with size of INIT_SIZE.
     */
    public ArrayStack() {
        top = 0;
        store = new char[INIT_SIZE];
    }

    /**
     * Initializes an empty stack with size of choice.
     * If the size is less than 1, initializes an empty stack with size of INIT_SIZE.
     * @param size Size of the queue.
     */
    public ArrayStack(int size) {
        if (size < 1) {
            System.out.println("The size must be positive. Created a stack with size of " + INIT_SIZE);
            store = new char[INIT_SIZE];
        } 
        else
            store = new char[size];
        
        top = 0;  
    }

    /** Adds a new entry to the top of this stack.
     * @param newEntry An int to be added to the stack.
     */
    public void push(char newEntry) {
        if (top >= store.length)
            resize();

        store[top] = newEntry;
        top++;
    }

    /** Resize the list when it gets full. The new list has double size.*/
    private void resize() {
        char[] temp = store;
        store = new char[temp.length*2];

        for (int i = 0; i < top; i++)
            store[i] = temp[i];
    }

    /** Removes and returns this stack's top entry.
     * @return The int at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    public int pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        
        int temp = store[top-1];
        top--;

        return temp;
    }

    /** Retrieves the stack's top entry.
     * @return The int at the top of the stack/
     * @throws EmptyStackException if the stack is empty.
     */
    public int peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        return store[top - 1];
    }

    /** Detects whether this stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty() {
        return(top == 0);
    }

    /** Removes all entries from this stack.*/
    public void clear() {
        store = new char[top];
        top = 0;
    }
}