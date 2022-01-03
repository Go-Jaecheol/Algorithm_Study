import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Island{
    ArrayList<Point> points;

    public Island(ArrayList<Point> points){
        this.points = points;
    }
}

class Edge implements Comparable<Edge>{
    int u;
    int v;
    int w;

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
    private static int N, M, result;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[] parent;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Island> islands = new ArrayList<>();
    private static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    public static void main(String[] args) {
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i  = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();

        for(int i  = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 1 && !visited[i][j]){
                    ArrayList<Point> tempPoints = new ArrayList<>();
                    BFS(i, j, tempPoints);
                    islands.add(new Island(tempPoints));
                }

        parent = new int[islands.size()];
        for(int i = 0; i < islands.size(); i++)
            parent[i] = i;

        bridge();

        while(!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();

            if(find(current.u) != find(current.v)){
                union(current.u, current.v);
                result += current.w;
                cnt++;
            }
        }

        if(cnt != islands.size() - 1)
            result = -1;

        System.out.println(result);

        scanner.close();
    }

    private static void BFS(int x, int y, ArrayList<Point> tempPoints){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(x, y);

        queue.add(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()){
            Point current = queue.poll();
            boolean check = false;

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                    else
                        check = true;
                }
            }
            if(check)
                tempPoints.add(current);
        }
    }

    private static boolean isIsland(Point a, Point b){
        int nx = a.x - b.x, ny = a.y - b.y;

        if(nx == 0){ // same row
            if(ny < 0){
                for(int i = a.y + 1; i < b.y; i++)
                    if(map[a.x][i] == 1)
                        return true;
            }
            else{
                for(int i = b.y + 1; i < a.y; i++)
                    if(map[a.x][i] == 1)
                        return true;
            }
        }
        else{ // same col
            if(nx < 0){
                for(int i = a.x + 1; i < b.x; i++)
                    if(map[i][a.y] == 1)
                        return true;
            }
            else{
                for(int i = b.x + 1; i < a.x; i++)
                    if(map[i][a.y] == 1)
                        return true;
            }
        }
        return false;
    }

    private static void bridge(){
        for(int i = 0; i < islands.size() - 1; i++)
            for (int j = i + 1; j < islands.size(); j++)
                for(Point a : islands.get(i).points)
                    for(Point b : islands.get(j).points)
                        if(a.x == b.x || a.y == b.y){
                            int distance = Math.abs(a.x - b.x) + Math.abs(a.y - b. y) - 1;
                            if(distance >= 2 && !isIsland(a, b))
                                priorityQueue.add(new Edge(i, j, distance));
                        }
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
