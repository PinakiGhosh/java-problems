package com.bankbazaar.javaproblems;

/**
 * Stack interface
 */
interface Stack<Type>
{
    void push(Type data) throws StackSizeException;
    Type pop();
    Type peek();
    int size();
}