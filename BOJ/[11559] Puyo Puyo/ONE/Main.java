import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int result, count;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] field = new char[12][6];
    private static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 12; i++)
            field[i] = scanner.next().toCharArray();

        while(true){
            visited = new boolean[12][6];

            boolean check = false; // 4개 이상을 찾으면 true

            for(int i = 0; i < 12; i++)
                for(int j = 0; j < 6; j++)
                    if(!visited[i][j] && field[i][j] != '.'){
                        count = 1;

                        if(findSameColor(i, j, field[i][j])){
                            check = true;
                            puyo_BFS(i, j, field[i][j]);
                        }
                    }

            if(check) // 위에서 4개 이상의 연쇄가 있었을때 연쇄 개수 세기
                result++;
            else  // 연쇄가 없으므로 루프 탈출
                break;

            // 삭제 후 한칸씩 내리기
            while (true){
                boolean flag = vertical_fall();

                if(!flag) // 내릴게 없으므로 루프 탈출
                    break;
            }
        }
        System.out.println(result);

        scanner.close();
    }

    private static boolean findSameColor(int x, int y, char color){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || field[nx][ny] != color)
                continue;

            if(!visited[nx][ny] && field[nx][ny] == color){
                count++;
                findSameColor(nx,ny,color);
            }
        }
        return count >= 4;
    }

    private static boolean vertical_fall(){
        boolean check = false;

        for(int i = 11; i > 0; i--)
            for(int j = 5; j >=0; j--)
                if(field[i][j] == '.' && field[i - 1][j] != '.'){ // . 위에 다른 색이 있다면
                    check = true;
                    field[i][j] = field[i - 1][j];
                    field[i - 1][j] = '.';
                }
        return check;
    }

    private static void puyo_BFS(int x, int y, char color){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()){
            Point current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || field[nx][ny] != color)
                    continue;

                // 이전에 개수를 셀때 방문했고, 색상이 같으면 . 으로 변환
                if(visited[nx][ny] && field[nx][ny] == color){
                    field[nx][ny] = '.';
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
