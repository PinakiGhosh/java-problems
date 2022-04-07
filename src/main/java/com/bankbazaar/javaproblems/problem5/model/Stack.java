package com.bankbazaar.javaproblems.problem5.model;

import com.bankbazaar.javaproblems.problem5.exceptions.StackSizeException;

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