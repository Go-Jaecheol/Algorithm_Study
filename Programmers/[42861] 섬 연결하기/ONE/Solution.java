import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int u, v, w;

    public Node(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = initParent(n);
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int[] node: costs)
            queue.add(new Node(node[0], node[1], node[2]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if(find(current.u, parent) != find(current.v, parent)){
                union(current.u, current.v, parent);
                answer += current.w;
            }
        }

        return answer;
    }

    private int[] initParent(int n){
        int[] parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        return parent;
    }

    private void union(int u, int v, int[] parent){
        int parent_u = find(u, parent);
        int parent_v = find(v, parent);

        if(parent_u < parent_v)
            parent[parent_v] = parent_u;
        else
            parent[parent_u] = parent_v;
    }

    private int find(int n, int[] parent){
        if(parent[n]== n)
            return n;
        return parent[n] = find(parent[n], parent);
    }
}