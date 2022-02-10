import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Loc {
    int x;
    int y;
    int cnt;

    public Loc(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}

class Graph {
    final int[][] graph;
    boolean[][] discovered;
    Queue<Loc> q = new LinkedList<>();
    int[] w_way = { 1, 0, -1, 0 };
    int[] y_way = { 0, 1, 0, -1 };
    int bridge = Integer.MAX_VALUE;
    int graph_size;

    public Graph(int size) {
        graph_size = size;
        this.graph = new int[graph_size][graph_size];
        discovered = new boolean[graph_size][graph_size];
    }

    public void AddElement(String line, int idx) {
        String[] tmp = line.split(" ");
        for(int i = 0; i < graph_size; i++) {
            graph[idx][i] = Integer.parseInt(tmp[i]);
        }
    }

    public void identifyLand() {
        int land = 2;
        for (int i = 0; i < graph_size; i++) {
            for (int j = 0; j < graph_size; j++) {
                if (!discovered[i][j] && graph[i][j] == 1) {
                    fillLand(i, j, land);
                    land++;
                }
            }
        }
    }

    private void fillLand(int x, int y, int land) {
        graph[x][y] = land;
        discovered[x][y] = true;
        q.add(new Loc(x, y, 0));

        while(!q.isEmpty()) {
            Loc loc = q.poll();
            int nowX = loc.getX();
            int nowY = loc.getY();

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + w_way[i], nextY = nowY + y_way[i];

                if (nextX < 0 || nextX >= graph_size || nextY < 0 || nextY >= graph_size) continue;
                if (discovered[nextX][nextY]) continue;

                if (graph[nextX][nextY] == 1) {
                    graph[nextX][nextY] = land;
                    discovered[nextX][nextY] = true;
                    q.add(new Loc(nextX, nextY, 0));
                }
            }
        }
    }

    public void solution() {
        for (int i = 0; i < graph_size; i++) {
            for (int j = 0; j < graph_size; j++) {
                if (graph[i][j] > 0) {
                    int cnt = buildBridge(i, j);
                    if (cnt == -1) continue;
                    bridge = Math.min(bridge, cnt);
                }
            }
        }
        System.out.println(bridge - 1);
    }

    private int buildBridge(int x, int y) {
        discovered = new boolean[graph_size][graph_size];
        q = new LinkedList<>();
        q.add(new Loc(x, y, 0));
        int cur_land = graph[x][y];
        discovered[x][y] = true;

        while(!q.isEmpty()) {
            Loc loc = q.poll();
            int cur_x = loc.getX();
            int cur_y = loc.getY();
            int cnt = loc.getCnt();

            if (graph[cur_x][cur_y] != 0 && graph[cur_x][cur_y] != cur_land) return cnt;

            for (int i = 0; i < 4; i++) {
                int nextX = cur_x + w_way[i], nextY = cur_y + y_way[i];

                if (nextX < 0 || nextX >= graph_size || nextY < 0 || nextY >= graph_size) continue;
                if (discovered[nextX][nextY] || graph[nextX][nextY] == cur_land) continue;

                discovered[nextX][nextY] = true;
                q.add(new Loc(nextX, nextY, cnt+1));
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Graph g = new Graph(N);

        String line="";
        for (int idx = 0; idx < N; idx++) {
            line = br.readLine();
            g.AddElement(line, idx);
        }

        g.identifyLand();

        g.solution();

        br.close();
    }
}