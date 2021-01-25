public class QueueWithCircularArray<E> implements Queue<E> {

	private int size;
	private Object[] arr;
	private int front, back;
	public static final int INITIAL_CAPACITY = 4;

	public QueueWithCircularArray() {
		empty();
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		size = 0;
		arr = new Object[INITIAL_CAPACITY];
		front = 0;
		back = front;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E front() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		return (E)arr[front];
	}

	@Override
	public E dequeue() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		E temp = (E) arr[front];
		front++;
		size--;
		fixIndexes();
		return temp;
	}

	@Override
	public void enqueue(E e) {
		arr[back] = e;
		back++;
		size++;
		if(size == arr.length) {
			Object[] newArr = new Object[2* size];
			if(front < back)
				System.arraycopy(arr, front, newArr , 0, size);
			else {
				System.arraycopy(arr, front, newArr , 0, arr.length - front);
				System.arraycopy(arr, 0, newArr , arr.length - front, back+1);
				back = 0;
				back = size -1;
			}
			arr = newArr;
		}
		fixIndexes();
	}

	private void fixIndexes() {
		if(back >= arr.length) {
			back = 0;
		}
		if(front >= arr.length) {
			front = 0;
		}
	}

	public static void main(String[] args) {
		Queue<Integer> s = new QueueWithCircularArray<>();
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.enqueue(4);
		s.enqueue(5);
		s.enqueue(6);

		while(!s.isEmpty()) {
			System.out.println(s.dequeue());
		}
	}
}
