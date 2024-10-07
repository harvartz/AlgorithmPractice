// 배열의 숫자의 순서를 유지하면서 0만 맨 마지막으로 보내는 문제
// 0을 제외하고 && 숫자를 차례대로 앞에서 넣어줘야 한다.
// 필요한 건, 다음에 들어갈 숫자의 포인터를 계속 업데이트 해줘야 한다.

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int cur = 0;
        for(int i = 0; i<nums.length; i++){
            // 0이 아니면 숫자를 앞뒤로 바꿔주되, cur라는 변수(숫자가 올 때 다음에 추가될 위치)
            if(nums[i] != 0){
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}