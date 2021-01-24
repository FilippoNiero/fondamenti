import java.util.Iterator;

public class ListWithLinkedList<E> implements Container, Iterable<E> {
	private Node head, tail;
	private int size;

	public ListWithLinkedList() {
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

	public class ListIterator implements Iterator<E>{
		private Node current;

		public ListIterator() {
			current = head.next;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E temp = current.value;
			current = current.next;
			return temp;
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


	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	public static void main(String[] args) {
		ListWithLinkedList<Integer> l = new ListWithLinkedList<>();
		l.addFirst(1);//[1]
		l.addFirst(1);//[1] - [1]
		l.addFirst(2);//[2] - [1] - [1]
		l.addFirst(3);//[3] - [2] - [1] - [1]
		l.addLast(4);//[3] - [2] - [1] - [1] - [4]
		l.addLast(5);//[3] - [2] - [1] - [1] - [4] - [5]
		l.addLast(6);//[3] - [2] - [1] - [1] - [4] - [5] - [6]
		for(Integer i: l) {
			System.out.println(i);
		}
	}


	
}
