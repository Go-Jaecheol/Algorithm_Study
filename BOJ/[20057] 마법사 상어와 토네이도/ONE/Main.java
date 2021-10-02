import java.util.ArrayList;
import java.util.Scanner;

class MovingSand{
    int x;
    int y;
    int percent;

    public MovingSand(int x, int y, int percent){
        this.x = x;
        this.y = y;
        this.percent = percent;
    }
}

public class Main {
    private static int N, sum;
    private static int nx, ny;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] sand;
    private static ArrayList<ArrayList<MovingSand>> scattering = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        sand = new int[N][N];

        nx = N / 2;
        ny = N / 2;

        makeScattering();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                sand[i][j] = scanner.nextInt();

        tornado();

        System.out.println(sum);

        scanner.close();
    }

    private static void makeScattering(){
        for(int i = 0; i < 4; i++){
            ArrayList<MovingSand> list = new ArrayList<>();
            switch (i){
                case 0: // (0, -1) -> left
                    list.add(new MovingSand(0, -2, 5));
                    list.add(new MovingSand(-1, -1, 10));
                    list.add(new MovingSand(1, -1, 10));
                    list.add(new MovingSand(1, 0, 7));
                    list.add(new MovingSand(-1, 0, 7));
                    list.add(new MovingSand(2, 0, 2));
                    list.add(new MovingSand(-2, 0, 2));
                    list.add(new MovingSand(1, 1, 1));
                    list.add(new MovingSand(-1, 1, 1));
                    break;
                case 1: // (1, 0) -> down
                    list.add(new MovingSand(2, 0, 5));
                    list.add(new MovingSand(1, -1, 10));
                    list.add(new MovingSand(1, 1, 10));
                    list.add(new MovingSand(0, -1, 7));
                    list.add(new MovingSand(0, 1, 7));
                    list.add(new MovingSand(0, 2, 2));
                    list.add(new MovingSand(0, -2, 2));
                    list.add(new MovingSand(-1, 1, 1));
                    list.add(new MovingSand(-1, -1, 1));
                    break;
                case 2: // (0, 1) -> right
                    list.add(new MovingSand(0, 2, 5));
                    list.add(new MovingSand(-1, 1, 10));
                    list.add(new MovingSand(1, 1, 10));
                    list.add(new MovingSand(1, 0, 7));
                    list.add(new MovingSand(-1, 0, 7));
                    list.add(new MovingSand(2, 0, 2));
                    list.add(new MovingSand(-2, 0, 2));
                    list.add(new MovingSand(1, -1, 1));
                    list.add(new MovingSand(-1, -1, 1));
                    break;
                case 3: // (-1, 0) -> up
                    list.add(new MovingSand(-2, 0, 5));
                    list.add(new MovingSand(-1, -1, 10));
                    list.add(new MovingSand(-1, 1, 10));
                    list.add(new MovingSand(0, -1, 7));
                    list.add(new MovingSand(0, 1, 7));
                    list.add(new MovingSand(0, -2, 2));
                    list.add(new MovingSand(0, 2, 2));
                    list.add(new MovingSand(1, 1, 1));
                    list.add(new MovingSand(1, -1, 1));
                    break;
            }
            scattering.add(list);
        }
    }

    public static void tornado(){
        int count = 2, direction = 0;

        for(int i = 1; i < N; i++){
            if(i == N - 1)
                count = 3;
            for(int j = 0; j < count; j++){
                for(int k = 0; k < i; k++){
                    int originSand, alpha;

                    nx += dx[direction];
                    ny += dy[direction];

                    originSand = sand[nx][ny];
                    alpha = originSand;
                    sand[nx][ny] = 0;

                    for(MovingSand movingSand : scattering.get(direction)){
                        int mowedSand = (int)(originSand * movingSand.percent * 0.01);
                        if(nx + movingSand.x >= 0 && ny + movingSand.y >= 0 && nx + movingSand.x < N && ny + movingSand.y < N)
                            sand[nx + movingSand.x][ny + movingSand.y] += mowedSand;
                        else
                            sum += mowedSand;
                        alpha -= mowedSand;
                    }

                    if(nx + dx[direction] >= 0 && ny + dy[direction] >= 0 && nx + dx[direction] < N && ny + dy[direction] < N)
                        sand[nx + dx[direction]][ny + dy[direction]] += alpha;
                    else
                        sum += alpha;
                }
                direction = (direction + 1) % 4;
            }
        }
    }
}
