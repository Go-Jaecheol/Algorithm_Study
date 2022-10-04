import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int d;
    int f;

    public Node(int x, int y, int d, int f) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.f = f;
    }
}

public class Main {
    static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[][] fishes = new Node[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int fish = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                fishes[i][j] = new Node(i, j, d - 1, fish);
            }
        }

        Node shark = new Node(0, 0, fishes[0][0].d, fishes[0][0].f);
        fishes[0][0].f = -1;

        huntingShark(fishes, shark, shark.f);

        System.out.println(count);
    }

    private static void huntingShark(Node[][] fishes, Node shark, int sum) {
        count = Math.max(count, sum);
        // 상어가 움직였으니 이제 물고기들 이동시킬 차례
        moveFish(fishes);

        // 이제 상어가 움직일 좌표를 탐색
        // 가능한 좌표들을 스택에 push
        Stack<Node> stack = new Stack<>();

        int nx = shark.x;
        int ny = shark.y;
        int nd = shark.d;
        for (int i = 0; i < 3; i++) {
            nx += dir[nd][0];
            ny += dir[nd][1];

            if (isIn(nx, ny) && fishes[nx][ny].f != 0)
                stack.add(new Node(nx, ny, fishes[nx][ny].d, fishes[nx][ny].f));
        }

        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            Node tmpShark = new Node(shark.x, shark.y, shark.d, shark.f);
            Node[][] tmpFishes = copyFish(fishes);

            tmpFishes[tmpShark.x][tmpShark.y].f = 0;

            // 상어를 이동시키고, 먹은 물고기 번호 갱신
            tmpShark.x = cur.x;
            tmpShark.y = cur.y;
            tmpShark.d = cur.d;
            int tmpSum = sum + tmpFishes[cur.x][cur.y].f;

            tmpFishes[tmpShark.x][tmpShark.y].f = -1;

            huntingShark(tmpFishes, tmpShark, tmpSum);
        }
    }

    private static void moveFish(Node[][] fishes) {
        for (int num = 1; num <= 16; num++) {
            boolean check = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (fishes[i][j].f > 0 && fishes[i][j].f == num && !check) {
                        check = true;

                        for (int k = 0; k < 8; k++) {
                            int nx = i + dir[fishes[i][j].d][0];
                            int ny = j + dir[fishes[i][j].d][1];

                            if (isIn(nx, ny) && fishes[nx][ny].f != -1) {
                                // 스왑!
                                int tmpNum = fishes[i][j].f;
                                fishes[i][j].f = fishes[nx][ny].f;
                                fishes[nx][ny].f = tmpNum;

                                tmpNum = fishes[i][j].d;
                                fishes[i][j].d = fishes[nx][ny].d;
                                fishes[nx][ny].d = tmpNum;
                                break;
                            } else
                                fishes[i][j].d = changeD(fishes[i][j].d);
                        }
                    }
                }
            }
        }
    }

    private static int changeD(int d) {
        return (d + 1) % 8;
    }

    private static Node[][] copyFish(Node[][] fishes) {
        Node[][] tmp = new Node[4][4];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                tmp[i][j] = new Node(fishes[i][j].x, fishes[i][j].y, fishes[i][j].d, fishes[i][j].f);

        return tmp;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}