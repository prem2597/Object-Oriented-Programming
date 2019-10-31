/**
 * List of my linkedlists.
 */
class MyLinkedList {

    /**
     * Constructs an empty list with size initialized to zero.
     */
    // int list = 0;
    private Node head;
    public MyLinkedList() {
        head = null;
    }
    /**
     * Appends the specified element to the end of this list.
     *
     * @param      data  The data
     */
    public void add(String data){
        if (head == null) {
            addFirst(data);
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new Node(data, null);
        }
    }
    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param      data  The data
     */
    public void addFirst(String data){
        head = new Node(data, head);
    }
    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        head = null;
    }
    /**
     * Returns true if this list contains the specified element.
     *
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(String data) {
        if(head == null) {
            return false;
        }
        Node t = head;
        while (t.next != null) {
            t = t.next;
            if(t.data.equals(data)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public String get(int index){
        if(head == null) {
            return null;
        }
        Node t = head;
        for (int i = 0; i< index; i++) {
            t = t.next;
        }
        if(t == null) {
            return null;
        }
        return t.data;
    }
    /**
     * Returns the first element in this list.
     *
     * @return     The first.
     */
    public String getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    /**
     * Returns the last element in this list.
     *
     * @return     The last.
     */
    public String getLast() {
        if (head == null) {
            return null;
        }
        Node t = head;
        while ( t.next != null) {
            t = t.next;
        }
        return t.data;
    }
    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String remove() {
        if(head == null) {
            return null;
        }
        String t = getFirst();
        head = head.next;
        return t;
    }
    /**
     * Removes and returns the last element from this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String removeLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            String value = head.data;
            head = null;
            return value;
        }
        Node t = head;
        while (t.next.next != null) {
            t = t.next;
        }
        String lastData = t.next.data;
        t.next = null;
        return lastData;
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        Node t = head;
        int count = 0;
        while (t != null) {
            count++;
            t = t.next;
        }
        return count;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node t = head;
        if (t == null) {
            return "LinkedList is empty";
        }
        while (t != null) {
            sb.append("[" + t.data + "]");
            t = t.next;
        }
        return sb.toString();}
}
