// https://leetcode.com/problems/relative-sort-array/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int n = arr1[i];
            int freq = map.getOrDefault(n, 0) + 1;
            map.put(n, freq);
        }

        int[] ans = new int[arr1.length];
        int i = 0;
        for (int j = 0; j < arr2.length; j++) {
            int n = arr2[j];
            for (int k = map.get(n); k > 0; k--) {
                ans[i] = n;
                i++;
            }
            map.remove(n);
        }

        int[] remaining = new int[arr1.length - i];
        int i2 = 0;
        for (int j = 0; j < arr1.length; j++) {
            int n = arr1[j];
            if (map.containsKey(n)) {
                for (int k = map.get(n); k > 0; k--) {
                    remaining[i2] = n;
                    i2++;
                }
                map.remove(n);
            }
        }

        Arrays.sort(remaining);
        for (int n : remaining) {
            ans[i] = n;
            i++;
        }

        return ans;
    }
}