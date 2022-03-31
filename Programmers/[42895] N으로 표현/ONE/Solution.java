import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;

        if(N == number)
            return 1;

        Set<Integer>[] dp = new Set[9];

        for (int i = 0; i <= 8; i++)
            dp[i] = new HashSet<>();

        dp[1].add(N);

        for (int i = 2; i <= 8; i++){
            dp[i].add(makeNstr(N, i));

            for (int j = 1; j <= i - 1; j++)
                for(int k : dp[j])
                    for(int h : dp[i - j])
                        calculation(dp, i, k, h);


            if (dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private int makeNstr(int N, int i) {
        int num = 0;

        for(int n = 0; n < i; n++)
            num += N * (int)Math.pow(10, n);

        return num;
    }

    private void calculation( Set<Integer>[] dp, int i, int k, int h) {
        dp[i].add(k + h);
        dp[i].add(k - h);
        dp[i].add(k * h);
        if(h != 0)
            dp[i].add(k / h);
    }
}