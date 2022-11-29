package hw7.leetcode;

public class LeetCodeSolutions {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     *
     * A word is a maximal substring consisting of non-space characters only.
     *
     * @param s - string consisting of words and spaces
     * @return - length of the last word in the string
     *
     * @solution - https://leetcode.com/submissions/detail/849713543/
     */

    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return -1;
        }

        String[] strings = s.split("\\s+");

        return strings[strings.length - 1].length();
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
     * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
     * letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * @param s - string consisting only of printable ASCII characters
     * @return - boolean indicating whether the string is a palindrome or not
     *
     * @solution - https://leetcode.com/submissions/detail/849706252/
     */

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        String alphanumeric = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();

        for (int i = 0, j = alphanumeric.length() - 1; i < j; i++, j--) {
            if (alphanumeric.charAt(i) != alphanumeric.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * @param str - string consisting only of lowercase English letters
     * @return - string is the longest common prefix string among the array of strings
     *
     * @solution - https://leetcode.com/submissions/detail/849705545/
     */

    public static String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }

        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            prefix = findCommonPrefix(prefix, str[i]);

            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    private static String findCommonPrefix(String str1, String str2) {
        int lessWordLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < lessWordLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }

        return str1.substring(0, lessWordLength);
    }
}
