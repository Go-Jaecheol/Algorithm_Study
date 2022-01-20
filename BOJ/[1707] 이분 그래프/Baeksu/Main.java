import java.util.*;

class Graph {
    final List<Integer>[] graph;
    final int[] Binary = { -1, 1 };
    int[] discovered;
    boolean isBinaryGraph = true;
    int toggle = 0;

    public Graph(int size) {
        this.graph = new ArrayList[size+1];
        discovered = new int[size+1];

        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void DoubleAdd(int x, int y) {
        graph[x].add(y);
        graph[y].add(x);
    }

    public boolean solution() {
        for (int i=1; i < graph.length; i++) {
            if (graph[i].size() > 0 & discovered[i] == 0) {
                isBinaryGraph = this.bfs(i);
                if (!isBinaryGraph)
                    break;
            }
        }
        return this.isBinaryGraph;
    }

    public boolean bfs(int parent) {
        Queue<Integer> q = new LinkedList<>();
        q.add(parent);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (discovered[now] == 0) { discovered[now] = Binary[toggle]; }
            toggle = (discovered[now] == -1 ? 1 : 0);
            for (int tmp : graph[now]) {
                if (discovered[tmp] == 0) {
                    q.add(tmp);
                    discovered[tmp] = Binary[toggle];
                } else if (discovered[tmp] == discovered[now])
                    return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();

            Graph g = new Graph(v);

            for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.DoubleAdd(a,b);
            }

            if (g.solution())
                System.out.println("YES");
            else
                System.out.println("NO");
            T-=1;
        }
        sc.close();
    }
}