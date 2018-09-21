public class MoveToFrontLinkedList extends LinkedList {
    /**
     * Method: search checks whether the key is in the list
     * @param key the integer to search for in the list
     * @return true if key is in the list and false otherwise
     */

//    public MoveToFrontLinkedList() {
//
//    }

    @Override
    public boolean search(int key) {
        // declare pointer to start at head
        Node cur = head;
        Node prev = null;
        Node temp = null;
        //ensure list is not empty, iterate until end of list
        while (cur != null) {

            // case 1: if key first element and contains key, return true
            if (cur == head && cur.data == key)  {
                return true;
            } else {

                // case 2: if key between first and last element
                // move to next node
                prev = cur;
                cur = cur.next;

                // check if contains key and not last element
                if (cur != null) {

                    if(cur.next != null && cur.data == key) {

                        temp = new Node(head.data, head.next);
                        head = cur;

                        // check previous ***
                        temp.next = head.next;
                        head.next = temp;

                        return true;
                    }

                    // case 3: if key last element
                    else if (cur.data == key && cur.next == null) {

                        temp = head;
                        head = cur;
                        head.next = temp;
                        prev.next = null;

                        return true;
                    }
                }
            }
        }
        // if key not found
        return false;
    }
}
//    public boolean search(int key) {
//        Node point = head;
//        //ensure list is not empty, until end of list
//        while (point != null) {
//            if (point.data == key) {
//                return true;
//            }
//            point = point.next; //point to next node
//        }
//        return false;
//    }