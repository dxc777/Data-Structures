package LinearStructures;

import java.util.Arrays;

public class AStack<T> implements AbstractStack<T>
{
	private T[] stack;
	
	private int size;
	
	public AStack() 
	{
		this(10);
	}
	
	public AStack(int size) 
	{
		stack = (T[]) new Object[size];
		size = 0;
	}

	@Override
	public void push(T item)
	{
		grow();
		stack[size++] = item;
	}

	@Override
	public T pop()
	{
		return stack[--size];
	}

	@Override
	public T get(int index)
	{
		if(index < 0 || index >= size) 
		{
			throw new IndexOutOfBoundsException();
		}
		return stack[index];
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	private void grow() 
	{
		if(size < stack.length) return;
		stack = Arrays.copyOf(stack, size * 2);
	}

	@Override
	public T top()
	{
		if(isEmpty()) return null;
		return stack[size - 1];
	}
	
}
