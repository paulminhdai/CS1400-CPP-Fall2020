/*
who: Dai (Paul) Vuong
what: CS1400.02
when: Dec 1st, 2020
why: Project 3 - Recursion
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String title = "\nTest Recursion class: ";
        String line = "\n-------------------------\n";
        System.out.print(title + line);

        count22NoOverlapTest();
        count22OverlapTest();
        factorsOf10Test();
        balancedParensTest();
        reverseArrayTest();
    }

    /** Test count22NoOverlap */
    public static void count22NoOverlapTest() {
        String title = "\nTest count22NoOverlap method: ";
        String pass = "PASSED";
        String fail = "FAILED";

        System.out.println(title);
        
        Recursion test = new Recursion();
        String[] testCases = {"22abc22", "abc22x22x22", "222", "22222"};
        int[] expected = {2, 3, 1, 2};

        boolean[] result = new boolean [testCases.length];
        for(int i = 0; i < testCases.length; i++) {
            int actual = test.count22NoOverlap(testCases[i]);
            if(expected[i] != actual)
                result[i] = false;
            else
                result[i] = true;
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i])
                System.out.printf("\tTest case %d  %13s: %s%n", i, testCases[i], pass);
            else
                System.out.printf("\tTest case %d  %13s: %s%n", i, testCases[i], fail);
        }
    }

    /** Test count22Overlap */
    public static void count22OverlapTest() {
        String title = "\nTest count22Overlap method: ";
        String pass = "PASSED";
        String fail = "FAILED";

        System.out.println(title);

        Recursion test = new Recursion();
        String[] testCases = {"22abc22", "abc22x22x22", "222", "abc222222", "22222"};
        int[] expected = {2, 3, 2, 5, 4};

        boolean[] result = new boolean [testCases.length];
        for(int i = 0; i < testCases.length; i++) {
            int actual = test.count22Overlap(testCases[i]);
            if(expected[i] != actual)
                result[i] = false;
            else
                result[i] = true;
        }
        for(int i = 0; i < result.length; i++) {
            if(result[i])
                System.out.printf("\tTest case %d  %13s: %s%n", i, testCases[i], pass);
            else
                System.out.printf("\tTest case %d  %13s: %s%n", i, testCases[i], fail);
        }
    }

    /** Test factorsOf10 */
    public static void factorsOf10Test() {
        String title = "\nTest factorsOf10 method: ";
        String pass = "PASSED";
        String fail = "FAILED";

        System.out.println(title);

        Recursion test = new Recursion();
        int[][] testCases = {{1, 10, 20}, 
                             {100, 10, 20, 200},
                             {1000, 100, 10, 1, 10},
                             {10, 20, 33, 340},
                             {10, 100, 1000, 100}};
        int[] expected = {1, 2, 4, 0, 3};

        boolean[] result = new boolean [testCases.length];
        for(int i = 0; i < testCases.length; i++) {
            int actual = test.factorsOf10(testCases[i], 0);
            if(expected[i] != actual) 
                result[i] = false;
            else
                result[i] = true;
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i])
                System.out.printf("\tTest case %d  %23s: %s%n", i, Arrays.toString(testCases[i]), pass);
            else
                System.out.printf("\tTest case %d  %23s: %s%n", i, Arrays.toString(testCases[i]), fail);
        }
    }

    /** Test balancedParens */
    public static void balancedParensTest() {
        String title = "\nTest balancedParens method: ";
        String pass = "PASSED";
        String fail = "FAILED";

        System.out.println(title);

        Recursion test = new Recursion();
        String[] testCases = {"(a+b) * c",
                              "c", 
                              "((a+b) * c)", 
                              "(a+b) * c)", 
                              "(a+b * c",
                              "asdawe)"};
        boolean[] expected = {true, true, true, false, false, false};

        boolean[] result = new boolean [testCases.length];
        for(int i = 0; i < testCases.length; i++) {
            ArrayStack stack = new ArrayStack();
            boolean actual = test.balancedParens(testCases[i], stack);
            if(expected[i] != actual) 
                result[i] = false;
            else
                result[i] = true;
        }
        
        for(int i = 0; i < result.length; i++) {
            if(result[i])
                System.out.printf("\tTest case %d  %12s: %s%n", i, testCases[i], pass);
            else
                System.out.printf("\tTest case %d  %12s: %s%n", i, testCases[i], fail);
        }
    }

    /** Test reverseArray*/
    public static void reverseArrayTest() {
        String title = "\nTest reverseArray method: ";
        String pass = "PASSED";
        String fail = "FAILED";

        System.out.println(title);

        Recursion test = new Recursion();
        String[] testcase = {"one", "two", "three", "four", "five"};
        String[] expected = {"five", "four", "three", "two", "one"};

        System.out.printf("\tBefore reversed  %s%n", Arrays.toString(testcase));

        test.reverseArray(testcase, 0, testcase.length - 1);
        boolean result = true;
        for(int i = 0; i < testcase.length; i++){
            if(!testcase[i].equals(expected[i]))
                result = false;
        }
        if(result)
            System.out.printf("\tAfter reversed  %s: %s%n", Arrays.toString(testcase), pass);
        else
            System.out.printf("\tAfter reversed  %s: %s%n", Arrays.toString(testcase), fail);
    }

}
