package com.bankbazaar.javaproblems;

/**
 * SinglyLinkedList class
 */
class SinglyLinkedList<Type>
{
    private ListNode head;
    /**
     * Add to end of list
     * @param data
     */
    public void addEnd(Type data)
    {
        ListNode<Type> node = new ListNode<>(data);

        if(head==null) {
            head = node;
        }

        else
        {
            ListNode cursor = head;
            while(cursor.getNext()!=null)
            {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }

    }
    /**
     * Add to start of list
     * @param data
     */
    public void addStart(Type data)
    {
        ListNode<Type> node = new ListNode<>(data);
        node.setNext(head);
        head = node;
    }

    /**
     * Add after an element
     * @param data
     * @param index
     */
    public void addAfter(int index,Type data)
    {
        ListNode<Type> node = new ListNode<>(data);

        ListNode cursor = head;
        for(int i=0;i<=index-1;i++)
        {
            cursor = cursor.getNext();
        }
        node.setNext(cursor.getNext());
        cursor.setNext(node);
    }

    /**
     * Delete from start of list
     */
    public void deleteStart()
    {
        head = head.getNext();
    }

    /**
     * Delete from end of list
     */
    public void deleteEnd()
    {
        ListNode cursor = head;
        ListNode checkEnd = null;
        while(cursor.getNext()!=null)
        {
            cursor = cursor.getNext();
            checkEnd = cursor.getNext();
            if (checkEnd.getNext()==null)
            {
                cursor.setNext(null);
            }
        }
    }

    /**
     * Delete after an index
     * @param index
     */
    public void deleteAfter(int index)
    {
        ListNode cursor = head;
        ListNode deleteIndex = null;
        for(int i=0;i<=index-1;i++)
        {
            cursor = cursor.getNext();
        }
        deleteIndex = cursor.getNext();
        cursor.setNext(deleteIndex.getNext());

        deleteIndex = null;
    }

    /**
     * Print list elements
     */
    public void show()
    {
        ListNode node = head;

        if (node != null) {
            while (node.getNext() != null) {
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println(node.getData());
        }
        else
        {
            System.out.println("List is empty");
        }

    }
}
