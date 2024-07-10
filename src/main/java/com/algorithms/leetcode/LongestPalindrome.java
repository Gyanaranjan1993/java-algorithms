package com.algorithms.leetcode;

/*Longest Palindrome*/

import java.util.HashSet;
import java.util.Set;

/*
 * abccba
 * 
 * 
 * 
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result = longestPalindrome("abcdcb");
		System.out.println("length of palindrome is : " + result);

	}

	/*
		Using hash set

		Traverse the String.
		  Find out if the char is present in the set, if yes, then that means the char is present two times and
		  can be included in the palindrome string. So we increase the length by 2 and remove the entry from the Set.

		  If not, just add it to the set.

		  At the end, verify if any single occurrences of any char present in the set. If yes, increase the length by 1
		  as palindrome string can have a single char in the middle.

	 */
	static Integer longestPalindrome(String s) {
		if (s.length() == 1)
			return 1;
		Set<Character> charSet = new HashSet<>();

		int length = 0;

		for(char ch : s.toCharArray()) {
			if (charSet.contains(ch)){
				length += 2;
			} else {
				charSet.add(ch);
			}
		}

		//Check if any single occurance chars are present. i.e. if the set is still no empty

		if (!charSet.isEmpty()) {
			length += 1;
		}


		return length;
	}

}
