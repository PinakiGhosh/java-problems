package com.bankbazaar.javaproblems;

/**
 * ListNode class
 */
class ListNode<Type>
{
    Type data;
    ListNode next;
    /**
     * Create node
     * @param data
     */
    public ListNode(Type data)
    {
        this.data = data;
        next = null;
    }

    public ListNode getNext() {
        return next;
    }

    public Type getData() {
        return data;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

}
