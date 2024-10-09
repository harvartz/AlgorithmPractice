class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 1. 기존 배열을 모두 역순으로 뒤집는다.
        reverse(nums, 0, nums.length - 1);
        // 2. 0번째 인덱스부터 k-1번째 인덱스까지 역순으로 뒤집는다.
        reverse(nums, 0, k - 1);
        // 3. k번째 인덱스부터 끝까지 역순으로 뒤집는다.
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}