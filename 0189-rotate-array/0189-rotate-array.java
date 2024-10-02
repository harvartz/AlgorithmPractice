// 1. 기존 배열을 모두 역순으로 뒤집는다.
// 2. 0번째 인덱스부터 (k - 1)번째 인덱스까지 역순으로 뒤집는다.
// 3. k번째 인덱스부터 끝까지 역순으로 뒤집는다.

class Solution {
    public void rotate(int[] nums, int k) {
        // for(int i = 0; i < nums.length/2; i++){
        //     int temp = nums[i];
        //     nums[i] = nums[nums.length - 1 - i];
        //     nums[nums.length - 1 - i] = temp;
        // }

        // int length = k - 1;
        // for(int i = 0; i <= length; i++){
        //     int temp = nums[i];
        //     System.out.println(temp);
        //     nums[i] = nums[length - i];
        //     nums[length - i] = temp; 
        // }

        k %= nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k -1 );
        reverse(nums, k, nums.length - 1);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
    public void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}