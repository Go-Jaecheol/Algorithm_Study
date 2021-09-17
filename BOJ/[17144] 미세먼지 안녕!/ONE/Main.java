import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dust{
    int row;
    int col;
    int amount;

    public Dust(int row, int col, int amount){
        this.row = row;
        this.col = col;
        this.amount = amount;
    }
}

public class Main {
    private static int R, C, T;
    private static ArrayList<Integer> airCleaner = new ArrayList<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] room;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();
        T = scanner.nextInt();

        room = new int[R][C];

        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++){
                room[i][j] = scanner.nextInt();
                if (room[i][j] == -1)
                    airCleaner.add(i);
            }

        for(int i = 0; i < T; i++){
            spreading();
            purification();
        }

        System.out.println(sumOfDust());

        scanner.close();
    }

    private static void spreading(){
        int[][] tmp = new int[R][C];
        Queue<Dust> dusts = new LinkedList<>();

        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(room[i][j] != 0) {
                    if(room[i][j] == -1)
                        tmp[i][j] = -1;
                    else
                        dusts.add(new Dust(i, j, room[i][j]));
                }
        while(!dusts.isEmpty()){
            Dust dust = dusts.poll();

            int count = 0;
            for(int i = 0; i < 4; i++){
                int nx = dust.row + dx[i];
                int ny = dust.col + dy[i];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C && room[nx][ny] != -1){
                    tmp[nx][ny] += dust.amount / 5;
                    count++;
                }
            }
            tmp[dust.row][dust.col] += dust.amount - (dust.amount / 5) * count;
        }
        room = tmp;
    }

    private static void purification(){
        // 위의 경우와 아래의 경우로 나누어 생각
        for(int i = airCleaner.get(0) - 1; i > 0; i--)
            room[i][0] = room[i - 1][0];
        for(int i = 0; i < C - 1; i++)
            room[0][i] = room[0][i + 1];
        for(int i = 0; i < airCleaner.get(0); i++)
            room[i][C - 1] = room[i + 1][C - 1];
        for(int i = C - 1; i > 1; i--)
            room[airCleaner.get(0)][i] = room[airCleaner.get(0)][i - 1];
        room[airCleaner.get(0)][1] = 0;

        for(int i = airCleaner.get(1) + 1; i < R - 1; i++)
            room[i][0] = room[i + 1][0];
        for(int i = 0; i < C - 1; i++)
            room[R - 1][i] = room[R - 1][i + 1];
        for(int i = R - 1; i > airCleaner.get(1); i--)
            room[i][C - 1] = room[i - 1][C - 1];
        for(int i = C - 1; i > 1; i--)
            room[airCleaner.get(1)][i] = room[airCleaner.get(1)][i - 1];
        room[airCleaner.get(1)][1] = 0;
    }

    private static int sumOfDust(){
        int sum = 0;
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(room[i][j] != -1)
                    sum += room[i][j];
        return sum;
    }
}
