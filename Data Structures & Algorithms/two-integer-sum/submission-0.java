class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementList = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(complementList.containsKey(complement)) {
                return new int[]{complementList.get(complement), i};
            }

            complementList.put(nums[i], i);
        }

        return new int[0];
    }
}
