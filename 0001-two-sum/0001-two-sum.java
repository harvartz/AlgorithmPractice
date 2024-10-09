import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // target- nums[i] key값에 대한 인덱스 , i 인덱스 (현재 순회중인)
                return new int[]{map.get(target - nums[i]), i};
            }
            // 그게 아니면 key, value를 넣는다.
            map.put(nums[i], i);
        }

        return null;
    }
}