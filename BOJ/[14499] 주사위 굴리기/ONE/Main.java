import java.util.Scanner;

class Dice{
    int x;
    int y;
    int top;    // 1
    int back;   // 2
    int right;  // 3
    int left;   // 4
    int front;  // 5
    int bottom; // 6

    public Dice(int x, int y, int top, int back, int right, int left, int front, int bottom){
        // 주사위의 위치
        this.x = x;
        this.y = y;
        // 주사위의 각면에 적힌 수
        this.top = top;
        this.back = back;
        this.right = right;
        this.left = left;
        this.front = front;
        this.bottom = bottom;
    }

    public void moveEast() {
        int temp = top;
        top = left;
        left = bottom;
        bottom = right;
        right = temp;
    }

    public void moveWest() {
        int temp = top;
        top = right;
        right = bottom;
        bottom = left;
        left = temp;
    }

    public void moveSouth() {
        int temp = top;
        top = back;
        back = bottom;
        bottom = front;
        front = temp;
    }

    public void moveNorth() {
        int temp = top;
        top = front;
        front = bottom;
        bottom = back;
        back = temp;
    }
}

public class Main {
    private static int N, M, x, y, K;
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};
    private static int[][] map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        x = scanner.nextInt(); // 0 ≤ x ≤ N-1
        y = scanner.nextInt(); // 0 ≤ y ≤ M-1
        K = scanner.nextInt(); // 1 ≤ K ≤ 1,000

        map = new int[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();

        Dice dice = new Dice(x, y,0,0,0,0,0,0);

        for(int i = 0; i < K; i++){
            int direction = scanner.nextInt();
            int nx = dice.x + dx[direction];
            int ny = dice.y + dy[direction];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M){ // 지도 안
                dice.x = nx;
                dice.y = ny;

                changeSide(direction, dice);

                if(map[nx][ny] == 0)
                    map[nx][ny] = dice.bottom;
                else {
                    dice.bottom = map[nx][ny];
                    map[nx][ny] = 0;
                }

                System.out.println(dice.top);
            }
        }
        scanner.close();
    }

    private static void changeSide(int direction, Dice dice){ // 주사위에 적힌 수를 회전시키기
        switch (direction){
            case 1: // EAST
                dice.moveEast();
                break;
            case 2: // WEST
                dice.moveWest();
                break;
            case 3: // NORTH
                dice.moveNorth();
                break;
            case 4: // SOUTH
                dice.moveSouth();
                break;
        }
    }
}
