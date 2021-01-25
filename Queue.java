public interface Queue<E> extends Container {
	E front();

	E dequeue();

	void enqueue(E e);
}
