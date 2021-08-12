import java.util.*;

class Node implements Comparable<Node>{

    int end, weight; // 노드가 향하는 목적지와 가중치

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
    private static int V,E,K;
    private static int INF = 1000000;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        V = scanner.nextInt(); // 정점의 개수 1~20000
        E = scanner.nextInt(); // 간선의 개수 1~300000
        K = scanner.nextInt(); // 정점의 시작 번호

        list = new ArrayList[V + 1]; // 정점 개수만큼 배열 초기화
        dist = new int[V + 1];
        Arrays.fill(dist,INF); // 배열은 INF로 초기화

        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            int start,end,weight;
            start = scanner.nextInt();
            end = scanner.nextInt();
            weight = scanner.nextInt();
            list[start].add(new Node(end,weight));
        }

        dijkstra(K); // 출발점을 파라미터로 전달

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

        scanner.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];

        queue.add(new Node(start,0)); // 시작점을 0으로 초기화
        dist[start] = 0;

        while (!queue.isEmpty()){
            Node current = queue.poll();
            int cur = current.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node:list[cur])
                if (dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
        }
    }
}
