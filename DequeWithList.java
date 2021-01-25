public class DequeWithList<E> implements Deque<E>{
	//Praticamente copiata da DoubleLinkedList
	private DoubleLinkedList<E> list;

	public DequeWithList() {
		empty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void empty() {
		list = new DoubleLinkedList<>();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void addFirst(E elem) {
		list.addFirst(elem);
	}

	public void addLast(E elem) {
		list.addLast(elem);
	}

	public E removeFirst() {
		return list.removeFirst();
	}

	public E removeLast() {
		return list.removeLast();
	}

	public E getFirst() {
		return list.getFirst();
	}

	public E getlast() {
		return list.getlast();

	}

	public static void main(String[] args) {
		DequeWithList<Integer> l = new DequeWithList<>();
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
