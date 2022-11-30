package hw7;

import hw7.leetcode.LeetCodeSolutions;

import java.util.Arrays;

public class LeetCodeSolutionsRunner {

    public static void main(String[] args) {
        String[] lengthOfLastWordArray = new String[]{"Hello World", "   fly me   to   the moon  ", "luffy is still joyboy"};
        String[] validPalindromeArray = new String[]{"A man, a plan, a canal: Panama", "race a car", " "};
        String[][] longestCommonPrefixArray = new String[][]{{"flower", "flow", "flight"}, {"dog", "racecar", "car"}};

        for (String s : lengthOfLastWordArray) {
            System.out.printf("Length of the last word of the string \"%s\" is: %s.%n", s, LeetCodeSolutions.lengthOfLastWord(s));
        }

        for (String s : validPalindromeArray) {
            System.out.printf("The string \"%s\" is a palindrome: %s.%n", s, LeetCodeSolutions.isPalindrome(s));
        }

        for (String[] str : longestCommonPrefixArray) {
            System.out.printf("Longest common prefix string among array of strings %s is: \"%s\".%n", Arrays.toString(str), LeetCodeSolutions.longestCommonPrefix(str));
        }
    }
}
