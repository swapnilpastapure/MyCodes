import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;   // Start of window
        int maxLength = 0;

        // Expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character already exists, shrink window from left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the set
            set.add(currentChar);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution =
                new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(solution.lengthOfLongestSubstring(""));         // 0
    }
}