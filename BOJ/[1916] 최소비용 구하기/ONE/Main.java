import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) { // 가중치를 오름차순으로 정렬
        return weight - o.weight;
    }
}

public class Main {

    private static int N, M;
    private static int INF = Integer.MAX_VALUE; // 갈 수 없는 경우, 입력은 갈 수 있는 경우만 주어짐
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) {

        int start, end;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // Vertex
        M = scanner.nextInt(); // Edge

        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int A, B, weight; // A : start, B : end
            A = scanner.nextInt();
            B = scanner.nextInt();
            weight = scanner.nextInt();
            list[A].add(new Node(B, weight));
        }

        start = scanner.nextInt();
        end = scanner.nextInt();

        dijkstra(start);

        System.out.println(dist[end]);

        scanner.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];

        queue.add(new Node(start, 0)); // 시작점을 0으로 설정
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int cur = current.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node:list[cur])
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
        }
    }
}
