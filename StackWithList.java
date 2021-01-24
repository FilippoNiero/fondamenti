public class StackWithList<E> implements Container{
	private LinkedList<E> ll;

	public StackWithList() {
		
		empty();
	}

	@Override
	public int size() {
		return ll.size();
	}

	@Override
	public void empty() {
		ll = new LinkedList<>();
	}

	@Override
	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public E top() {
		return ll.getFirst();
	}

	public E pop() {
		return ll.removeFirst();
	}

	public void push(E e) {
		ll.addFirst(e);
	}

	public static void main(String[] args) {
		StackWithList<Integer> s = new StackWithList<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);

		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

}
