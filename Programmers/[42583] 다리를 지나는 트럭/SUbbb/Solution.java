import java.util.*;

class Solution {
    private static Queue<Integer> bridge = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowWeight = 0;

        for (int truck : truck_weights) {
            while(true) {
                // 다리 위에 트럭이 없는 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    nowWeight += truck;
                    answer++;
                    break;
                }
                // 이미 다리가 가득 찬 경우 다리에서 트럭 하나 제외
                else if (bridge.size() == bridge_length) {
                    nowWeight -= bridge.poll();
                }
                // 다리의 용량 제한으로 인해 새로운 트럭을 올리지 못하는 경우 0을 추가해서 다리에 있는 트럭 밀기
                else if (nowWeight + truck > weight) {
                    bridge.add(0);
                    answer++;
                }
                // 다리 용량 제한을 만족하는 경우 트럭을 올림
                else {
                    bridge.add(truck);
                    nowWeight += truck;
                    answer++;
                    break;
                }
            }
        }

        // 마지막 트럭이 다리를 건너기 위해 필요한 시간 추가
        return answer + bridge_length;
    }
}