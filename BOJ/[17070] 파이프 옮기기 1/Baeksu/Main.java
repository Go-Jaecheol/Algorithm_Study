import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] ary;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        ary = new int[N][N];
        dp = new int[N][N][3];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;

        System.out.println(dp());
    }

    private static int dp() {
        for (int i=0;i<N;i++) {
            for (int j=2;j<N;j++) {
                if (ary[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];

                if (i == 0) continue;
                dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];

                if (ary[i-1][j] == 1 || ary[i][j-1] == 1) continue;
                dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        return dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
    }
}