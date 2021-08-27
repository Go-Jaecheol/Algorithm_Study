import java.util.Scanner;

enum Direction {
    HORIZONTAL, VERTICAL, DIAGONAL // 가로 세로 대각선
}

class Pipe{
    int x, y; // 파이프의 끝점
    Direction direction; // 현재의 방향

    public Pipe(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

public class Main {
    private static int N;
    private static int[][] house;
    private static int result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        house = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                house[i][j] = scanner.nextInt();

        DFS(new Pipe(1, 2, Direction.HORIZONTAL));

        System.out.println(result);

        scanner.close();
    }

    private static void DFS(Pipe pipe){
        if(pipe.x == N && pipe.y == N){ // 종료 조건
            result++;
            return;
        }

        switch (pipe.direction){
            case HORIZONTAL :
                if(pipe.y + 1 <= N && house[pipe.x][pipe.y + 1] == 0)
                    DFS(new Pipe(pipe.x, pipe.y + 1, Direction.HORIZONTAL));
                break;
            case VERTICAL :
                if(pipe.x + 1 <= N && house[pipe.x + 1][pipe.y] == 0)
                    DFS(new Pipe(pipe.x + 1, pipe.y, Direction.VERTICAL));
                break;
            case DIAGONAL :
                if(pipe.y + 1 <= N && house[pipe.x][pipe.y + 1] == 0)
                    DFS(new Pipe(pipe.x, pipe.y + 1, Direction.HORIZONTAL));
                if(pipe.x + 1 <= N && house[pipe.x + 1][pipe.y] == 0)
                    DFS(new Pipe(pipe.x + 1, pipe.y, Direction.VERTICAL));
                break;
        }
        if(pipe.y + 1 <= N && pipe.x + 1 <= N && house[pipe.x][pipe.y + 1] == 0 && house[pipe.x + 1][pipe.y] == 0 && house[pipe.x + 1][pipe.y + 1] == 0)
            DFS(new Pipe(pipe.x + 1, pipe.y + 1, Direction.DIAGONAL));
    }
}
