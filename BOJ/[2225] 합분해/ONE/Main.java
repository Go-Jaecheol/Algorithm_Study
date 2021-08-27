import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, K;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        for(int i = 1; i <= K; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= K; i++)
            for(int j = 1; j <= N; j++)
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;

        System.out.println(dp[K][N]);
    }
}
