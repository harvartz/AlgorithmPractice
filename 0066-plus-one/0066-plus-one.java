class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // 뒤에서부터 처리
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 모든 자리가 9였을 경우 (예: 999 + 1 = 1000)
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        // 나머지 자리는 이미 0으로 초기화되어 있음
        return newDigits;
    }
}
