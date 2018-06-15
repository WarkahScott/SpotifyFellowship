/* Warkah Scott */

/*
Question 1 -- sortByStrings(s,t): 

Sort the letters in the string s by the order they occur in the string t. 
You can assume t will not have repetitive characters. 

For s = "weather" and t = "therapyw", the output should be sortByString(s, t) = "theeraw". 
For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
*/

class Question1
{
	public static String sortByStrings(String s, String t)
	{
		int count = 0; //place of next to be swapped letter
		char[] workingString = s.toCharArray();
		for(int i = 0; i < t.length(); i++)
		{
			for(int j = count; j < s.length(); j++)
			{
				if(workingString[j] == t.charAt(i))
				{
					char temp = workingString[count];
					workingString[count] = workingString[j];
					workingString[j] = temp;
					count++;
				}
			}
		}
		return new String(workingString);
	}
}