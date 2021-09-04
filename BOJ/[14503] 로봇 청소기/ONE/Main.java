import java.util.Scanner;

class Robot{
    int row;
    int col;
    int direction; // 0:북, 1:동, 2:남, 3:서

    public Robot(int row, int col, int direction){
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}

public class Main {
    private static int N, M, count, result;
    private static int[][] room;
    private static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        room = new int[N][M];
        visited = new boolean[N][M];

        int r ,c, d;
        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        Robot robot = new Robot(r, c, d);

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                room[i][j] = scanner.nextInt();

        cleaning(robot);

        System.out.println(result);

        scanner.close();
    }

    private static void cleaning(Robot robot){
        if(!visited[robot.row][robot.col])
            result++;
        visited[robot.row][robot.col] = true;

        if(count > 4){ // 네 방향 모두 청소할 수 없을 때, 보고 있는 방향을 유지하면서 뒤로 한칸
            switch (robot.direction){
                case 0: // 남쪽으로 한칸 후진 (r+1, c)
                    if(robot.row + 1 < N && room[robot.row + 1][robot.col] == 0){
                        count = 1;
                        cleaning(new Robot(robot.row + 1, robot.col, robot.direction));
                    }
                    break;
                case 1: // 서쪽으로 한칸 후진 (r, c-1)
                    if(robot.col - 1 >= 0 && room[robot.row][robot.col - 1] == 0){
                        count = 1;
                        cleaning(new Robot(robot.row, robot.col - 1, robot.direction));
                    }
                    break;

                case 2: // 북쪽으로 한칸 후진 (r-1, c)
                    if(robot.row - 1 >= 0 && room[robot.row - 1][robot.col] == 0){
                        count = 1;
                        cleaning(new Robot(robot.row - 1, robot.col, robot.direction));
                    }
                    break;

                case 3: // 동쪽으로 한칸 후진 (r, c+1)
                    if(robot.col + 1 < M && room[robot.row][robot.col + 1] == 0){
                        count = 1;
                        cleaning(new Robot(robot.row, robot.col + 1, robot.direction));
                    }
                    break;
            }
            return;
        }

        switch (robot.direction){ // 현재 방향을 기준으로 왼쪽부터 탐색
            case 0: // 현재 방향이 북쪽 -> 서쪽부터 탐색 (r, c-1)
                if(robot.col - 1 >= 0 && room[robot.row][robot.col - 1] == 0 && !visited[robot.row][robot.col - 1]){
                    count = 1;
                    cleaning(new Robot(robot.row, robot.col - 1, 3));
                }
                else {
                    count++;
                    cleaning(new Robot(robot.row, robot.col, 3));
                }
                break;
            case 1: // 현재 방향이 동쪽 -> 북쪽부터 탐색 (r-1, c)
                if(robot.row - 1 >= 0 && room[robot.row - 1][robot.col] == 0 && !visited[robot.row - 1][robot.col]){
                    count = 1;
                    cleaning(new Robot(robot.row - 1, robot.col, 0));
                }
                else {
                    count++;
                    cleaning(new Robot(robot.row, robot.col, 0));
                }
                break;
            case 2: // 현재 방향이 남쪽 -> 동쪽부터 탐색 (r, c+1)
                if(robot.col + 1 < M && room[robot.row][robot.col + 1] == 0 && !visited[robot.row][robot.col + 1]){
                    count = 1;
                    cleaning(new Robot(robot.row, robot.col + 1, 1));
                }
                else {
                    count++;
                    cleaning(new Robot(robot.row, robot.col, 1));
                }
                break;
            case 3: // 현재 방향이 서쪽 -> 남쪽부터 탐색 (r+1, c)
                if(robot.row + 1 < N && room[robot.row + 1][robot.col] == 0 && !visited[robot.row + 1][robot.col]){
                    count = 1;
                    cleaning(new Robot(robot.row + 1, robot.col, 2));
                }
                else {
                    count++;
                    cleaning(new Robot(robot.row, robot.col, 2));
                }
                break;
        }
    }
}
