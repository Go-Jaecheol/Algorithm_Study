import java.util.Scanner;

public class Main {
    private static int N, max;
    private static int[] player = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] order = new int[10];
    private static boolean[] visited = new boolean[10];
    private static int[][] innings;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        innings = new int[N + 1][10];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= 9; j++)
                innings[i][j] = scanner.nextInt();

        order[4] = player[1]; // batter number 4 is one;
        visited[1] = true;

        DFS(1);

        System.out.println(max);

        scanner.close();
    }

    private static int baseball(){
        int score = 0, temp = 1, inningTemp = 1, outTemp = 0;
        boolean[] base = new boolean[3];

        while (inningTemp <= N){
            switch (innings[inningTemp][order[temp]]){
                case 0:
                    outTemp++;
                    break;
                case 1:
                    if(base[2]){
                        score++;
                        base[2] = false;
                    }
                    if(base[1]){
                        base[2] = true;
                        base[1] = false;
                    }
                    if(base[0]){
                        base[1] = true;
                        base[0] = false;
                    }
                    base[0] = true;
                    break;
                case 2:
                    if(base[2]){
                        score++;
                        base[2] = false;
                    }
                    if(base[1]){
                        score++;
                        base[1] = false;
                    }
                    if(base[0]){
                        base[2] = true;
                        base[0] = false;
                    }
                    base[1] = true;
                    break;
                case 3:
                    for(int i = 0; i < 3; i++)
                        if(base[i]){
                            score++;
                            base[i] = false;
                        }
                    base[2] = true;
                    break;
                case 4:
                    for(int i = 0; i < 3; i++)
                        if(base[i]){
                            score++;
                            base[i] = false;
                        }
                    score++;
                    break;
            }
            if(outTemp == 3){
                inningTemp++;
                outTemp = 0;
                for(int i = 0; i < 3; i++)
                    base[i] = false;
            }
            temp = (temp % 9) + 1;
        }
        return score;
    }

    private static void DFS(int depth){
        if(depth == 9){
            int temp = 45;
            for(int i = 1; i <= 8; i++)
                temp -= order[i];
            order[depth] = temp;
            max = Math.max(max, baseball());
            return;
        }
        for(int i = 2; i <= 9; i++){
            if(!visited[i]){
                visited[i] = true;
                if(depth != 4)
                    order[depth] = player[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
