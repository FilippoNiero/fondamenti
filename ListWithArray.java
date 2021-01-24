import java.util.Iterator;

public class ListWithArray<E> implements List<E>, Iterable<E> {

	public static final int INITIAL_CAPACITY = 4;
	private int size;
	private Object[] arr;

	public ListWithArray() {
		empty();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		arr = new Object[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int rank) {
		if (rank < 0 || rank >= size) {
			throw new IllegalArgumentException("List index out of bounds");
		}
		return (E)arr[rank];
	}

	@Override
	public int rankOf(E element) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void add(E element) {
		if(arr.length == size) {
			//Resize
			Object[] newArr = new Object[2* arr.length];
			System.arraycopy(arr, 0, newArr, 0, size);
			arr = newArr;
		}
		arr[size++] = element;
		size++;
	}

	@Override
	public void remove(int rank) {
		if (rank < 0 || rank >= size) {
			throw new IllegalArgumentException("List index out of bounds");
		}
		for(int i = rank; i < size-1; i++) {
			arr[i] = arr[i+1];
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

	@Override
	public Iterator<E> iterator() {
		return new ListIterator<>(this);
	}

	private class ListIterator<E> implements Iterator<E> {
		private ListWithArray<E> list;
		private int curr;
		public ListIterator(ListWithArray<E> list) {
			this.list = list;
			this.curr = 0;
		}
		@Override
		public boolean hasNext() {
			return curr < list.size;
		}

		@Override
		public E next() {
			E temp =  list.get(curr);
			curr++;
			return temp;
		}

	}

}