import java.util.Stack;

public class Stack_PA
{
    /************************ to be solved ***********************/

    /* @param stack - is a stack of Integer values
     * 
     * precondition - stack contains at least two elements
     * 
     * postcondition - returns the sum of the all the integers within the stack
     *                 without changing the original stack
     */
    public static int sumStack(Stack<Integer> stack)
    {
        Stack<Integer> temp =  (Stack<Integer>)stack.clone();
        int res = 0;
        while(!temp.isEmpty())
        res += temp.pop();


        return res; 
    }

    /* @param stack - is a stack of Integer values
     * @param odd - is an empty stack
     * @param even - is an empty stack
     * 
     * precondition - no preconditions
     * 
     * postcondition - Removes each element from stack and places it in either 
     *                 the odd stack or the even stack based on the element
     *                 stack will be empty at the end of the call
     */
    public static void splitStack(Stack<Integer> stack, Stack<Integer> odd, Stack<Integer> even)
    {
        while(!stack.isEmpty())
        {
            int i = stack.pop();
            if(i % 2 != 0)
            odd.push(i);
            else
            even.push(i);
        }
    }

    /* @param stack - is a stack of Integer values
     * 
     * precondition - no preconditions
     * 
     * postcondition - Removes all duplicates in a stack and leaves the 
     *                 stack in the same relative order
     *                 Example:
     *                 original stack ==> [4, 6, 7, 4, 2, 7]
     *                 final stack ==> [4, 6, 7, 2]
     */
    public static int removeDuplicates(Stack<Integer> stack) {
        int count = 0;
        Stack<Integer> temp = new Stack<>();
    
        while (!stack.isEmpty()) {
            int num = stack.pop();
    
            if (!temp.contains(num)) {
                temp.push(num);
                count++;
            }
        }
    
        // Restore the original order in the original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    
        return count;
    }
    

    /* @param stack - is a stack of Integer values
     * @param element - value of the element to be removed
     * 
     * precondition - no precodition
     * 
     * postcondition - Removes the first occurrence of a specific element from a stack, leaving 
     *                 the other elements in the stack in the same relative order
     */
    public static void removeFirstOccurrence(Stack<Integer> stack, int element) {
        int count = 0;
        Stack<Integer> temp = new Stack<>();
    
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count == 0 && num == element) {
                count++;
            } else {
                temp.push(num);
            }
        }
    
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    

    /* @param stack - is a stack of String values
     * @param element - value of the element to be removed
     * 
     * precondition - no precodition
     * 
     * postcondition - Removes all occurrances of a specific element from a stack, leaving 
     *                 the other elements in the stack in the same relative order
     */
    public static void removeAllOccurrences(Stack<String> stack, String element) {
        Stack<String> temp = new Stack<>();

        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (!str.equals(element)) {
                temp.push(str);
            }
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    /****************** Testing **********************************/
    public static void main(String[] args)
    {
        System.out.println("********** Sum Stack Output *********");
        // Creating a Stack
        Stack<Integer> numbers = new Stack<Integer>();
        // Pushing new items to the Stack
        numbers.push(15);
        numbers.push(3);
        numbers.push(9);
        numbers.push(-2);
        numbers.push(10);
        //display stack
        System.out.println("Stack => " + numbers);
        System.out.println();
        //sum up stack values and display
        int sum = sumStack(numbers);
        System.out.println("Sum of the numbers in the Stack => " + sum);
        System.out.println("Stack => " + numbers);
        System.out.println();

        System.out.println("********** Even and Odd Stack Output *********");
        // Creating a Stack
        Stack<Integer> list = new Stack<Integer>();
        Stack<Integer> odd = new Stack<Integer>();
        Stack<Integer> even = new Stack<Integer>();

        // Pushing random elements on the Stack
        for(int i = 0; i < 100; i ++)
            list.push((int)(Math.random() * 100) + 1);

        //display stack
        System.out.println("Stack => " + list);
        System.out.println();

        //splitStack into odd andd even
        splitStack(list, odd, even);
        System.out.println("Stack => " + list);
        System.out.println("Odd => " + odd);
        System.out.println("Even => " + even);
        System.out.println();

        System.out.println("********** Remove Duplicate Stack Output *********");
        //removes duplicates from odd and even
        System.out.println("Number duplicates in Odd => " + removeDuplicates(odd));
        System.out.println("Odd => " + odd);
        System.out.println("Number duplicates in even => " + removeDuplicates(even));
        System.out.println("Even => " + even);
        System.out.println();

        
        System.out.println("********** Remove First Occurrence Stack Output *********");
        // Creating a Stack
        list = new Stack<Integer>();

        // Pushing new items to the Stack
        list.push(5);
        list.push(3);
        list.push(9);
        list.push(2);
        list.push(3);
        list.push(8);
        list.push(4);

        //display stack
        System.out.println("Stack => " + list);
        System.out.println();

        //remove specific elements from stack and display
        removeFirstOccurrence(list, 9);
        System.out.println("Element 9 removed - Stack => " + list);
        removeFirstOccurrence(list, 1);
        System.out.println("Element 1 removed - Stack => " + list);
        removeFirstOccurrence(list, 3);
        System.out.println("Element 3 removed - Stack => " + list);
        System.out.println();

        System.out.println("********** Remove All Occurrence Stack Output *********");
        // Creating a Stack
        Stack<String> list2 = new Stack<String>();

        // Pushing new items to the Stack
        list2.push("C");
        list2.push("F");
        list2.push("Q");
        list2.push("C");
        list2.push("B");
        list2.push("A");
        list2.push("C");

        //display stack
        System.out.println("Stack => " + list2);
        System.out.println();

        //remove specific elements from stack and display
        removeAllOccurrences(list2, "A");
        System.out.println("Element \"A\" removed - Stack => " + list2);
        removeAllOccurrences(list2, "Q");
        System.out.println("Element \"Q\" removed - Stack => " + list2);
        removeAllOccurrences(list2, "C");
        System.out.println("Element \"C\" removed - Stack => " + list2);
        System.out.println();

    }
}
