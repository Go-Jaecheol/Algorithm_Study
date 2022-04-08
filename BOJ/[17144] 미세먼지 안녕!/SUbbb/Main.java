import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Room {
    Queue<Pair> dustQueue = new LinkedList<>();
    int[][] room;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };
    int R, C;
    int cleaner1X, cleaner2X;

    public Room (int R, int C) {
        this.R = R;
        this.C = C;
        room = new int[R][C];
    }

    public int goodByeFineDust(int time) {
        while(time > 0) {
            spreadDust();
            runCleaner();
            time--;
        }
        return countDust();
    }

    private void spreadDust() {
        int[][] tmp = new int[R][C];

        while(!dustQueue.isEmpty()) {
            Pair dust = dustQueue.poll();
            int divDust = room[dust.x][dust.y] / 5;
            int checkSpread = 0;

            for (int i = 0; i < 4; i++) {
                int nx = dust.x + rangeX[i];
                int ny = dust.y + rangeY[i];

                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1) continue;
                if (room[nx][ny] == -1) continue;

                tmp[nx][ny] += divDust;
                checkSpread++;
            }
            tmp[dust.x][dust.y] = tmp[dust.x][dust.y] + room[dust.x][dust.y] - (divDust * checkSpread);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] == -1) continue;
                room[i][j] = tmp[i][j];
            }
        }
    }

    private void runCleaner() {
        int i = 0;
        for (i = cleaner1X - 2; i >= 0; i--) {
            room[i + 1][0] = room[i][0];
        }
        for (i = 1; i < C; i++) {
            room[0][i - 1] = room[0][i];
        }
        for (i = 1; i <= cleaner1X; i++) {
            room[i - 1][C - 1] = room[i][C - 1];
        }
        for (i = C - 2; i > 0; i--) {
            room[cleaner1X][i + 1] = room[cleaner1X][i];
        }

        for (i = cleaner2X + 2; i < R; i++) {
            room[i - 1][0] = room[i][0];
        }
        for (i = 1; i < C; i++) {
            room[R - 1][i - 1] = room[R - 1][i];
        }
        for (i = R - 2; i >= cleaner2X; i--) {
            room[i + 1][C - 1] = room[i][C - 1];
        }
        for (i = C - 2; i > 0; i--) {
            room[cleaner2X][i + 1] = room[cleaner2X][i];
        }

        room[cleaner1X][1] = room[cleaner2X][1] = 0;

        for (i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) dustQueue.add(new Pair(i, j));
            }
        }
    }

    private int countDust() {
        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) count += room[i][j];
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = line[0], C = line[1], T = line[2];

        Room dirtyRoom = new Room(R, C);

        for (int i = 0; i < R; i++) {
            dirtyRoom.room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (dirtyRoom.room[i][0] == -1 && dirtyRoom.cleaner1X == 0) {
                dirtyRoom.cleaner1X = i;
                dirtyRoom.cleaner2X = i+1;
            }
            for (int j = 0; j < C; j++) {
                if (dirtyRoom.room[i][j] > 0) dirtyRoom.dustQueue.add(new Pair(i, j));
            }
        }
        br.close();

        System.out.println(dirtyRoom.goodByeFineDust(T));
    }
}