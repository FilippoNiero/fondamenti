public class DoubleLinkedList<E> implements Container{
	private Node head, tail;
	private int size;
	public DoubleLinkedList() {
		empty();
	}
	private class Node {
		private Node next, prev;
		private E value;

		public Node(Node next, Node prev, E value) {
			this.next = next;
			this.prev = prev;
			this.value = value;
		}

	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		head = new Node(null, null, null);
		tail = new Node(null, head, null);
		head.next = tail;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E elem) {
		Node temp = head.next;
		head.next = new Node(temp, head, elem);
		temp.prev = head.next;
		size++;
	}

	public void addLast(E elem) {
		Node temp = tail.prev;
		tail.prev = new Node(tail, temp, elem);
		temp.next = tail.prev;
		size++;
	}

	public E removeFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		E temp = head.next.value;
		head.next = head.next.next;
		head.next.prev = head;
		size--;
		return temp;
	}

	public E removeLast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		E temp = tail.prev.value;
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		size--;
		return temp;
	}

	public E getFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return head.next.value;
	}

	public E getlast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return tail.prev.value;
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> l = new DoubleLinkedList<>();
		l.addFirst(1);
		System.out.println(l.removeFirst());
		l.addFirst(1);
		l.addFirst(2);
		l.addFirst(3);
		System.out.println(l.removeFirst());
		l.addLast(4);
		l.addLast(5);
		l.addLast(6);
		System.out.println(l.removeLast());
		while(!l.isEmpty()) {
			System.out.println(l.removeLast());
		}
	}

}
