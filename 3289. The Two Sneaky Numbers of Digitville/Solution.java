// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, 2);
                ans[n] = num;
                n++;
            } else {
                map.put(num, 1);
            }
        }

        return ans;
    }
}