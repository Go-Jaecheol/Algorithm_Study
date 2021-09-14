import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Emoji> q = new LinkedList<>();
    static int N;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[1001][1001];
        Emoji e = new Emoji(1, 0, 0);
        visited[1][0] = 1;
        q.add(e);

        while (!q.isEmpty()) {
            Emoji cur = q.peek();
            q.poll();

            if (cur.screen == N) {
                System.out.println(cur.second);
                break;
            }
            q.add(new Emoji(cur.screen, cur.screen, cur.second + 1));
            if (cur.clip > 0 && cur.screen + cur.clip <= N && visited[cur.screen + cur.clip][cur.clip] != 1) {
                q.add(new Emoji(cur.screen + cur.clip, cur.clip, cur.second + 1));
                visited[cur.screen + cur.clip][cur.clip] = 1;
            }
            if (cur.screen > 0 && visited[cur.screen - 1][cur.clip] != 1) {
                q.add(new Emoji(cur.screen - 1, cur.clip, cur.second + 1));
                visited[cur.screen - 1][cur.clip] = 1;
            }
        }
    }
}

class Emoji {
    int screen = 0;
    int clip = 0;
    int second = 0;

    Emoji (int x, int y, int z) {
        this.screen = x;
        this.clip = y;
        this.second = z;
    }
}