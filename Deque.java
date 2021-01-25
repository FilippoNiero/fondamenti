public interface Deque < E > extends Container {

	void addFirst(E elem);

	void addLast(E elem);

	E removeFirst();

	E removeLast();

	E getFirst();

	E getlast();
}