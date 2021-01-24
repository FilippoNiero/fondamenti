public class HashSet < E > implements Container {
	public static final int CAPACITY = 227;
	private Object[] arr;
	private int size;
	public HashSet() {
		empty();
	}
	class ListNode {
		private ListNode next;
		private E value;

		public ListNode(ListNode next, E value) {
			this.next = next;
			this.value = value;
		}
	}

	private int hash(E elem) {
		int h = elem.hashCode();
		int reductKey = h % CAPACITY;
		return (reductKey > 0) ? reductKey : -1 * reductKey;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void empty() {
		size = 0;
		arr = new Object[CAPACITY];
		for (int i = 0; i < CAPACITY; i++) {
			arr[i] = new ListNode(null, null);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	public void add(E e) {
		ListNode curr = (ListNode) arr[hash(e)];
		if (!contains(e)) {
			size++;
			curr.next = new ListNode(curr.next.next, e);
		}
	}

	private boolean contains(E e) {
		ListNode curr = (ListNode) arr[hash(e)];
		curr = curr.next;
		while (curr != null) {
			if (e.equals(curr.value)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public void remove(E e) {
		if (contains(e)) {
			ListNode curr = (ListNode) arr[hash(e)];
			while (curr.next != null) {
				if (e.equals(curr.next.value)) {
					curr.next = curr.next.next;
					return;
				}
				curr = curr.next;
			}
		}
	}

	public Object[] toArray() {
		Object[] ret = new Object[size];
		int k = 0;
		for (int i = 0; i < CAPACITY; i++) {
			ListNode curr = (ListNode) arr[i];
			while (curr.next != null) {
				ret[k++] = curr.next.value;
				curr = curr.next;
			}
		}
		return ret;
	}

	public HashSet < E > union(HashSet < E > other) {
		HashSet < E > ret = new HashSet < > ();
		Object[] thisArray = this.toArray();
		for (Object o: thisArray) {
			ret.add((E) o);
		}
		Object[] otherArray = other.toArray();
		for (Object o: otherArray) {
			ret.add((E) o);
		}
		return ret;
	}

	public HashSet < E > intersection(HashSet < E > other) {
		HashSet < E > ret = new HashSet < > ();
		Object[] thisArray = this.toArray();
		for (Object o: thisArray) {
			if (other.contains((E) o) && this.contains((E) o)) {
				ret.add((E) o);
			}
		}
		return ret;
	}

	public HashSet < E > subtraction(HashSet < E > other) {
		HashSet < E > ret = new HashSet < > ();
		Object[] thisArray = this.toArray();
		for (Object o: thisArray) {
			if (!other.contains((E) o)) {
				ret.add((E) o);
			}
		}
		return ret;
	}




}