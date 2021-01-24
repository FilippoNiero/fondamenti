
public interface List<E> extends Container {
	public E get(int rank);
	public int rankOf(E element);
	public void add(E element);
	public void remove(int rank);
	public void remove(E element);
}