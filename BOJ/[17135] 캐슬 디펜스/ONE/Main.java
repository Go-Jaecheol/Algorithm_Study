import java.util.Scanner;

class Node{
    int r;
    int c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {
    private static int N, M, D, max;
    private static int[] archer;
    private static int[] order;
    private static boolean[] visited;
    private static int[][] game;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        D = scanner.nextInt();

        order = new int[3];
        visited = new boolean[M + 1];
        archer = new int[M + 1];
        for(int i = 1; i <= M; i++)
            archer[i] = i;

        game = new int[N + 2][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                game[i][j] = scanner.nextInt();

        DFS(0);

        System.out.println(max);

        scanner.close();
    }

    private static int[][] copyGame(){
        int[][] tmpGame = new int[N + 2][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                tmpGame[i][j] = game[i][j];
        return tmpGame;
    }

    private static boolean isAllDead(int[][] copiedGame){
        boolean check = true;
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                if(copiedGame[i][j] == 1){
                    check = false;
                    break;
                }
        return check;
    }

    private static void moveEnemies(int[][] copiedGame){
        for(int i = N; i >= 1; i--)
            for(int j = 1; j <= M; j++)
                if(copiedGame[i][j] == 1){
                    if(i == N)
                        copiedGame[i][j] = 0;
                    else{
                        copiedGame[i][j] = 0;
                        copiedGame[i + 1][j] = 1;
                    }
                }
    }

    private static int enemyDistance(Node archer, int x, int y){
        return Math.abs(archer.r - x) + Math.abs(archer.c - y);
    }

    private static void play(int[][] copiedGame){
        int killByArcher = 0;
        Node[] archers = new Node[3];

        int index = 0;
        for(int j = 1; j <= M; j++)
            if(copiedGame[N + 1][j] == -1)
                archers[index++] = new Node(N + 1, j);

        while (!isAllDead(copiedGame)) {
            boolean[][] indexToKill = new boolean[N + 1][M + 1];

            for(Node archer : archers){
                Node enemy = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
                int enemyD = Integer.MAX_VALUE;

                for(int i = 1; i <= N; i++)
                    for(int j = 1; j <= M; j++)
                        if(copiedGame[i][j] == 1){
                            if(enemyD > enemyDistance(archer, i, j)){
                                enemy.r = i;
                                enemy.c = j;
                                enemyD = enemyDistance(archer, i, j);
                            }
                            if(enemyD == enemyDistance(archer, i, j))
                                if(enemy.c > j){
                                    enemy.r = i;
                                    enemy.c = j;
                                }
                        }
                if(enemyD <= D)
                    indexToKill[enemy.r][enemy.c] = true;
            }
            for(int i = 1; i <= N; i++)
                for(int j = 1; j <= M; j++)
                    if(indexToKill[i][j]){
                        copiedGame[i][j] = 0;
                        killByArcher++;
                    }
            moveEnemies(copiedGame);
        }
        max = Math.max(max, killByArcher);
    }

    private static void DFS(int depth){
        if(depth == 3){
            int[][] tmpGame = copyGame();
            for(int index : order)
                tmpGame[N + 1][index] = -1;
            play(tmpGame);
            return;
        }
        for(int i = 1; i <= M; i++)
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
    }
}
