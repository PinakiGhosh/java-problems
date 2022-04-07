package com.bankbazaar.javaproblems.problem5.problem;

import com.bankbazaar.javaproblems.problem5.exceptions.StackSizeException;
import com.bankbazaar.javaproblems.problem5.model.LimitedStack;

public class Problem5 {
    public static void main (String[] args)
    {
        try {
            LimitedStack<String> stack = new LimitedStack<>(3);
            try {
                /**
                 * Push elements in stack
                 */
                stack.push("hello1");
                stack.push("hello2");
                stack.push("hello3");
            }
            catch (StackSizeException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            stack.show();
            System.out.println("peek---------------");

            System.out.println(stack.peek());
            System.out.println("pop----------------");

            System.out.println(stack.pop());
            System.out.println("-------------------");

            stack.show();
            System.out.println("-------------------");

            System.out.println(stack.size());
        }
        catch(IllegalArgumentException e){System.out.println(e.getMessage());System.exit(0);}
    }
}
