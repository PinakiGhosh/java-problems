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
/**
 * Exception Classes
 */
class StackSizeException extends Exception
{
    public StackSizeException(String message) {super(message);}
}

/**
 * Node class
 */
class Node<Type>
{
    Type data;
    Node<Type> next;
    /**
     * Create node
     * @param data
     */
    public Node(Type data)
    {
        this.data = data;
        next = null;
    }

    public Node<Type> getNext() {
        return next;
    }

    public Type getData() {
        return data;
    }

    public void setNext(Node<Type> node) {
        this.next = node;
    }

}
/**
 * LimitedStack Class
 */
class LimitedStack<Type> implements Stack<Type>
{
    private Node<Type> head;
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
            Node<Type> node = new Node<>(data);

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
        Node node = head;
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

public class Question5
{
    public static void main (String[] args)
    {
        try {
            LimitedStack<String> stack = new LimitedStack<String>(3);
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