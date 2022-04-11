class Solution {
    int answer = 1;
    int[] visited;

    public int solution(int n, int[][] computers) {
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;
            dfs(computers, i);
            answer++;
        }

        return answer - 1;
    }

    private void dfs(int[][] computers, int idx) {
        if (visited[idx] != 0) return;

        visited[idx] = answer;

        for (int i = 0; i < computers[idx].length; i++)
            if (computers[idx][i] == 1 && visited[i] == 0)
                dfs(computers, i);
    }
}