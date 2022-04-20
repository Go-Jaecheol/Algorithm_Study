import java.util.*;

class Solution {
    int[] possible;

    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> lostMap = new HashMap<>();

        for (int r : reserve)
            map.put(r, 1);

        for (int l : lost) {
            if (map.containsKey(l)) map.computeIfPresent(l, (k, v) -> v - 1);
            else lostMap.put(l, 0);
        }

        for (int l : lostMap.keySet()) {
            if (map.containsKey(l - 1) && map.get(l - 1) > 0) {
                map.computeIfPresent(l - 1, (k, v) -> v - 1);
                map.put(l, 0);
            } else if (map.containsKey(l + 1) && map.get(l + 1) > 0) {
                map.computeIfPresent(l + 1, (k, v) -> v - 1);
                map.put(l, 0);
            } else map.put(l, -1);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i) && map.get(i) < 0) continue;
            answer++;
        }


        return answer;
    }
}