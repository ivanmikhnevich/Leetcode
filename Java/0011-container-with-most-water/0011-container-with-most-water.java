class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int h = findHeight(height[right], height[left]);
            int base = findBase(right, left);
            int area = findArea(base, h);
            if(area > max_area) max_area = area;
            if(height[left] < height[right]){
                left++;                
            }
            else {
                right--;
            }
        }
        return max_area;
    }

    private int findArea(int a, int b){
        return a * b;
    }

    private int findHeight(int h1, int h2){
        return Math.min(h1, h2);
    }

    private int findBase(int right_index, int left_index){
        return right_index - left_index;
    }
}