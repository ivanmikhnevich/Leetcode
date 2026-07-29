class Solution {
    public int removeDuplicates(int[] nums) {
        int count_of_unique = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[count_of_unique - 1]){
                count_of_unique++;
                nums[count_of_unique - 1] = nums[i];
            }
        }
        return count_of_unique;
    }
}