public class RegularExpressionMatcher {
    // Cache to store the results of subproblems
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        // Initialize the memoization table with extra space for the empty string/pattern states
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        // Check cache to see if we've already solved this state
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Base Case: If we reached the end of the pattern
        if (j == p.length()) {
            return i == s.length();
        }

        // Check if the current characters match
        boolean match = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean res;
        // Case 1: The next character in the pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Ignore the '*' wildcard (skip 2 characters in p)
            // Choice 2: Use the '*' wildcard (if current char matches, move to next char in s)
            res = dfs(i, j + 2, s, p) || (match && dfs(i + 1, j, s, p));
        } else {
            // Case 2: No '*' wildcard next, just move both pointers forward if it's a match
            res = match && dfs(i + 1, j + 1, s, p);
        }

        // Save the result to the cache before returning
        memo[i][j] = res;
        return res;
    }

    // Main method included inside the same class for easy testing
    public static void main(String[] args) {
        RegularExpressionMatcher matcher = new RegularExpressionMatcher();

        // Test cases
        System.out.println("Test 1 (s = \"aa\", p = \"a\"): " + matcher.isMatch("aa", "a"));     // Output: false
        System.out.println("Test 2 (s = \"aa\", p = \"a*\"): " + matcher.isMatch("aa", "a*"));   // Output: true
        System.out.println("Test 3 (s = \"ab\", p = \".*\"): " + matcher.isMatch("ab", ".*"));   // Output: true
    }
}