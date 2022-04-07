package com.bankbazaar.javaproblems;

/**
 * LimitedStack Class
 */
class LimitedStack<Type> implements Stack<Type>
{
    private StackNode<Type> head;
    private int maxSize;
    private int stackSize;

    public LimitedStack(int max) throws IllegalArgumentException
    {
        /**
         * Validate Argument
         */
        if(max <= 0)
        {
            throw new IllegalArgumentException("Size cannot be {"+max+"}");
        }
        else {maxSize=max;stackSize=0;}
    }

    /**
     * Push method
     * @param data
     */
    @Override
    public void push(Type data) throws StackSizeException
    {
        if (size()<maxSize)
        {
            StackNode<Type> node = new StackNode<>(data);

            if(head==null) {
                head = node;
            }

            else
            {
                node.setNext(head);
                head = node;
            }
            stackSize++;
        }
        else
        {throw new StackSizeException("Stack size exceeded");}


    }
    /**
     * pop method
     */
    @Override
    public Type pop()
    {
        if (size()!=0)
        {
            Type popData = head.data;
            head=head.getNext();
            stackSize--;
            return popData;
        }

        return null;
    }
    /**
     * peek method
     */
    @Override
    public Type peek()
    {
        if (size()!=0)
        {
            Type peekData = head.data;
            return peekData;
        }
        return null;
    }
    /**
     * Size method
     */
    @Override
    public int size()
    {
        return stackSize;
    }

    /**
     * Show elements in stack
     */
    public void show()
    {
        StackNode node = head;
        if (size()==0)
        {
            System.out.println("Stack is empty");
        }
        else {
            while (node.getNext() != null) {
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println(node.getData());
        }


    }
}
