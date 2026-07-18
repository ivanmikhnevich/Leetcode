class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer>list = new ArrayList<Integer>();
        for(int n1 : nums1){
            list.add(n1);
        }
        for(int n2 : nums2){
            list.add(n2);
        }
        if (list.size() == 1) return list.get(0);
        list.sort(null);
        if(list.size() % 2 != 0){
            return list.get(list.size() / 2);
        }
        else {
            int first = list.get((int)(list.size() / 2) - 1);
            int second = list.get((int)(list.size() / 2));
            return (first + second) / 2.0;
        }
    }
}