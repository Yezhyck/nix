package hw7;

import hw7.leetcode.LeetCodeSolutions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing the solution of LeetCode problems")
class LeetCodeSolutionsTest {

    @Test
    @DisplayName("The returned integer value should match the length of the last word in the given string")
    void lengthOfLastWord_Should_ReturnLastWordLength_When_GivenStringConsistsWordsAndSpaces() {
        String string1 = "Hello World";
        String string2 = "   fly me   to   the moon  ";
        String string3 = "luffy is still joyboy";

        int lastWordLength1 = 5;
        int lastWordLength2 = 4;
        int lastWordLength3 = 6;

        assertEquals(lastWordLength1, LeetCodeSolutions.lengthOfLastWord(string1));
        assertEquals(lastWordLength2, LeetCodeSolutions.lengthOfLastWord(string2));
        assertEquals(lastWordLength3, LeetCodeSolutions.lengthOfLastWord(string3));
    }

    @Test
    @DisplayName("The returned boolean value of true should indicate that the given string is a palindrome")
    void isPalindrome_Should_ReturnTrue_When_GivenStringIsPalindrome() {
        String string1 = "A man, a plan, a canal: Panama";
        String string2 = " ";

        assertTrue(LeetCodeSolutions.isPalindrome(string1));
        assertTrue(LeetCodeSolutions.isPalindrome(string2));
    }

    @Test
    @DisplayName("The returned boolean value of false should indicate that the given string is not a palindrome")
    void isPalindrome_Should_ReturnFalse_When_GivenStringIsNotPalindrome() {
        String string = "race a car";

        assertFalse(LeetCodeSolutions.isPalindrome(string));
    }

    @Test
    @DisplayName("The returned string value should match the longest common prefix string among the given array of strings")
    void longestCommonPrefix_Should_ReturnLongestCommonPrefix_When_GivenArrayStringsConsistsOnlyLowercaseLetters() {
        String[] array1 = new String[]{"flower", "flow", "flight"};
        String[] array2 = new String[]{"dog", "racecar", "car"};

        String longestCommonPrefix1 = "fl";
        String longestCommonPrefix2 = "";

        assertEquals(longestCommonPrefix1, LeetCodeSolutions.longestCommonPrefix(array1));
        assertEquals(longestCommonPrefix2, LeetCodeSolutions.longestCommonPrefix(array2));
    }
}