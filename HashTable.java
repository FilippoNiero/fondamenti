public class HashTable < V > implements Container {
	//Copiato da HashMap
	public static final int CAPACITY = 227;
	private Object[] arr;
	private int size;
	public HashTable() {
		empty();
	}
	private class Link {
		private int key;
		private V value;

		public Link(int key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	private class ListNode {
		private ListNode next;
		private Link value;

		public ListNode(ListNode next, Link value) {
			this.next = next;
			this.value = value;
		}
	}

	private int hash(int key) {
		int reductintey = key % CAPACITY;
		return (reductintey > 0) ? reductintey : -1 * reductintey;
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


	public V get(int key) {
		ListNode curr = (ListNode) arr[hash(key)];
		curr = curr.next;
		while (curr != null) {
			if (key == curr.value.key) {
				return curr.value.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public V put(int key, V value) {
		ListNode curr = (ListNode) arr[hash(key)];
		while (curr.next != null) {
			if (key == curr.next.value.key) {
				V old = curr.next.value.value;
				curr.next.value.value = value;
				return old;
			}
			curr = curr.next;
		}
		curr.next = new ListNode(null, new Link(key, value));
		size++;
		return null;
	}

	public V remove(int key) {
		ListNode curr = (ListNode) arr[hash(key)];

		while (curr.next != null) {
			if (key == curr.next.value.key) {
				size--;
				V old = curr.next.value.value;
				curr.next = curr.next.next;
				return old;
			}
			curr = curr.next;
		}
		return null;
	}

	public Object[] keys() {
		Object[] ret = new Object[size];
		int k = 0;
		for (int i = 0; i < CAPACITY; i++) {
			ListNode curr = (ListNode) arr[i];
			while (curr.next != null) {
				ret[k++] = curr.next.value.key;
				curr = curr.next;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		HashTable < String > hm = new HashTable < > ();
		hm.put(19, "A");
		hm.put(12, "B");
		hm.put(10, "C");
		hm.put(1, "D");
		hm.put(10, "E");
		System.out.println(hm.remove(10));
		System.out.println(hm.size());
		for (Object k: hm.keys()) {
			Integer key = (Integer) k;
			System.out.println(hm.get(key));
		}

	}


}