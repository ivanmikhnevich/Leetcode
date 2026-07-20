class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        long value = 0;
        int index = 0;
        
        s = s.trim();

        if (s.isEmpty()) return 0;

        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            value = value * 10 + (s.charAt(index) - '0');

            if (value * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (value * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        return (int) (sign * value);
    }
}