class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            int idx = 0;
            for (int j = idx; j < want.length; j++) {
                int num = number[j];
                for (int k = i; k < i + 10; k++) {
                    if (discount[k].equals(want[j])) num--;
                }
                if (num > 0) {
                     break;
                }
                idx++; // 다음 상품을 위해 idx 증가
            }
            if (idx == want.length) answer++;
        }
        return answer;
    }
}