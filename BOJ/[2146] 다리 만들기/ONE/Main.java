import java.util.ArrayList;
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

class Island{
    ArrayList<Point> points;

    public Island(ArrayList<Point> points){
        this.points = points;
    }
}

public class Main {
    private static int N, result = Integer.MAX_VALUE;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] country;
    private static boolean[][] visited;
    private static ArrayList<Island> islands = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        country = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                country[i][j] = scanner.nextInt();

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                if(!visited[i][j] && country[i][j] == 1) {
                    ArrayList<Point> temp = new ArrayList<>();
                    BFS(i, j, temp);
                    islands.add(new Island(temp)); // 섬의 가장자리들인 Point 배열로 Island 생성하여 Island 배열에 추가
                }

        bridge(); // 섬끼리의 가장자리의 거리의 최솟값 구하기

        System.out.println(result);

        scanner.close();
    }

    private static void BFS(int x, int y, ArrayList<Point> temp){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(x, y);

        queue.add(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()){
            Point current = queue.poll();
            boolean check = false; // 해당 Point 가 가장자리인지 확인하기 위한 check

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= N && ny <= N && !visited[nx][ny]){ // N X N 범위에 있고 방문하지 않았지만
                    if(country[nx][ny] == 1){ // 1인 경우 -> 옮겨갈 수 있는 블록
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                    else // 하나라도 0인 경우 -> 가장자리 블록이라는 뜻
                        check = true;
                }
            }
            if(check){ // 가장자리 블록을 Point 배열에 넣음
                temp.add(current);
            }
        }
    }

    private static void bridge(){
        for(int i = 0; i < islands.size() - 1; i++)   // 섬끼리 비교
            for(int j = i + 1; j < islands.size();j ++)
                for(Point a : islands.get(i).points) // 섬의 가장자리 Point 를 각각 비교하여 최솟값 도출
                    for(Point b : islands.get(j).points){
                        int distance = Math.abs(a.x - b.x) + Math.abs(a.y - b. y) - 1;
                        if(distance < result)
                            result = distance;
                    }
    }
}
