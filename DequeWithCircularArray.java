public class DequeWithCircularArray<E> implements Deque<E> {

	
	private int size;
	private Object[] arr;
	private int front, back;
	public static final int INITIAL_CAPACITY = 4;

	public DequeWithCircularArray() {
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
		back = 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public void addFirst(E elem) {
		front--;
		if(front == -1) {
			front = arr.length-1;
		}
		size++;
		arr[front] = elem;
		resizeIfFull();
	}

	@Override
	public void addLast(E elem) {
		back++;
		if(back  >= arr.length) {
			back = 0;
		}
		size++;
		arr[back] = elem;
		resizeIfFull();
	}

	@Override
	public E removeFirst() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		E temp = (E) arr[front];
		front++;
		if(front >= arr.length) {
			front = 0;
		}
		size--;
		return temp;
	}

	@Override
	public E removeLast() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		E temp = (E) arr[back];
		back--;
		if(back < 0) {
			back = arr.length-1;
		}
		size--;
		return temp;
	}

	@Override
	public E getFirst() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		return (E)arr[front];
	}

	@Override
	public E getlast() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		return (E)arr[back];
	}

	private void resizeIfFull() {
		if(size == arr.length) {
			Object[] newArr = new Object[2* size];
			System.out.println(front + "  " + back );
			if(back < front) //Succede solo se front = 0 e back = size-1
				System.arraycopy(arr, front, newArr , 0, size);
			else {
				System.arraycopy(arr, front, newArr , 0, arr.length - front);
				System.arraycopy(arr, 0, newArr , arr.length - front, back+1);
				front = 0;
				back = size -1;
			}
			arr = newArr;
		}
	}
	
	public static void main(String[] args) {
		Deque<Integer> dq = new DequeWithCircularArray<>();
		dq.addFirst(5);
		dq.addFirst(10);
		dq.addFirst(5);
		System.out.println(dq.getlast());
		dq.removeFirst();
		dq.addLast(3);
		dq.addLast(5);
		System.out.println(dq.getFirst());
	}
}
