import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FireBall {
    Pair p;
    int m;
    int s;
    int d;

    public FireBall(Pair p, int m, int s, int d) {
        this.p = p;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {
    static Queue<FireBall> queue = new LinkedList<>();
    static List<FireBall>[][] ballList;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int[] all = {0, 2, 4, 6};
    static int[] not = {1, 3, 5, 7};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            queue.add(new FireBall(new Pair(x, y), m, s, d));
        }

        while(K > 0) {
            ballList = new ArrayList[N + 1][N + 1];
            moveFireBalls();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    List<FireBall> list = ballList[i][j];
                    // null이면 파이어볼이 없는 경우
                    if (list == null) continue;
                        // 파이어볼이 하나만 있는 경우
                    else if (list.size() == 1)
                        queue.add(list.get(0));
                        // 파이어볼이 2개 이상인 경우
                    else
                        spreadBalls(list);
                }
            }

            K--;
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            FireBall fb = queue.poll();
            answer += fb.m;
        }

        System.out.println(answer);
    }

    private static void moveFireBalls() {
        while (!queue.isEmpty()) {
            FireBall fb = queue.poll();
            Pair p = fb.p;
            int x = p.x;
            int y = p.y;
            int m = fb.m;
            int s = fb.s;
            int d = fb.d;

            int nx = x + dir[d][0] * (s % N);
            int ny = y + dir[d][1] * (s % N);

            // 범위 밖인 경우 처리
            if (nx > 0) nx %= N;
            if (ny > 0) ny %= N;
            if (nx <= 0) nx = N - Math.abs(nx);
            if (ny <= 0) ny = N - Math.abs(ny);

            p = new Pair(nx, ny);
            fb = new FireBall(p, m, s, d);

            if (ballList[nx][ny] == null) ballList[nx][ny] = new ArrayList<>();
            ballList[nx][ny].add(new FireBall(p, m, s, d));
        }
    }

    private static void spreadBalls(List<FireBall> list) {
        int count = list.size();
        Pair p = list.get(0).p;
        int m = 0;
        int s = 0;
        int evenCheck = 0;
        int oddCheck = 0;
        int[] ballDir;

        for (FireBall fb : list) {
            m += fb.m;
            s += fb.s;
            int d = fb.d;

            if (d % 2 == 0) evenCheck++;
            else oddCheck++;
        }

        // 방향 지정
        if (evenCheck == count || oddCheck == count) ballDir = all;
        else ballDir = not;

        m = m / 5;

        if (m == 0) return;

        s = s / count;

        for (int i = 0; i < 4; i++)
            queue.add(new FireBall(p, m, s, ballDir[i]));
    }
}
