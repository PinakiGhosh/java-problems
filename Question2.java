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
 * SinglyLinkedList class
 */
class SinglyLinkedList<Type>
{
    private Node head;
    /**
     * Add to end of list
     * @param data
     */
    public void addEnd(Type data)
    {
        Node<Type> node = new Node<>(data);

        if(head==null) {
            head = node;
        }

        else
        {
            Node cursor = head;
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
        Node<Type> node = new Node<>(data);
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
        Node<Type> node = new Node<>(data);

        Node cursor = head;
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
        Node cursor = head;
        int size=0;
        while(cursor.getNext()!=null)
        {
            cursor = cursor.getNext();
            size+=1;
        }
        deleteAfter(size-1);
    }

    /**
     * Delete after an index
     * @param index
     */
    public void deleteAfter(int index)
    {
        Node cursor = head;
        Node deleteIndex = null;
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
        Node node = head;
        try
        {
            while (node.getNext() != null)
            {
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println(node.getData());
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

        list.addEnd("hello");
        list.addEnd("world");

        list.addStart("new");

        list.addAfter(1,"my");

        list.show();

        System.out.println("----------------");

        list.deleteStart();

        list.deleteEnd();

        list.deleteAfter(0);

        list.show();
    }
}