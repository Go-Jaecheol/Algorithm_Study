import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{

    int u, v, w;

    public Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}

public class Main {
    private static int N, M;
    private static int[] parent;
    private static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++)
            parent[i] = i;
        for(int i = 0; i < M; i++){
            int u, v, w;
            u = scanner.nextInt();
            v = scanner.nextInt();
            w = scanner.nextInt();
            queue.add(new Edge(u, v, w));
        }

        while(!queue.isEmpty()){
            Edge current = queue.poll();

            if(find(current.u) != find(current.v)){
                union(current.u, current.v);
                result += current.w;
            }
        }

        System.out.println(result);

        scanner.close();
    }

    private static int find(int n){
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int a, int b){
        int parent_a = find(a), parent_b = find(b);

        if(parent_a < parent_b)
            parent[parent_b] = parent_a;
        else
            parent[parent_a] = parent_b;
    }
}
