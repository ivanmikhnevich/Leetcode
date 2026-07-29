class Solution {
    public int strStr(String haystack, String needle) {
        int needle_length = needle.length(), haystack_length = haystack.length();
        for(int i = 0; i <= haystack_length - needle_length; i++){
            if(needle.equals(haystack.substring(i, i + needle_length))) return i;
        }
        return -1; 
    }
}