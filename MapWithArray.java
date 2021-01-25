public class MapWithArray<K,V> implements Map<K,V> {

	private int size;
	private Object[] arr;
	public static final int INITIAL_CAPACITY = 4;

	public MapWithArray() {
		empty();
	}

	private class Link {
		private K key;
		private V value;

		public Link(K key, V value) {
			this.key = key;
			this.value = value;
		}
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
	public V get(K key) {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		Link l = find(key);
		if(l != null)
			return l.value;
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		Link temp = find(key);
		V ret = null;
		if(temp != null) {
			ret = temp.value;
			temp.value = value;
		}else {
			arr[size++] = new Link(key, value);
		}
		if(size >= arr.length) {
			Object[] newArr = new Object[2* size];
			System.arraycopy(arr, 0, newArr, 0, size);
			arr = newArr;
		}
		return ret;
	}

	private Link find(K key) {
		for(int i = 0; i < size; i++) {
			Link l = (Link) arr[i];
			if(key.equals(l.key)) {
				return l;
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		V ret = null;
		boolean found = false;
		for(int i = 0; i < size; i++) {
			Link l = (Link) arr[i];
			if (found) {
				arr[i-1] = arr[i];
			}
			if(!found && key.equals(l.key)) {
				ret = l.value;
				found = true;
			}
			
		}
		if(ret !=null) {
			size--;
		}
		return ret;
	}

	@Override
	public Object[] keys() {
		Object[] keys = new Object[size];
		for(int i = 0; i < size; i++) {
			keys[i] =( (Link)arr[i]).key;
		}
		return keys;
	}
	
	public static void main(String[] args) {
		MapWithArray < Integer, String > hm = new MapWithArray < > ();
		hm.put(19, "A");
		
		hm.put(12, "B");
		
		hm.put(10, "C");
		
		hm.put(1, "D");
		
		hm.put(10, "E");
		System.out.println(hm.size());
		for (Object k: hm.keys()) {
			Integer key = (Integer) k;
			System.out.print(hm.get(key));
		}
		System.out.println();
		System.out.println(hm.remove(10));
		
		System.out.println(hm.size());
		for (Object k: hm.keys()) {
			Integer key = (Integer) k;
			System.out.print(hm.get(key));
		}

	}
}
