import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] bridge = new int[bridge_length];
        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truck_weights)
            queue.add(truck);

        int headTruck = queue.poll();
        bridge[0] = headTruck;
        answer++;

        while (!isBridgeEmpty(bridge)) {
            moveTrucks(bridge);
            if(!queue.isEmpty()) {
                headTruck = queue.peek();
                if (!isOverWeight(sumOfBridge(bridge) + headTruck, weight)){
                    headTruck = queue.poll();
                    bridge[0] = headTruck;
                }
            }
            answer++;
        }

        return answer;
    }

    private boolean isOverWeight(int trucks, int weight) {
        return trucks > weight;
    }

    private int sumOfBridge(int[] bridge) {
        int sum = 0;
        for (int weight : bridge)
            sum += weight;
        return sum;
    }

    private void moveTrucks(int[] bridge) {
        for (int i = bridge.length - 1; i > 0; i--)
            bridge[i] = bridge[i - 1];
        bridge[0] = 0;
    }

    private boolean isBridgeEmpty(int[] bridge) {
        for(int truck : bridge)
            if(truck != 0)
                return false;
        return true;
    }
}