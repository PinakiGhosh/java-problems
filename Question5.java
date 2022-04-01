/**
 * Stack interface
 */
interface Stack<Type>
{
    void push(Type data) throws StackSizeExceeded;
    void pop();
    void peek();
    int size();
}
/**
 * Exception Classes
 */
class StackSizeExceeded extends Exception
{
    public StackSizeExceeded(String message) {super(message);}
}
class IllegalArgumentException extends Exception
{
    public IllegalArgumentException(String message) {super(message);}
}

/**
 * Node class
 */
class Node<Type>
{
    Type data;
    Node next;
    /**
     * Create node
     * @param data
     */
    public Node(Type data)
    {
        this.data = data;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public Type getData() {
        return data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

}
/**
 * LimitedStack Class
 */
class LimitedStack<Type> implements Stack<Type>
{
    private Node head;
    int maxStack;

    public LimitedStack(int max) throws IllegalArgumentException
    {
        /**
         * Validate Argument
         */
        if(max <= 0)
        {
            throw new IllegalArgumentException("Size cannot be {"+max+"}");
        }
        else {maxStack=max;}
    }

    /**
     * Push method
     * @param data
     */
    @Override
    public void push(Type data) throws StackSizeExceeded
    {
        if (maxStack>0)
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
            maxStack--;
        }
        else
        {throw new StackSizeExceeded("Stack size exceeded");}


    }
    /**
     * pop method
     */
    @Override
    public void pop()
    {
        if (size()!=0)
        {
            System.out.println(head.data);
            head=head.getNext();
        }
    }
    /**
     * peek method
     */
    @Override
    public void peek()
    {
        if (size()!=0)
        {
            System.out.println(head.data);
        }
    }
    /**
     * Size method
     */
    @Override
    public int size()
    {
        Node node = head;
        int size=0;
        try
        {
            while (node.getNext() != null)
            {
                size += 1;
                node = node.getNext();
            }
            size += 1;
        }
        catch(NullPointerException e)
        {
        }
        return size;
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
            catch (StackSizeExceeded e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            stack.show();
            System.out.println("peek---------------");

            stack.peek();
            System.out.println("pop----------------");

            stack.pop();
            System.out.println("-------------------");

            stack.show();
            System.out.println("-------------------");

            System.out.println(stack.size());
        }
        catch(IllegalArgumentException e){System.out.println(e.getMessage());System.exit(0);}
    }
}