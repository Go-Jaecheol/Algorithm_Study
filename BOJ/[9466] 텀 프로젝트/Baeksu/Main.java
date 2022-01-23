import java.util.*;

class Graph {
    final int[] graph;
    int[] discovered;
    boolean[] fin;
    int answer = 0;
    int graph_size;

    public Graph(int size) {
        graph_size = size + 1;
        this.graph = new int[graph_size];
        discovered = new int[graph_size];
        fin = new boolean[graph_size];
    }

    public void AddElement(int x, int y) {
        graph[x] = y;
    }

    public int solution() {
        for (int i=1; i < graph_size; i++) this.search(i);
        return graph_size - 1 - this.answer;
    }

    public void search(int node) {
        if (discovered[node] == 1) return;

        discovered[node] = 1;
        int next = graph[node];

        if (discovered[next] == 0) search(graph[node]);
        else {
            if (!fin[next]) {
                // 다음 갈 정점이 방문은 했으나 아직 끝나지 않은, 즉 사이클이 생성되지 않은 상태
                answer++;
                for (int i=next; i!=node; i=graph[i]) {
                    answer++;
                }
            }
        }
        fin[node] = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int size = sc.nextInt();

            Graph g = new Graph(size);

            for (int i = 1; i <= size; i++) {
                int tmp = sc.nextInt();
                g.AddElement(i, tmp);
            }

            System.out.println(g.solution());
            T-=1;
        }
        sc.close();
    }
}