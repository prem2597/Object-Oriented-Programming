class LinkedList {
	/**
	 * class for Node
	 */
	class Node {
		//Todo
		int data;
		Node next;
		Node (int d) {
			data = d;
			next = null;
		}
	}
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.head = new Node(1);
		llist.second = new Node(2);
		llist.third = new Node(3);
		llist.head.next = second;
		second.next = third;
	}
}
