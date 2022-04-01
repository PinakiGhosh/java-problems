//SinglyLinkedList class
class SinglyLinkedList<Type>
{
    Node head;

    private class Node //Create node
    {
        Type data;
        Node next;
    }

    public void add_end(Type data) //Add to end of list
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head==null) head = node;

        else
        {
            Node cursor = head;
            while(cursor.next!=null)
            {
                cursor = cursor.next;
            }
            cursor.next = node;
        }

    }
    public void add_start(Type data) //Add to start of list
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void add_after(int index,Type data) //Add after an element
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        Node cursor = head;
        for(int i=0;i<=index-1;i++)
        {
            cursor = cursor.next;
        }
        node.next = cursor.next;
        cursor.next = node;
    }

    public void delete_start() //Delete from start of list
    {
        head = head.next;
    }

    public void delete_end() //Delete from end of list
    {
        Node cursor = head;
        int size=0;
        while(cursor.next!=null)
        {
            cursor = cursor.next;
            size+=1;
        }
        delete_after(size-1);
    }
    public void delete_after(int index) //Delete after an index
    {
        Node cursor = head;
        Node delete_index = null;
        for(int i=0;i<=index-1;i++)
        {
            cursor = cursor.next;
        }
        delete_index = cursor.next;
        cursor.next = delete_index.next;

        delete_index = null;
    }

    public void show() //Print list elements
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


public class Question2{


    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        //Add elements
        list.add_end("hello");
        list.add_end("world");

        //Add element at start
        list.add_start("new");

        //Add element after index:1
        list.add_after(1,"my");

        //Show elements
        list.show();
        System.out.println("----------------");

        //Delete element at start
        list.delete_start();

        //Delete element at end
        list.delete_end();

        //Delete element after index:0
        list.delete_after(0);

        //Show elements
        list.show();
    }
}