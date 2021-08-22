import java.util.*;

class Planet{
    int index, x, y, z;
    public Planet(int index, int x, int y, int z){
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

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
    private static int N;
    private static int[] parent;
    private static Planet[] planets;
    private static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;

        planets = new Planet[N];
        for(int i = 0; i < N; i++){
            int x, y, z;
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            planets[i] = new Planet(i + 1, x, y, z);
        }

        // x, y, z를 기준으로 각각 정렬하여 N-1 쌍 씩만 얻어서 간선에 추가
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });
        for(int i = 0; i < N - 1; i++){
            int weight = Math.abs(planets[i].x - planets[i + 1].x);
            queue.add(new Edge(planets[i].index, planets[i + 1].index, weight));
        }

        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });
        for(int i = 0; i < N - 1; i++){
            int weight = Math.abs(planets[i].y - planets[i + 1].y);
            queue.add(new Edge(planets[i].index, planets[i + 1].index, weight));
        }

        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });
        for(int i = 0; i < N - 1; i++){
            int weight = Math.abs(planets[i].z - planets[i + 1].z);
            queue.add(new Edge(planets[i].index, planets[i + 1].index, weight));
        }

        while (!queue.isEmpty()){
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
