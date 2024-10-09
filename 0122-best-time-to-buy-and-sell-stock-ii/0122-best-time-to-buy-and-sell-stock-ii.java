class Solution {
    public int maxProfit(int[] prices) {
        // 산 시점의 Index를 저장
        int buyIndex = 0;
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            // 오늘 주식 가격이 다음날 주식 가격보다 크다. 즉, 다음날 주식 가격이 떨어진다.
            // => 팔아야 한다.
            if(prices[i+1] < prices[i]){
                // 처음 산 시점부터 오늘 주식 가격으로 팔았을 때의 가격의 차이
                profit += prices[i] - prices[buyIndex];
                // 다음날로 거래를 바로 시작할 수 있게
                buyIndex = i + 1;
            }
        }
        // 이러면 마지막까지 안파는 경우가 생긴다.
        profit += prices[prices.length - 1] - prices[buyIndex];
        return profit;
    }
}