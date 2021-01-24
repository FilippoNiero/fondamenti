public class QueueWithList<E> implements Container{
	private LinkedList<E> ll;

	public QueueWithList() {
		
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

	public E front() {
		return ll.getFirst();
	}

	public E dequeue() {
		return ll.removeFirst();
	}

	public void enqueue(E e) {
		ll.addLast(e);
	}

	public static void main(String[] args) {
		QueueWithList<Integer> q = new QueueWithList<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);

		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}

}
