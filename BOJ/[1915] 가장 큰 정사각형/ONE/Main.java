import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, m, result = 0;
        int[][] dp;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        dp = new int[n + 1][m + 1];

        for(int i = 0; i < n; i ++){
            char[] input = scanner.next().toCharArray();
            for(int j = 0; j < m; j++){
                dp[i + 1][j + 1] = input[j] - '0';
                if(dp[i + 1][j + 1] != 0){
                    int temp = Math.min(dp[i][j], dp[i][j + 1]);
                    dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;

                    result = Math.max(result, dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(result * result);

        scanner.close();
    }
}
