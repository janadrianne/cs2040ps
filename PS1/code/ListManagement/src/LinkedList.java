/**
 * LinkedList
 * Description:  linked list implementation
 * CS2040 2018
 */


/**
 * Class: LinkedList
 * Description: linked list implementation
 * All the elements in the list are integers >= 0.
 */

public class LinkedList implements List {

    protected class Node {
        protected int data;
        protected Node next;

        public Node()
        {
            data = 0;
            next = null;
        }

        public Node(int data, Node n) {
            //todo
            this.data = data;
            next = n;
        }
    };

    Node head;

    public LinkedList() {
        head = null;
    }


    /**
     * Method: add appends a new integer to the end of the list
     * @param key the integer to add to the list
     * @return true if the add succeeds, and false otherwise
     * Outputs an error if the key is < 0
     */
    public final boolean add(int key) {
        Node fresh = new Node (key, null);
        Node pointer = head;
        // output error if key is <0
        if (key < 0) {
            System.out.println("Error, key < 0.");
            return false;
        }
        //empty list
        else if (head == null) {
            head = fresh;
        }
        // iterate to the end of the list
        else {
            while (pointer.next != null) pointer = pointer.next;
            pointer.next = fresh;
        }
        return true;
    }


    /**
     * Method: search checks whether the key is in the list
     * @param key the integer to search for in the list
     * @return true if key is in the list and false otherwise
     */
    public boolean search(int key) {
        Node point = head;
        //ensure list is not empty, until end of list
        while (point != null) {
            if (point.data == key) {
                return true;
            }
            point = point.next; //point to next node
        }
        return false;
    }

    /**
     * Method: Converts the list into a printable string
     * @return a string
     */
    public String toString() {
        String output = "";
        Node point = head;
        // empty list
        if (head != null) {
            while (point != null) {
                output += point.data;
                if (point.next != null) {
                    output += " ";
                }
                point = point.next;
            }
        }
        return output;
    }

}
