import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Dice {
    int[][] map;
    int[] commands;
    int[] numbers = new int[6];
    int[] rangeX = { 0, 0, -1, 1 };
    int[] rangeY = { 1, -1, 0, 0 };
    int N, M, K;
    int top = 0, front = 4, east = 2;

    public Dice(int N, int M, int K) {
        this.N = N;
        this.M = M;
        this.K = K;
        map = new int[N][M];
        commands = new int[K];
    }

    public void game(int x, int y) {
        for (int i = 0; i < K; i++) {
            int nx = x + rangeX[commands[i] - 1];
            int ny = y + rangeY[commands[i] - 1];

            if (isInTheMap(nx, ny)) continue;

            x = nx;
            y = ny;

            rollDice(commands[i] - 1);

            if (map[x][y] == 0) {
                map[x][y] = numbers[5 - top];
            } else {
                numbers[5 - top] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(numbers[top]);
        }
    }

    private boolean isInTheMap(int x, int y) {
        return (x < 0 | x >= N | y < 0 | y >= M);
    }

    private void rollDice(int command) {
        int t, e, f;
        t = top;
        e = east;
        f = front;
        switch (command) {
            case 0:
                top = 5 - e;
                east = t;
                break;
            case 1:
                top = e;
                east = 5 - t;
                break;
            case 2:
                top = f;
                front = 5 - t;
                break;
            case 3:
                top = 5 - f;
                front = t;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = line[0], M = line[1], x = line[2], y = line[3], K = line[4];

        Dice dice = new Dice(N, M, K);

        for (int i = 0; i < N; i++) dice.map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dice.commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dice.game(x, y);

        br.close();
    }
}