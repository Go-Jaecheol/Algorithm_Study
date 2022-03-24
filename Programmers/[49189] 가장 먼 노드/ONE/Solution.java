import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i  = 0; i <= n; i ++)
            graph.add(i, new ArrayList<>());

        for (int[] vertex : edge) {
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }

        return bfs(n, graph);
    }

    private int bfs(int n, ArrayList<ArrayList<Integer>> graph) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : graph.get(cur)) {
                    if (!visited[node]) {
                        temp.add(node);
                        visited[node] = true;
                    }
                }
            }

            if (temp.isEmpty())
                break;
            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }
}