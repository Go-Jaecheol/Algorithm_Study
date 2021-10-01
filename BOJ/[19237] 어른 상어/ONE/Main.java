import java.util.Scanner;

class Shark{
    int x;
    int y;
    int direction;  // 1:up, 2:down, 3:left, 4:right
    boolean isAlive = true;
    int[][] directionPriority = new int[5][4];

    public Shark(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Smell{
    int sharkNum;
    int count;

    public Smell(int sharkNum, int count){
        this.sharkNum = sharkNum;
        this.count = count;
    }
}

public class Main {
    private static int N, M, k, time;
    private static Shark[] sharks;
    private static Smell[][] smells;
    private static int[] dx = {0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        k = scanner.nextInt();

        smells = new Smell[N + 1][N + 1];
        sharks = new Shark[M + 1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++){
                smells[i][j] = new Smell(scanner.nextInt(), -1);
                if(smells[i][j].sharkNum != 0) {
                    sharks[smells[i][j].sharkNum] = new Shark(i, j);
                    smells[i][j].count = k;
                }
            }

        for(int i = 1; i <= M; i++)
            sharks[i].direction = scanner.nextInt();

        for(int i = 1; i <= M; i++)
            for(int j = 1; j <= 4; j++) // four directions
                for(int h = 0; h < 4; h++)
                    sharks[i].directionPriority[j][h] = scanner.nextInt();


        while (time < 1001){ // until number 1 shark left
            for(int i = 1; i <= N; i++)    // decrease smell count
                for(int j = 1; j <= N; j++)
                    smells[i][j].count--;

            int sharkcount = 0; // left num of shark

            loop: for (int i = M; i > 0; i--) {  // decreasing num of shark num
                if (!sharks[i].isAlive)
                    continue;

                if (smells[sharks[i].x][sharks[i].y].sharkNum != i) {  // if there is another shark
                    sharks[i].isAlive = false;
                    continue;
                }

                sharkcount++;

                int nx = 0, ny = 0;
                int sharkDir = sharks[i].direction;
                int dirPrior = 0;

                for (int j = 0; j < 4; j++) {
                    dirPrior = sharks[i].directionPriority[sharkDir][j];
                    nx = sharks[i].x + dx[dirPrior];
                    ny = sharks[i].y + dy[dirPrior];

                    if (nx < 1 || ny < 1 || nx > N || ny > N)
                        continue;

                    if (smells[nx][ny].count < 0) { // if smell is empty
                        sharks[i].x = nx;
                        sharks[i].y = ny;
                        sharks[i].direction = dirPrior;
                        continue loop;
                    }
                }

                sharkDir = sharks[i].direction;    // there is no smell empty
                for (int j = 0; j < 4; j++) {
                    dirPrior = sharks[i].directionPriority[sharkDir][j];
                    nx = sharks[i].x + dx[dirPrior];
                    ny = sharks[i].y + dy[dirPrior];

                    if (nx < 1 || ny < 1 || nx > N || ny > N)
                        continue;

                    if (smells[nx][ny].sharkNum == i && smells[nx][ny].count >= 0) {
                        sharks[i].x = nx;
                        sharks[i].y = ny;
                        sharks[i].direction = dirPrior;
                        continue loop;
                    }
                }

            }

            for (int i = M; i > 0; i--) { // move shark
                if (!sharks[i].isAlive)
                    continue;
                smells[sharks[i].x][sharks[i].y].count = k;
                smells[sharks[i].x][sharks[i].y].sharkNum = i;
            }

            if (sharkcount == 1) // num 1 shark only alive
                break;

            time++;
        }

        if(time == 1001)
            time = -1;

        System.out.println(time);

        scanner.close();
    }
}
