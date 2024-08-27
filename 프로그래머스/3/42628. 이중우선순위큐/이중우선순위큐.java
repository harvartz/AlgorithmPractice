import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            char command = parts[0].charAt(0);
            int value = Integer.parseInt(parts[1]);

            if (command == 'I') {
                maxQueue.offer(value);
                minQueue.offer(value);
            } else if (command == 'D') {
                if (value == 1 && !maxQueue.isEmpty()) {
                    // 최댓값 삭제
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else if (value == -1 && !minQueue.isEmpty()) {
                    // 최솟값 삭제
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        if (maxQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
    }
}
