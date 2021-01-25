public interface Map<K, V> extends Container {
	V get(K key);
	V put(K key, V value);
	V remove(K key);

	Object[] keys();
}
