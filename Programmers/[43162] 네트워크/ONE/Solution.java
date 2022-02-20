import java.util.HashMap;

class Solution {
    private int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(j != i && computers[i][j] == 1)
                    union(i, j);

        for(int i = 0; i < n; i++)
            parent[i] = find(i);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : parent)
            map.put(key, map.getOrDefault(key, 0) + 1);

        return map.size();
    }

    private int find(int n) {
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }

    private void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);

        if(parent_a < parent_b)
            parent[parent_b] = parent_a;
        else
            parent[parent_a] = parent_b;
    }
}