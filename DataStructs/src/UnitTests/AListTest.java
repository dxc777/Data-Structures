package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import LinearStructures.AList;

class AListTest
{
	
	@Test
	void emptyGetTest() 
	{
		AList<Integer> list = new AList<>();
		assertThrows(IndexOutOfBoundsException.class, new Executable() {

			@Override
			public void execute() throws Throwable
			{
				list.get(0);
			}});
	}
	
	
	@Test
	void negativeIndexGetTest() 
	{
		AList<Integer> list = new AList<>();
		ListUtil.fillListRange(list, 25);
		assertThrows(IndexOutOfBoundsException.class, new Executable()
		{
			
			@Override
			public void execute() throws Throwable
			{
				list.get(-1);
			}
		});
	}
	
	@Test
	void outOfBoundsGetTest() 
	{
		AList<Integer> list = new AList<>();
		ListUtil.fillListRange(list, 25);
		assertThrows(IndexOutOfBoundsException.class, new Executable()
		{
			
			@Override
			public void execute() throws Throwable
			{
				list.get(25);
			}
		});
	}
	
	@Test
	void getReturnsCorrectValueTest() 
	{
		AList<Integer> list = new AList<>();
		int[] arr = new int[100];
		ListUtil.fillListRandValues(list, arr);
		for(int i = 0; i < list.size(); i++) 
		{
			if(list.get(i) != arr[i]) 
			{
				fail("Get return incorrect value");
			}
		}
	}
	
	@Test
	void toStringIsCorrect() 
	{
		AList<Integer> list = new AList<>();
		ListUtil.fillListRange(list, 10);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",list.toString());
	}
	
	@Test
	void insertTest() 
	{
		AList<Integer> list = new AList<>();
		for(int i = 0; i < 10; i++) 
		{
			list.insert(0, i);
		}
		
		for(int i = 9; i >= 0; i--) 
		{
			if(list.get(9 - i) != i) 
			{
				fail("Insertion failed");
			}
		}
	}
	
	@Test
	void insertTest2()
	{
		AList<Integer> list = new AList<>();
		for(int i = 0; i < 3; i++) 
		{
			list.append(i);
		}
		for(int i = 7; i < 10; i++) 
		{
			list.append(i);
		}
		for(int i = 6; i > 2; i--) 
		{
			list.insert(3,i);
		}
		for(int i = 0; i < list.size(); i++) 
		{
			if(list.get(i) != i) 
			{
				fail("Insertion failed");
			}
		}
		
	}
	
	@Test
	void emptyList() 
	{
		AList<Integer> list = new AList<>();
		ListUtil.fillListRange(list, 100);
		while(list.isEmpty() == false) 
		{
			list.remove(list.size() - 1);
		}
		assertEquals(true, list.isEmpty());
	}
	
	
	
	 

}
