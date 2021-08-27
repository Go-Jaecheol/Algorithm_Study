import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int dp[][] = new int[N + 1][M + 1];
        int max = 0, temp;

        if (N == 1 && M == 1) {
            System.out.println("1");
            return;
        }

        for (int i = 1; i <= N; i++) {
            String s = sc.next();
            for (int j = 1; j <= M; j++) {
                temp = s.charAt(j - 1) - '0';
                if (i == 1 && j == 1)
                    dp[i][j] = temp;
                else {
                    if (temp == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], (Math.min(dp[i - 1][j], dp[i][j - 1]))) + 1;
                        if (max < dp[i][j])
                            max = dp[i][j];
                    }
                }
            }
        }

        System.out.println(max * max);
    }
}
