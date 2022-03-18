import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

class Info {
    int second;
    char direction;

    public Info (int second, char direction) {
        this.second = second;
        this.direction = direction;
    }
}

class Dummy {
    Info[] infos;
    Queue<Pair> queue = new LinkedList<>();
    int[][] map;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };
    int mapSize;
    int directionChanges;
    int count = 0;
    int infoIdx = 0;
    int snakeDir;

    public Dummy (int N) {
        mapSize = N;
        map = new int[N][N];
    }

    public int game(int directionChanges) {
        snakeDir = 1;
        this.directionChanges = directionChanges;
        moveSnake(0, 0);
        return count;
    }

    private void moveSnake(int x, int y) {
        queue.add(new Pair(x, y));
        map[x][y] = 1;

        if (infoIdx < directionChanges) accessInfo();

        x += rangeX[snakeDir];
        y += rangeY[snakeDir];
        count++;

        if (checkBoundary(x, y)) return;
        if (map[x][y] == 1) return;
        if (map[x][y] != 2) cutTail();

        moveSnake(x, y);
    }

    private void accessInfo() {
        if (infos[infoIdx].second == count) {
            updateDir();
            infoIdx++;
        }
    }

    private void updateDir() {
        if (infos[infoIdx].direction == 'L') {
            snakeDir = (snakeDir + 3) % 4;
        } else {
            snakeDir = (snakeDir + 1) % 4;
        }
    }

    private void cutTail() {
        if (!queue.isEmpty()) {
            Pair out = queue.poll();
            map[out.x][out.y] = 0;
        }
    }

    private boolean checkBoundary(int x, int y) {
        return (x < 0 || x >= mapSize || y < 0 || y >= mapSize);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Dummy dummy = new Dummy(N);

        int appleCount = Integer.parseInt(br.readLine());

        String[] line;
        for (int i = 0; i < appleCount; i++) {
            line = br.readLine().split(" ");
            dummy.map[Integer.parseInt(line[0])-1][Integer.parseInt(line[1])-1] = 2;
        }

        int directionChanges = Integer.parseInt(br.readLine());
        dummy.infos = new Info[directionChanges];
        for (int i = 0; i < directionChanges; i++) {
            line = br.readLine().split(" ");
            dummy.infos[i] = new Info(Integer.parseInt(line[0]), line[1].charAt(0));
        }
        br.close();

        System.out.println(dummy.game(directionChanges));
    }
}