//Stack Interface
interface Stack<Type>
{
    void push(Type data) throws StackSizeExceeded;
    void pop();
    void peek();
    int size();
}

//Exception Classes
class StackSizeExceeded extends Exception
{
    public StackSizeExceeded(String message) {super(message);}
}
class IllegalArgumentException extends Exception
{
    public IllegalArgumentException(String message) {super(message);}
}

//Limited Stack Class
class LimitedStack<Type> implements Stack<Type>
{
    Node head;
    int max_stack;

    public LimitedStack(int max) throws IllegalArgumentException //LimitedStack Constructor
    {
        if(max <= 0) //Validate Argument
        {
            throw new IllegalArgumentException("Illegal Argument");
        }
        else max_stack=max;
    }

    private class Node //Create Node
    {
        Type data;
        Node next;
    }

    @Override
    public void push(Type data) throws StackSizeExceeded //Push method
    {
        if (size()<max_stack)
        {
            Node node = new Node();
            node.data = data;
            node.next = null;

            if(head==null) head = node;

            else
            {
                node.next=head;
                head = node;
            }
        }
        else throw new StackSizeExceeded("Stack size exceeded");


    }

    @Override
    public void pop() //Pop method
    {
        if (size()!=0)
        {
            System.out.println(head.data);
            head=head.next;
        }
    }

    @Override
    public void peek() //Peek method
    {
        if (size()!=0)
        {
            System.out.println(head.data);
        }
    }

    @Override
    public int size() //Size method
    {
        Node node = head;
        int size=0;
        try
        {
            while (node.next != null)
            {
                size += 1;
                node = node.next;
            }
            size += 1;
        }
        catch(NullPointerException e)
        {
        }
        return size;
    }

    public void show() //Show elements in stack
    {
        Node node = head;
    try
    {
        while (node.next != null)
        {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
    catch(NullPointerException e)
    {
        System.out.println("Stack is empty");
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
                //Push elements to stack
                stack.push("hello1");
                stack.push("hello2");
                stack.push("hello3");
            }
            catch (StackSizeExceeded e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            stack.show(); //Show elements
            System.out.println("peek---------------");
            stack.peek(); //Peek top element
            System.out.println("pop----------------");
            stack.pop(); //Pop top element
            System.out.println("-------------------");
            stack.show(); //Show elements
            System.out.println("-------------------");
            System.out.println(stack.size()); //Get size
        }
        catch(IllegalArgumentException e){System.out.println(e.getMessage());System.exit(0);}
    }
}