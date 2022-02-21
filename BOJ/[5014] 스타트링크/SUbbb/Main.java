import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int floor;
    int cnt;

    public Pair(int floor, int cnt) {
        this.floor = floor;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]), S = Integer.parseInt(line[1]), G = Integer.parseInt(line[2]);
        int[] upDown = {Integer.parseInt(line[3]), -Integer.parseInt(line[4])};
        boolean[] visited = new boolean[F + 1];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(S, 0));
        visited[S] = true;

        while(!q.isEmpty()) {
            Pair now = q.poll();
            int now_floor = now.floor;
            int now_cnt = now.cnt;

            if (now_floor == G) {
                System.out.println(now_cnt);
                return;
            }

            for (int go : upDown) {
                int nxFloor = now_floor + go;
                if (nxFloor <= 0 || nxFloor > F) continue;
                if (visited[nxFloor]) continue;

                q.add(new Pair(nxFloor, now_cnt + 1));
                visited[nxFloor] = true;
            }
        }

        System.out.println("use the stairs");

        br.close();
    }
}