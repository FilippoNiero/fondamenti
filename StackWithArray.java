public class StackWithArray<E> implements Stack<E>{

	private int size;
	private Object arr[];
	public static final int INITIAL_CAPACITY = 4;

	public StackWithArray() {
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
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E pop() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		E temp = (E) arr[size-1];
		size--;
		return temp;
	}

	@Override
	public E top() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		return (E)arr[size-1];
	}

	@Override
	public void push(E element) {
		if(size == arr.length) {
			Object[] newArr = new Object[2* size];
			System.arraycopy(arr, 0, newArr , 0, size);
			arr = newArr;
		}

		arr[size++] = element;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new StackWithArray<>();
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
