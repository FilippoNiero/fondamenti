import java.util.Iterator;

public class LinkedList<E> implements Container {
	private Node head, tail;
	private int size;
	public LinkedList() {
		empty();
	}
	private class Node {
		private Node next;
		private E value;

		public Node(Node next, E value) {
			this.next = next;
			this.value = value;
		}
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		head = new Node(null, null);
		tail = head;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E elem) {
		head.next = new Node(head.next, elem);
		if(size == 0) {
			tail = head.next;
		}
		size++;
	}

	public void addLast(E elem) {
		tail.next = new Node(null, elem);
		tail = tail.next;
		size++;
	}

	public E removeFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		E temp = head.next.value;
		head.next = head.next.next;
		size--;
		return temp;
	}

	public E removeLast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		E temp = tail.value;
		//Imposto tail al penultimo nodo
		Node it = head;
		while(it.next != tail) {
			it = it.next;
		}
		tail = it;
		tail.next = null;
		size--;
		return temp;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
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

	public E getFirst() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return head.next.value;
	}

	public E getLast() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return tail.value;
	}
}
