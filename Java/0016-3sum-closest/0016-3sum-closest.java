class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)return 0;
        int[] triplet = new int[3];
        Arrays.sort(nums);

        int closest_sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target)return sum;                
                else {
                    closest_sum = Math.abs(target - sum) < Math.abs(target - closest_sum) ? sum : closest_sum;

                    if(sum < target)j++;
                    else k--;
                }
            }
        }
        return closest_sum;      
    }
}