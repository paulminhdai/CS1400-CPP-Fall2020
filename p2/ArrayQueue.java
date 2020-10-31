public class ArrayQueue {

    private int[] store;
    private int counter;
    private int front;
    private int back;
    
    /**
     * Initializes an empty queue with size of 10
     */
    public ArrayQueue() {
        counter = 0;
        front = 0;
        back = 0;
        store = new int[10];
    }

    /**
     * Initializes an empty queue with size of choice.
     * If the size is less than 1, initializes an empty queue with size of 10.
     * @param size Size of the queue.
     */
    public ArrayQueue(int size) {
        if (size < 1){
            System.out.println("The size must be positive. Created a queue of size 10.");
            store = new int[10];
        } 
        else
            store = new int[size];

        counter = 0;
        front = 0;
        back = 0;
    }

    /** Adds a new entry to the back of this queue.
     * @param newEntry An int to be added.
     */
    public void enqueue(int newEntry) {
        if(counter == store.length)
            resize();

        store[back] = newEntry;

        back++;
        if(back == store.length)
            back = 0;
        
        counter++;
    }

    /** Resize the list when it gets full. The new list has double size.*/
    private void resize() {
        int[] temp = store;
        store = new int[temp.length*2];

        for (int i = 0; i < counter; i++)
            store[i] = temp[(front + i) % temp.length];
        front = 0;
        back = counter;
    }

    /** Removes and returns the entry at the front of this queue.
     * @return The int at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public int dequeue() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException();
        int result = store[front];
        counter--;
        front++;
        if(front == store.length)
            front = 0;

        return result;
    }

    /** Retrieves the entry at the front of this queue.
     * @return The int at the front of the queue/
     * @throws EmptyQueueException if the queue is empty.
     */
    public int getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        
        return store[front];
    }

    /** Detects whether this queue is empty.
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty() {
        return (counter == 0);
    }

    /** Removes all entries from this queue.*/
    public void clear() {
        store = new int [counter];
        counter = 0;
        front = 0;
        back = 0;
    }
}
