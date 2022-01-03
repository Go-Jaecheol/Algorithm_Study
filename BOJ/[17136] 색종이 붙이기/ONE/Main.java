import java.util.Scanner;

public class Main {
    private static int min = Integer.MAX_VALUE;
    private static int[] papers = {0, 5, 5, 5, 5, 5};
    private static int[][] board = new int[10][10];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                board[i][j] = scanner.nextInt();

        DFS(0, 0, 0);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);

        scanner.close();
    }

    private static void attach(int x, int y, int size, int state){
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                board[i][j] = state;
    }

    private static boolean canAttach(int x, int y, int size){
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++){
                if(i > 9 || j > 9)
                    return false;
                if(board[i][j] != 1)
                    return false;
            }
        return true;
    }

    private static void DFS(int x, int y, int count){
        if(x == 9 && y > 9){
            min = Math.min(min, count);
            return;
        }

        if(count > min)
            return;

        if(y > 9){
            DFS(x + 1, 0, count);
            return;
        }

        if(board[x][y] == 1){
            for(int size = 5; size >= 1; size--)
                if(papers[size] > 0 && canAttach(x, y, size)){
                    papers[size]--;
                    attach(x, y, size, 0);
                    DFS(x, y + 1, count + 1);
                    attach(x, y, size, 1);
                    papers[size]++;
                }
        }
        else
            DFS(x, y + 1, count);
    }
}
