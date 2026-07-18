class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max_length = 0;
        int left = 0;
        Set<Character> chars = new HashSet<>();
        for(int right = 0; right < n; right++){
            while(chars.contains(s.charAt(right))){
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(s.charAt(right));
            max_length = Math.max(max_length, right - left + 1);
        }
        return max_length;
    }
}