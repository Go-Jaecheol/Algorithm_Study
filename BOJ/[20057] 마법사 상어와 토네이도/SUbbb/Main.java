import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    // 좌, 하, 우, 상
    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static List<List<List<Pair>>> sandDir = new ArrayList<>();
    static int[][] map;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        init();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int torX = N / 2;
        int torY = N / 2;
        int answer = 0;
        int dirCount = 0;
        int count = 1;
        int d = 0;

        while(!(torX == 0 && torY == 0)) {
            // 토네이도 이동
            if (dirCount == 2) {
                dirCount = 0;
                count++;
            }
            dirCount++;
            for (int c = 0; c < count; c++) {
                if (torX == 0 && torY == 0) break;
                int nx = torX + dir[d][0];
                int ny = torY + dir[d][1];

                int allSand = map[nx][ny];
                if (allSand == 0) {
                    torX = nx;
                    torY = ny;
                    continue;
                }
                map[nx][ny] = 0;
                int sand = 0;

                // 모래 분산
                int tx, ty;
                List<Pair> list = sandDir.get(d).get(0);
                int now = (int) ((double) allSand * (double) (0.1));
                for (Pair p : list) {
                    tx = nx + p.x;
                    ty = ny + p.y;

                    if (!isIn(tx, ty))
                        answer += now;
                    else
                        map[tx][ty] += now;
                    sand += now;
                }

                list = sandDir.get(d).get(1);
                now = (int) ((double) allSand * (double) (0.07));
                for (Pair p : list) {
                    tx = nx + p.x;
                    ty = ny + p.y;

                    if (!isIn(tx, ty))
                        answer += now;
                    else
                        map[tx][ty] += now;
                    sand += now;
                }

                now = (int) ((double) allSand * (double) (0.05));
                tx = nx + dir[d][0] * 2;
                ty = ny + dir[d][1] * 2;
                if (!isIn(tx, ty))
                    answer += now;
                else
                    map[tx][ty] += now;
                sand += now;

                list = sandDir.get(d).get(2);
                now = (int) ((double) allSand * (double) (0.02));
                for (Pair p : list) {
                    tx = nx + p.x;
                    ty = ny + p.y;

                    if (!isIn(tx, ty))
                        answer += now;
                    else
                        map[tx][ty] += now;
                    sand += now;
                }

                list = sandDir.get(d).get(3);
                now = (int) ((double) allSand * (double) (0.01));
                for (Pair p : list) {
                    tx = nx + p.x;
                    ty = ny + p.y;

                    if (!isIn(tx, ty))
                        answer += now;
                    else
                        map[tx][ty] += now;
                    sand += now;
                }

                tx = nx + dir[d][0];
                ty = ny + dir[d][1];
                sand = allSand - sand;
                if (!isIn(tx, ty))
                    answer += sand;
                else
                    map[tx][ty] += sand;

                torX = nx;
                torY = ny;
            }
            d = (d + 1) % 4;
        }

        System.out.println(answer);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void init() {
        for (int i = 0; i < 4; i++) {
            sandDir.add(new ArrayList<>());
            for (int j = 0; j < 4; j++)
                sandDir.get(i).add(new ArrayList<>());
        }

        // 좌
        sandDir.get(0).get(0).add(new Pair(-1, -1));
        sandDir.get(0).get(0).add(new Pair(1, -1));
        sandDir.get(0).get(1).add(new Pair(-1, 0));
        sandDir.get(0).get(1).add(new Pair(1, 0));
        sandDir.get(0).get(2).add(new Pair(-2, 0));
        sandDir.get(0).get(2).add(new Pair(2, 0));
        sandDir.get(0).get(3).add(new Pair(-1, 1));
        sandDir.get(0).get(3).add(new Pair(1, 1));

        // 하
        sandDir.get(1).get(0).add(new Pair(1, -1));
        sandDir.get(1).get(0).add(new Pair(1, 1));
        sandDir.get(1).get(1).add(new Pair(0, -1));
        sandDir.get(1).get(1).add(new Pair(0, 1));
        sandDir.get(1).get(2).add(new Pair(0, -2));
        sandDir.get(1).get(2).add(new Pair(0, 2));
        sandDir.get(1).get(3).add(new Pair(-1, -1));
        sandDir.get(1).get(3).add(new Pair(-1, 1));

        // 우
        sandDir.get(2).get(0).add(new Pair(-1, 1));
        sandDir.get(2).get(0).add(new Pair(1, 1));
        sandDir.get(2).get(1).add(new Pair(-1, 0));
        sandDir.get(2).get(1).add(new Pair(1, 0));
        sandDir.get(2).get(2).add(new Pair(-2, 0));
        sandDir.get(2).get(2).add(new Pair(2, 0));
        sandDir.get(2).get(3).add(new Pair(-1, -1));
        sandDir.get(2).get(3).add(new Pair(1, -1));

        // 상
        sandDir.get(3).get(0).add(new Pair(-1, -1));
        sandDir.get(3).get(0).add(new Pair(-1, 1));
        sandDir.get(3).get(1).add(new Pair(0, -1));
        sandDir.get(3).get(1).add(new Pair(0, 1));
        sandDir.get(3).get(2).add(new Pair(0, -2));
        sandDir.get(3).get(2).add(new Pair(0, 2));
        sandDir.get(3).get(3).add(new Pair(1, -1));
        sandDir.get(3).get(3).add(new Pair(1, 1));
    }
}