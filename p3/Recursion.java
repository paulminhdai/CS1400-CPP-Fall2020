/*
who: Dai (Paul) Vuong
what: CS1400.02
when: Dec 1st, 2020
why: Project 3 - Recursion
*/

public class Recursion {
    /** 
     * Compute recursively the number of "22" substrings in the string no overlap.
     * @param str This is the string
     * @return call the private count 22 no overlap recursive method
     */
    public int count22NoOverlap(String str) {
        if(str.length() < 2)
            return 0;

        if(str.charAt(0) == '2' && str.charAt(1) == '2')
            return 1 + count22NoOverlap(str.substring(2));

        return count22NoOverlap(str.substring(1));
    }


    /** 
     * Compute recursively the number of "22" substrings in the string overlap.
     * @param str This is a string
     * @return times "22" appears in the string overlap
     */
    public int count22Overlap(String str) {
        if(str.length() < 2)
            return 0;

        if(str.charAt(0) == '2' && str.charAt(1) == '2')
            return 1 + count22Overlap(str.substring(1));

        return count22Overlap(str.substring(1));
    }


    /** 
     * Compute recursively the number of consecutive elements 
     * that increase or decrease by a factor of 10
     * @param array This is the array contents elements need to compute
     * @param value This is stating point
     * @return number of consecutive elements that increase or decrease by a factor of 10
     */
    public int factorsOf10(int[] array, int value) {
        if (value >= array.length-1)
            return 0;

        if((array[value] * 10 == array[value + 1]) || (array[value] / 10 == array[value + 1])) 
            return 1 + factorsOf10(array, ++value);

        return factorsOf10(array, ++value);
    }


    /**
     * Check to see if the parentheses are balanced
     * @param string This is the string needs to check
     * @param stack This stack keep track of parentheses
     * @return balanced parentheses or not
     */
    public boolean balancedParens(String string, ArrayStack stack) {
        if(string.length() <= 0) {
            if(!stack.isEmpty())
                return false;
            return true;
        }
        if(string.charAt(0) == '(') {
            stack.push('(');
        }
        if(string.charAt(0) == ')') {
            if(stack.isEmpty()) 
                return false;
            stack.pop();
        }
        return balancedParens(string.substring(1), stack);
    }


    /** 
     * Reverse elements of the array using recursion
     * @param array This is the array contents elements need to reverse
     * @param index1 This is the left pointer
     * @param index2 This is the right pointer
     */
    public void reverseArray(Object[] array, int index1, int index2) {
        if (index1 < index2) {
            Object temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
            reverseArray(array, ++index1, --index2);
        }
    }
}