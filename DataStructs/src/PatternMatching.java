import java.util.HashMap;
import java.util.ArrayList;

public class PatternMatching 
{
	//O(mn time complexity)
	public static ArrayList<Integer> bruteForceMatch(String text, String pattern)
	{
		ArrayList<Integer> matches = new ArrayList<>();
		int i = 0;
		while(i <= text.length() - pattern.length()) 
		{
			int j = 0;
			while(j < pattern.length() && text.charAt(i + j) == pattern.charAt(j)) 
			{
				j++;
			}
			if(j == pattern.length()) 
			{
				matches.add(i);
			}
			
			i++;
		}
		return matches;
	}
	
	//at worst case time complexity degenerates to O(mn) m == length of pattern
	//n == length of text`		
	public static ArrayList<Integer> booyerMooreMatch(String text, String pattern)
	{
		ArrayList<Integer> matches = new ArrayList<>();
		HashMap<Character,Integer> lastIndex = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) 
		{
			lastIndex.put(pattern.charAt(i), i);
		}
		int i = 0;
		while(i <= text.length() - pattern.length())
		{
			int j = pattern.length() - 1;
			while(j >= 0 && text.charAt(i + j) == pattern.charAt(j)) 
			{
				j--;
			}
			if(j == -1) 
			{
				matches.add(i);
				i = i + pattern.length();
			}
			else 
			{
				int shift = lastIndex.getOrDefault(text.charAt(i + j), -1);
				if(shift < j) 
				{
					i = i + j - shift;
				}
				else 
				{
					i = i + 1;
				}
			}
		}
		return matches;
	}
	
	public static ArrayList<Integer> kmpMatch(String text,String pattern)
	{
		ArrayList<Integer> matches = new ArrayList<>();
		int[] failureTable = buildFailureTable(pattern);
		int j = 0;
		int k = 0;
		while(k < text.length()) 
		{
			if(pattern.charAt(j) == text.charAt(k)) 
			{
				if(j == pattern.length() - 1) 
				{
					matches.add(k - j);
					j = failureTable[j - 1];
				}
				else 
				{
					j++;
					k++;
				}
			}
			else if(pattern.charAt(j) != text.charAt(k) && j == 0) 
			{
				k++;
			}
			else 
			{
				j = failureTable[j - 1];
			}
		}
		return matches;
	}
	
	public static int[] buildFailureTable(String pattern) 
	{
		int[] failureTable = new int[pattern.length()];
		int i = 0;
		int j = 1;
		while(j < pattern.length()) 
		{
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				failureTable[j] = i + 1;
				i++;
				j++;
			}
			else if(pattern.charAt(i) != pattern.charAt(j) && i == 0) 
			{
				failureTable[j] = 0;
				j++;
			}
			else 
			{
				i = failureTable[i - 1];
			}
		}
		return failureTable;
	}

}
