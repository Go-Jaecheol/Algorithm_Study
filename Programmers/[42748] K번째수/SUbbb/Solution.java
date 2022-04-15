import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int from = commands[i][0];
            int to = commands[i][1];
            int k = commands[i][2];

            int[] tmp = Arrays.copyOfRange(array.clone(), from - 1, to);
            Arrays.sort(tmp);
            list.add(tmp[k - 1]);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}