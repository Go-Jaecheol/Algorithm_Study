import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N, result;
    private static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i = 0; i < N; i++){
            int x, y, d, g;
            x = scanner.nextInt();
            y = scanner.nextInt();
            d = scanner.nextInt();
            g = scanner.nextInt();

            drangonCurve(y, x, d, g);
        }

        countSquare();

        System.out.println(result);

        scanner.close();
    }

    private static void drangonCurve(int x, int y, int d, int g){
        ArrayList<Integer> list = new ArrayList<>(); // 각 이동방향을 담을 리스트

        //0: x 좌표가 증가하는 방향 (→)
        //1: y 좌표가 감소하는 방향 (↑)
        //2: x 좌표가 감소하는 방향 (←)
        //3: y 좌표가 증가하는 방향 (↓)

        int direction = d;
        list.add(direction); // 처음 방향 담기

        for(int i = 0; i < g; i++)
            for(int j = list.size() - 1; j >= 0; j--){  // 리스트의 뒤에서 부터 검사
                direction = (list.get(j) + 1) % 4;  // 0 1 2 1 -> 2 3 2 1 이 되도록, 4가 되면 -> 0
                list.add(direction);
            }

        map[x][y] = true;
        for(int dir : list){  // 리스트를 반복문 돌면서 방향을 토대로 점찍기
            switch (dir){
                case 0: // Right
                    map[x][++y] = true;
                    break;
                case 1: // Up
                    map[--x][y] = true;
                    break;
                case 2: // Left
                    map[x][--y] = true;
                    break;
                case 3: // Down
                    map[++x][y] = true;
                    break;
            }
        }
    }

    private static void countSquare(){
        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) // 꼭짓점 4개가 ture 일 때
                    result++;
    }
}
