package com.bankbazaar.javaproblems;

/**
 * StackNode class
 */
class StackNode<Type>
{
    Type data;
    StackNode<Type> next;
    /**
     * Create node
     * @param data
     */
    public StackNode(Type data)
    {
        this.data = data;
        next = null;
    }

    public StackNode<Type> getNext() {
        return next;
    }

    public Type getData() {
        return data;
    }

    public void setNext(StackNode<Type> node) {
        this.next = node;
    }

}