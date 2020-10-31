/*
who: Dai (Paul) Vuong
what: CS1400.02
when: Nov 1st, 2020
why: Project 2 - Data Structures 
*/

public class Main {
    public static void main (String [] args) {
        String prompt_stack = "\n        ******** TEST ARRAYSTACK ********\n";
        String prompt_queue = "\n        ******** TEST ARRAYQUEUE ********\n";
        String bound = "\n\n---------------------------------------------------------------\n\n";
        
        System.out.println(prompt_stack);
        test_push_stack();
        test_pop_stack();
        test_peek_stack();
        test_isEmpty_stack();
        test_clear_stack();

        System.out.println(bound);

        System.out.println(prompt_queue);
        test_enqueue_queue();
        test_dequeue_queue();
        test_getFront_queue();
        test_isEmpty_queue();
        test_clear_queue();

    }

    /** Compares two integers and print out pass or fail. */
    public static void compareInt(int a, int b) {
        String pass = "PASSED.";
        String fail = "FAILED.";
        if (a == b) 
            System.out.println(pass);
        else
            System.out.println(fail);
    }

    /** Compares two booleans and print out pass or fail. */
    public static void compareBoolean(boolean a, boolean b) {
        String pass = "PASSED.";
        String fail = "FAILED.";
        if (a == b) 
            System.out.println(pass);
        else
            System.out.println(fail);
    }

    /** Test the push method of ArrayStack class. */
    public static void test_push_stack() {
        String title = "----------- Test push method -----------";
        String into = "\nThis function tests push function of ArrayStack class.";
        String test1 = "The stack is empty before push new item: "; 
        String test2 = "The stack is not empty after push new item: ";
        String result = "\nResult:";

        System.out.println(title + into);
        ArrayStack stack = new ArrayStack();

        System.out.println(result);

        System.out.print(test1);
        compareBoolean(stack.isEmpty(), true);
        
        System.out.print(test2);
        stack.push(88);
        compareBoolean(stack.isEmpty(), false);
        System.out.println();
    }

    /** Test the pop method of ArrayStack class. */
    public static void test_pop_stack() {
        String title = "--------------- Test pop method ---------------";
        String intro = "\nThis function tests pop function of ArrayStack class.";
        String test1 = "The method should return the top element of the stack: ";
        String test2 = "The stack should be empty after pop the last element of the stack: ";
        String test3 = "The method should catch an execepttion after pop the last element: ";
        String result = "\nResult:";
        String pass = "PASSED.";
        String fail = "FAILED.";

        System.out.println(title + intro);
        ArrayStack stack = new ArrayStack();
        
        System.out.println(result);
        stack.push(88);
        stack.push(99);
        
        System.out.print(test1);
        int temp = stack.pop();
        compareInt(temp, 99);

        System.out.print(test2);
        stack.pop();
        compareBoolean(stack.isEmpty(), true);

        try {
            stack.pop();
            stack.pop();
            System.out.println(fail);
        } 
        catch (Exception e) {
            System.out.println(test3 + pass);
        }
        System.out.println();
    }

    /** Test the peek method of ArrayStack class. */
    public static void test_peek_stack() {
        String title = "--------------- Test peek method ---------------";
        String intro = "\nThis function tests peek function of ArrayStack class.";
        String test1 = "The method should catch an execepttion if the stack is empty: ";
        String test2 = "The method should return the top element of the stack: ";
        String test3 = "The stack should not be empty after peek the last element of stack: ";
        String result = "\nResult:";
        String pass = "PASSED.";
        String fail = "FAILED.";

        System.out.println(title + intro);
        ArrayStack stack = new ArrayStack();
        
        System.out.println(result);

        System.out.print(test1);
        try {
            stack.peek();
            System.out.println(fail);
        } 
        catch (Exception e) {
            System.out.println(pass);
        }
        
        System.out.print(test2);
        stack.push(88);
        stack.push(99);
        int temp = stack.peek();
        compareInt(temp, 99);
        
        System.out.print(test3);
        compareBoolean(stack.isEmpty(), false);
        System.out.println();
    }

    /** Test the isEmpty method of ArrayStack class. */
    public static void test_isEmpty_stack() {
        String title = "--------------- Test isEmpty method ---------------";
        String intro = "\nThis function tests isEmpty function of ArrayStack class.";
        String test1 = "The stack should be empty before push new item: ";
        String test2 = "The stack should not be empty after push new item: ";
        String test3 = "The stack should be empty after pop the last element: ";
        String result = "\nResult:";

        System.out.println(title + intro);
        ArrayStack stack = new ArrayStack();

        System.out.println(result);

        System.out.print(test1);
        compareBoolean(stack.isEmpty(), true);
        stack.push(88);

        System.out.print(test2);
        compareBoolean(stack.isEmpty(), false);
        
        System.out.print(test3);
        stack.pop();
        compareBoolean(stack.isEmpty(), true);
        System.out.println();
    }

    /** Test the clear method of ArrayStack class. */
    public static void test_clear_stack() {
        String title = "--------------- Test clear method of stack ---------------";
        String explain = "\nThis function tests clear function of ArrayStack class.";
        String test1 = "The stack should be empty after clear method is called: ";
        String result = "\nResult:";

        System.out.println(title + explain);
        ArrayStack stack = new ArrayStack();

        System.out.println(result);
        stack.push(88);

        stack.clear();
        System.out.print(test1);
        compareBoolean(stack.isEmpty(), true);
        System.out.println();
    }

    /** Test the enqueue method of ArrayQueue class. */
    public static void test_enqueue_queue() {
        String title = "--------------- Test enqueue method ---------------";
        String intro = "\nThis function tests equeue function of ArrayQueue class.";
        String test1 = "The queue should be empty before enqueue new item: ";
        String test2 = "The queue should not be empty after enqueue new item: ";
        String result = "\nResult:";

        System.out.println(title + intro);
        ArrayQueue queue = new ArrayQueue();

        System.out.println(result);

        System.out.print(test1);
        compareBoolean(queue.isEmpty(), true);
        queue.enqueue(88);

        System.out.print(test2);
        compareBoolean(queue.isEmpty(), false);
        System.out.println();
    }

    /** Test the dequeue method of ArrayQueue class. */
    public static void test_dequeue_queue() {
        String title = "--------------- Test dequeue method ---------------";
        String intro = "\nThis function tests dequeue function of ArrayStack class: ";
        String test1 = "The method should return the front element of the queue: ";
        String test2 = "The queue should be empty after dequeue the all elements: ";
        String test3 = "The method should catch an execepttion if the queue is empty: ";
        String result = "\nResult:";
        String pass = "PASSED.";
        String fail = "FAILED.";

        System.out.println(title + intro);
        ArrayQueue queue = new ArrayQueue();
        
        System.out.println(result);
        queue.enqueue(88);

        System.out.print(test1);
        int temp = queue.dequeue();
        compareInt(temp, 88);

        System.out.print(test2);
        compareBoolean(queue.isEmpty(), true);

        System.out.print(test3);
        try {
            queue.dequeue();
            System.out.println(fail);
        } 
        catch (Exception e) {
            System.out.println(pass);
        }
        System.out.println();
    }

    /** Test the getFront method of ArrayQueue class. */
    public static void test_getFront_queue() {
        String title = "--------------- Test getFront method ---------------";
        String intro = "\nThis function tests getFront function of ArrayQueue class.";
        String test1 = "The method should catch an execepttion if the queue is empty: ";
        String test2 = "The method should return the front element of the queue: ";
        String test3 = "The queue should not be empty after getFront the last element: ";
        String result = "\nResult:";
        String pass = "PASSED.";
        String fail = "FAILED.";

        System.out.println(title + intro);
        ArrayQueue queue = new ArrayQueue();
        
        System.out.println(result);
        
        System.out.print(test1);
        try {
            queue.getFront();
            System.out.println(fail);
        } 
        catch (Exception e) {
            System.out.println(pass);
        }

        System.out.print(test2);
        queue.enqueue(88);
        queue.enqueue(99);
        int temp = queue.getFront();
        compareInt(temp, 88);

        System.out.print(test3);
        compareBoolean(queue.isEmpty(), false);
        System.out.println();
    }

    /** Test the isEmpty method of ArrayQueue class. */
    public static void test_isEmpty_queue() {
        String title = "--------------- Test isEmpty method ---------------";
        String intro = "\nThis function tests isEmpty function of ArrayQueue class.";
        String test1 = "The queue should be empty before enqueue new item: ";
        String test2 = "The queue should not be empty after enqueue new item: ";
        String test3 = "The queue should be empty after dequeue all elements: ";
        String result = "\nResult:";

        System.out.println(title + intro);
        ArrayQueue queue = new ArrayQueue();

        System.out.println(result);
        System.out.print(test1);
        compareBoolean(queue.isEmpty(), true);
        
        System.out.print(test2);
        queue.enqueue(88);
        compareBoolean(queue.isEmpty(), false);

        System.out.print(test3);
        queue.dequeue();
        compareBoolean(queue.isEmpty(), true);
        System.out.println();
    }

    /** Test the clear method of ArrayQueue class. */
    public static void test_clear_queue() {
        String title = "--------------- Test clear method ---------------";
        String explain = "\nThis function tests clear function of ArrayQueue class.";
        String test1 = "The queue should be empty after call clear method: ";
        String result = "\nResult:";

        System.out.println(title + explain);
        ArrayQueue queue = new ArrayQueue();

        System.out.println(result);
        queue.enqueue(88);
        queue.clear();
        System.out.print(test1);
        compareBoolean(queue.isEmpty(), true);
        System.out.println();
    }
}