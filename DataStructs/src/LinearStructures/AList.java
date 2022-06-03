package LinearStructures;

import java.util.Arrays;

public class AList<T> implements List<T>
{	
	private T[] arr;
	
	private int size;

	public AList() 
	{
		this(10);
	}
	
	
	@SuppressWarnings("unchecked")
	public AList(int size) 
	{
		arr = (T[]) new Object[size]; 
		size = 0;
	}
	
	public AList(AList<T> obj) 
	{
		this.arr = Arrays.copyOf(obj.arr, obj.size);
		this.size = obj.size;
	}
	
	
	/**
	 * Return element at index passed in
	 * Valid indexes are from 0 -> size - 1 if it is empty there is no valid index
	 */
	@Override
	public T get(int index)
	{
		if(index < 0 || index >= size) 
			throw new IndexOutOfBoundsException();
		return arr[index];
	}

	@Override
	public void append(T item)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int index, T item)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
