import java.util.Iterator;

public class ListWithLinkedList<E> implements List<E>, Iterable<E> {
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

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}



	@Override
	public E get(int rank) {
		if(rank < 0 || rank >= size) {
			throw new IllegalArgumentException("List index out of bounds");
		}
		Node node = head;
		for(int i = 0; i < rank-1; i++) {
			node = node.next;
		}
		return node.next.value;
	}

	@Override
	public int rankOf(E element) {
		Node node = head.next;
		int curr = 0;
		while(node != null) {
			if(node.value.equals(element)) {
				return curr;
			}
			curr++;
			node = node.next;
		}
		return -1;
	}

	@Override
	public void add(E element) {
		tail.next = new Node(null, element);
		tail = tail.next;
		size++;
	}

	@Override
	public void remove(int rank) {
		if(rank < 0 || rank >= size) {
			throw new IllegalArgumentException("List index out of bounds");
		}
		Node node = head;
		for(int i = 0; i < rank-1; i++) {
			node = node.next;
		}
		node.next = node.next.next;
		if(node.next == null) {
			tail = node;
		}
		size--;
	}

	@Override
	public void remove(E element) {
		int index = rankOf(element);
		if(index != -1) {
			remove(index);
		}
	}

	public static void main(String[] args) {
		ListWithLinkedList<String> l = new ListWithLinkedList<>();
		l.add("a");
		l.add("ab");
		l.add("ac");
		l.add("ad");
		l.remove(0);
		l.remove(0);
		l.remove(0);
		l.remove(0);
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		for(String s: l) {
			System.out.println(l.rankOf(s));
		}
		l.remove(l.size() -1);
		for(String s: l) {
			System.out.println(s);
		}
	}

	
}
