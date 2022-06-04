package UnitTests;

import java.util.Random;

import LinearStructures.AbstractList;

public class ListUtil
{
	public static void fillListRange(AbstractList<Integer> list,int bound) 
	{
		for(int i = 0; i < bound; i++) 
		{
			list.append(i);
		}
	}
	
	public static void fillListRandValues(AbstractList<Integer> list, int[] arr) 
	{
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) 
		{
			int num = r.nextInt();
			list.append(num);
			arr[i] = num;
		}
	}

}
