class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        String reversed_str = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
        try {
        return Integer.parseInt(reversed_str) * sign;
    } catch (NumberFormatException e) {
        return 0; // Возвращаем 0, если число вышло за пределы 32-бит
    }        
    }
}