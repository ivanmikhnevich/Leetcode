class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();

        if(digits.isEmpty())return out;

        backtrack(out, "", digits, 0);
        return out;
    }
    private void backtrack(List<String> out, String combination, String digits, int index){
        if(index == digits.length()){
            out.add(combination);
            return;
        }

        char digit = digits.charAt(index);
        String letters = suitableLetters(digit);

        for(char letter : letters.toCharArray()){
            backtrack(out, combination + letter, digits, index + 1);
        }
    }

    private String suitableLetters(Character digit){
        switch(digit){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
}