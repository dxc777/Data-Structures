package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;

import LinearStructures.LList;

class LListTest
{

	
	@Test
	void emptyGetTest() 
	{
		LList<Integer> list = new LList<>();
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
		LList<Integer> list = new LList<>();
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
		LList<Integer> list = new LList<>();
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
		LList<Integer> list = new LList<>();
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
	@Timeout(value = 10000)
	void toStringIsCorrect() 
	{
		LList<Integer> list = new LList<>();
		ListUtil.fillListRange(list, 10);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",list.toString());
	}
	
	@Test
	void insertTest() 
	{
		LList<Integer> list = new LList<>();
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
	@Timeout(value = 10000)
	void insertTest2()
	{
		LList<Integer> list = new LList<>();
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
	@Timeout(value = 10000)
	void emptyList() 
	{
		LList<Integer> list = new LList<>();
		ListUtil.fillListRange(list, 10);
		while(list.isEmpty() == false) 
		{
			list.remove(list.size() - 1);
		}
		assertEquals(true, list.isEmpty());
	}
	
	
	

}
