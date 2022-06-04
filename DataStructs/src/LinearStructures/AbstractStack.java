package LinearStructures;

public interface AbstractStack<T>
{
	public void push(T item);
	
	public T pop();
	
	public T get(int index);
	
	public int size();
	
	public boolean isEmpty();
	
	
}
