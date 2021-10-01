import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class FireBall{
    int r;
    int c;
    int m;
    int s;
    int d;
    public FireBall(int r, int c, int m, int s, int d){
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {
    private static int N, M, K;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] countMap;
    private static ArrayList<FireBall> fireBalls = new ArrayList<>();
    private static Queue<Node> over2Queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        countMap = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            int r, c, m, d, s;
            r = scanner.nextInt();
            c = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.nextInt();
            d = scanner.nextInt();
            fireBalls.add(new FireBall(r, c, m, s, d));
            countMap[r][c]++;
        }

        for(int i = 0; i < K; i++){
            moveFireBall();
            if(checkOver2())
                sumAndDecompose();
        }

        System.out.println(sumMass());

        scanner.close();
    }

    private static void moveFireBall(){
        for (FireBall fireBall : fireBalls) {
            int nx = fireBall.r, ny = fireBall.c;
            countMap[nx][ny]--; // leave current (r,c)

            for (int j = 0; j < fireBall.s; j++) {
                nx += dx[fireBall.d];
                ny += dy[fireBall.d];

                if(nx < 1)
                    nx = N;
                else if(nx > N)
                    nx = 1;
                if(ny < 1)
                    ny = N;
                else if(ny > N)
                    ny = 1;
            }
            fireBall.r = nx;
            fireBall.c = ny;
            countMap[nx][ny]++;
        }
    }

    private static boolean checkOver2(){
        boolean check = false;

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                if(countMap[i][j] >= 2){
                    check = true;
                    over2Queue.add(new Node(i, j));
                }
        return check;
    }

    private static boolean checkOddAndEven(ArrayList<Integer> directions){
        boolean check = true;

        int num = directions.get(0) % 2;
        for(int i = 1; i < directions.size(); i++)
            if(directions.get(i) % 2 != num)
                check = false;
        return check;
    }

    private static int findIndex(Node node){
        for(int i = 0; i < fireBalls.size(); i++){
            if(fireBalls.get(i).r == node.x && fireBalls.get(i).c == node.y)
                return i;
        }
        return 0;
    }

    private static void sumAndDecompose(){
        while (!over2Queue.isEmpty()){
            ArrayList<Integer> directions = new ArrayList<>();
            Node node = over2Queue.poll();
            FireBall unitedFireBall = new FireBall(node.x, node.y, 0, 0, 0);

            for(int i = 0; i < countMap[node.x][node.y]; i++){
                int index = findIndex(node);
                unitedFireBall.m += fireBalls.get(index).m;
                unitedFireBall.s += fireBalls.get(index).s;
                directions.add(fireBalls.get(index).d);
                fireBalls.remove(index);
            }

            int dividedMass = unitedFireBall.m / 5;
            int dividedSpeed = unitedFireBall.s / countMap[node.x][node.y];

            if(dividedMass > 0){
                countMap[node.x][node.y] = 4;
                int dir = 0;

                if(!checkOddAndEven(directions))
                    dir = 1;

                for(int j = 0; j < 4; j++){
                    fireBalls.add(new FireBall(node.x, node.y, dividedMass, dividedSpeed, dir));
                    dir += 2;
                }
            }
            else
                countMap[node.x][node.y] = 0;
        }
    }

    private static int sumMass(){
        int sum = 0;

        for(FireBall fireball : fireBalls)
            sum += fireball.m;

        return sum;
    }
}
