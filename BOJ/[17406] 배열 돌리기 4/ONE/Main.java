import java.util.Scanner;

class Node{
    int r;
    int c;
    int s;
    public Node(int r, int c, int s){
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {
    private static int N, M, K, min = Integer.MAX_VALUE;
    private static int[][] A;
    private static int[] order;
    private static boolean[] visited;
    private static Node[] spins;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        order = new int[K];
        visited = new boolean[K];
        spins = new Node[K];

        A = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                A[i][j] = scanner.nextInt();

        for(int i = 0; i < K; i++){
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int s = scanner.nextInt();
            spins[i] = new Node(r, c, s);
        }

        DFS(0);

        System.out.println(min);

        scanner.close();
    }

    private static int[][] copyArray(){
        int[][] tmpArray = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                tmpArray[i][j] = A[i][j];
        return tmpArray;
    }

    private static void spinArray(int[][] ary, Node node){
        for(int i = 1; i <= node.s; i++){
            int temp = ary[node.r - i][node.c - i];

            for(int j = node.r - i; j < node.r + i; j++)
                ary[j][node.c - i] = ary[j + 1][node.c - i];

            for(int j = node.c - i; j < node.c + i; j++)
                ary[node.r + i][j] = ary[node.r + i][j + 1];

            for(int j = node.r + i; j > node.r - i; j--)
                ary[j][node.c + i] = ary[j - 1][node.c + i];

            for(int j = node.c + i; j > node.c - i + 1; j--)
                ary[node.r - i][j] = ary[node.r - i][j - 1];

            ary[node.r - i][node.c - i + 1] = temp;
        }
    }

    private static int minArray(int [][] ary){
        int tmpMin = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int temp = 0;
            for(int j = 1; j <= M; j++)
                temp += ary[i][j];
            tmpMin = Math.min(tmpMin, temp);
        }
        return tmpMin;
    }

    private static void DFS(int depth){
        if(depth == K){
            int[][] tmpArray = copyArray();
            for(int i = 0; i < K; i++)
                spinArray(tmpArray, spins[order[i]]);
            min = Math.min(min, minArray(tmpArray));
            return;
        }
        for(int i = 0; i < K; i++){
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
