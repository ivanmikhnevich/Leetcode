class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        if(n == 0) return parentheses;
        generate(parentheses, "", 0, 0, n);
        return parentheses;
    }

    private void generate(List<String> result, String current_parenthesis, int open, int close, int max) {
        if(current_parenthesis.length() == 2 * max) {
            result.add(current_parenthesis);
            return;
        }

        if(open < max){
            // current_parenthesis = new StringBuilder(current_parenthesis).append("(").toString();
            generate(result, current_parenthesis + "(", open + 1, close, max);
        }

        if(close < open){
            // current_parenthesis = new StringBuilder(current_parenthesis).append(")").toString();
            generate(result, current_parenthesis + ")", open, close + 1, max);
        }
    }
}