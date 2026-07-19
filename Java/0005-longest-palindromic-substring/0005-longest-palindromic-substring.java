class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 1) return "";        
        String longest_palindrome = "";        
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest_palindrome.length()) {
                longest_palindrome = oddPalindrome;
            }
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest_palindrome.length()) {
                longest_palindrome = evenPalindrome;
            }
        }        
        return longest_palindrome;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}