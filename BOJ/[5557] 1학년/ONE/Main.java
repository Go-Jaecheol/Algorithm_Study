import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] arr;
    private static long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N + 1];
        dp = new long[N][21];

        for(int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j <= 20; j++)
                dp[i][j] = -1;

        System.out.println(operation(0, arr[0]));

        scanner.close();
    }

    private static long operation(int idx, int sum){
        if(sum < 0 || sum > 20)
            return 0;

        if(idx == N - 2){
            if(sum == arr[N - 1])
                return 1;
            return 0;
        }

        if(dp[idx][sum] != -1)
            return dp[idx][sum];

        dp[idx][sum] = 0;

        return dp[idx][sum] += operation(idx + 1, sum + arr[idx + 1]) + operation(idx + 1, sum - arr[idx + 1]);
    }
}
