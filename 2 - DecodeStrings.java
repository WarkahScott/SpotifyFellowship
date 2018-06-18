/* Warkah Scott */

/*
Question 2 -- decodeString(s): 

Given an encoded string, return its corresponding decoded string. 
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. 
Note: k is guaranteed to be a positive integer. 

For s = "4[ab]", the output should be decodeString(s) = "abababab" 
For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
 */
 
class Question2
{
	public static String decodeString(String s)
	{
		if(!s.contains("["))
			return s;
		
		char[] workingString = s.toCharArray();
		int count = 0;
		int letterCount = 0;
		String tmp = "";
		while(Character.isAlphabetic(workingString[letterCount]))
		{
			tmp += workingString[letterCount];
			letterCount++;
		}
		count = letterCount;
		while(Character.isDigit(workingString[count]))
			count += 1;
		
		int repeat = Integer.parseInt(s.substring(letterCount, count));
		String sub = decodeString(s.substring(count + 1, s.length() - 1));
		
		for(int i = 0; i < repeat; i++)
		{
			tmp += sub;
		}
		return tmp;
	}
}