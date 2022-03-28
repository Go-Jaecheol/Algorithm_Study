class Solution {
    public int solution(int n, int[][] results) {
        int[][] matching = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if(i != j)
                    matching[i][j] = Integer.MAX_VALUE;

        for (int[] result : results) {
            matching[result[0]][result[1]] = 1;
            matching[result[1]][result[0]] = -1;
        }

        graph(matching, n);

        return findCertainPlayer(matching, n);
    }

    public void graph(int[][] matching, int n) {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (matching[i][k] == 1 && matching[k][j] == 1){
                        matching[i][j] = 1;
                        matching[j][i] = -1;
                    }
    }

    private int findCertainPlayer(int[][] matching, int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            boolean check = true;
            for (int j = 1; j <= n; j++)
                if (matching[i][j] == Integer.MAX_VALUE) {
                    check = false;
                    break;
                }
            if(check)
                count++;
        }

        return count;
    }
}