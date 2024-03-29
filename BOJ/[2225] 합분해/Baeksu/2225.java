import java.util.Scanner;

public class Main {
    static long dp[][] = new long[201][201];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i=0; i<201 ;i++) {
            dp[i][0] = 1;
            dp[1][i] = 1;
        }
        for (int i=0;i<=N;i++)
            dp[2][i] = i+1;

        for (int i=3;i<=K;i++) {
            for (int j=1;j<=N;j++) {
                for (int k=0;k<=j;k++) {
                    dp[i][j] += dp[i-1][k]%1000000000;
                }
            }
        }

        System.out.println(dp[K][N]%1000000000);
    }
}
