import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int x,y,weight;

    public Node(int x, int y, int weight){
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {

    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] cave;
    static int[][] resultCave;
    static boolean[][] check;

    public static void main(String[] args) {
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);

        while (true){
            cnt++;
            N = scanner.nextInt();
            if(N <= 0) break;

            cave = new int[N][N];
            resultCave = new int[N][N];
            check = new boolean[N][N];

            for(int i = 0; i < N; i++){
                Arrays.fill(resultCave[i], Integer.MAX_VALUE);
                for(int j = 0; j < N; j++)
                    cave[i][j] = scanner.nextInt();
            }

            dijkstra();

            System.out.println("Problem " + cnt + ": " + resultCave[N-1][N-1]);
        }

        scanner.close();
    }

    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0,0,cave[0][0]));
        resultCave[0][0] = cave[0][0];

        while (!queue.isEmpty()){

            Node current = queue.poll();

            int x = current.x;
            int y = current.y;
            int weight = current.weight;

            if(check[x][y]) continue;
            check[x][y] = true;

            for(int i = 0; i < 4; i++){ // dx ,dy 의 상하좌우
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < N) // in cave
                    if(resultCave[next_x][next_y] > weight + cave[next_x][next_y]){
                        resultCave[next_x][next_y] = weight + cave[next_x][next_y];
                        queue.add(new Node(next_x, next_y, resultCave[next_x][next_y]));
                    }
            }

        }
    }
}
