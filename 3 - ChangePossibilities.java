/* Warkah Scott */

/*
Question 3 -- changePossibilities(amount,amount): 

Your quirky boss collects rare, old coins. 
They found out you're a programmer and asked you to solve something they've been wondering for a long time. 
Write a function that, given an amount of money and an array of coin denominations, computes the number of ways to make the amount of money with coins of the available denominations. 
Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 4¢ with those denominations: 

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢ 
 */

import java.util.*;

class Question3
{
	public static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	
	public static int changePossibilities(int amount, int[] denominations)
	{
		ArrayList<Integer> options = new ArrayList<Integer>();
		for(int i : denominations)
			if(i <= amount && !options.contains(i))
				options.add(i);
		options.sort(null);
		options.add(0);

		int current = options.get(0).intValue();
		int[] maxhold = new int[amount/current];
		for(int i = 0; i < maxhold.length; i++)
			maxhold[i] = 0;
		permute(maxhold.length - 1, maxhold, amount, options);
		for(ArrayList<Integer> a : permutations)
			a.sort(null);
		int count = permutations.size();
		int index = 0;
		while(index < count)
		{
			ArrayList<Integer> arr = permutations.get(index);
			while(permutations.lastIndexOf(arr) != index)
			{
				permutations.remove(permutations.lastIndexOf(arr));
				count--;
			}
			index++;
		}
		/*	//outputs different combinations
		for(ArrayList<Integer> a : permutations)
		{
			for(Integer i : a)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
		*/
		int answer = permutations.size();
		permutations.clear();
		return answer;
	}
	
	private static void permute(int depth, int[] max, int amount, ArrayList<Integer> denominations)
	{
		if(depth == 0)
		{
			for(Integer d : denominations)
		    {
		    	max[max.length - 1] = d.intValue();
		    	if(total(max) == amount)
		    	{
		    		ArrayList<Integer> tmp = new ArrayList<Integer>();
		    		for(int i : max)
		    			tmp.add(i);
		    		permutations.add(tmp);
		    	}
		    }
		}
		else
		{
			for(Integer d : denominations)
		    {
		    	max[max.length - 1 - depth] = d.intValue();
		    	permute(depth - 1, max, amount, denominations);
		    }
		}
	}
	
	private static int total(int[] arr)
	{
		int total = 0;
		for(int i : arr)
			total += i;
		return total;
	}
}