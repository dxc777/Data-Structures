package UnitTests;

import java.util.Iterator;
import java.util.Random;

import LinearStructures.AbstractQueue;

public class QueueTests
{
	
	static final int QUEUE_TEST_SIZE = 50;
	
	public static void fillQueueRange(int bound, AbstractQueue<Integer> q) 
	{
		for (int i = 0; i < bound; i++)
		{
			q.enqueue(i);
		}
	}
	
	public static void fillQRandValue(AbstractQueue<Integer> q, int[] vals) 
	{
		Random r = new Random();
		for(int i = 0; i < vals.length; i++) 
		{
			int num = r.nextInt();
			q.enqueue(num);
			vals[i] = num;
		}
	}
	
	public static boolean qEnqueueDequeueTest(AbstractQueue<Integer> q) 
	{
		int[] vals = new int[100];
		fillQRandValue(q, vals);
		for(int i = 0; i < vals.length; i++) 
		{
			if(vals[i] != q.dequeue()) 
			{
				return false;
			}
		}
		return true;
	}
}
