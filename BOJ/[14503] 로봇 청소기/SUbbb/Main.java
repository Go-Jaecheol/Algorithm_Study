import java.io.*;
import java.util.*;

class Robot {
    int x;
    int y;
    int dir;

    public Robot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

class Directions {
    int x;
    int y;

    public Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Room {
    int[][] map;
    int N, M;
    Queue<Robot> queue = new LinkedList<>();
    Directions[] directions = {new Directions(-1, 0), new Directions(0, 1), new Directions(1, 0), new Directions(0, -1)};

    public Room (int n, int m) {
        N = n;
        M = m;
        map = new int[n][m];
    }

    public int cleanRoom(int r, int c, int d) {
        int cleanCount = 0;
        queue.add(new Robot(r, c, d));

        while(!queue.isEmpty()) {
            Robot robot = queue.poll();

            if (map[robot.x][robot.y] == 0) {
                map[robot.x][robot.y] = 2;
                cleanCount++;
            }

            if (!checkWallMethod(robot)) {
                moveBack(robot);
            }
        }
        return cleanCount;
    }

    private void moveBack(Robot robot) {
        int backDir = turnBack(robot.dir);
        int backX = robot.x + directions[backDir].x;
        int backY = robot.y + directions[backDir].y;

        if (!checkBoundary(backX, backY)) {
            if (map[backX][backY] != 1) {
                queue.add(new Robot(backX, backY, robot.dir));
            }
        }
    }

    private boolean checkWallMethod(Robot robot) {
        for (int i = 0; i < 4; i++) {
            int nextDir = turnLeft(robot.dir);
            int nextX = robot.x + directions[nextDir].x;
            int nextY = robot.y + directions[nextDir].y;

            robot.dir = nextDir;

            if (checkBoundary(nextX, nextY)) continue;

            if (map[nextX][nextY] == 0) {
                queue.add(new Robot(nextX, nextY, nextDir));
                return true;
            }
        }
        return false;
    }

    private boolean checkBoundary(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }

    private int turnLeft(int d) {
        return (d + 3) % 4;
    }

    private int turnBack(int d) {
        return (d + 2) % 4;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        Room room = new Room(N, M);

        line = br.readLine().split(" ");

        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int d = Integer.parseInt(line[2]);

        for (int i = 0; i < N; i++) room.map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(room.cleanRoom(r, c, d));

        br.close();
    }
}