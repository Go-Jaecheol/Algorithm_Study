import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, numbers[0]);
        dfs(numbers, 0, target, -numbers[0]);
        return answer;
    }

    private void dfs(int[] numbers, int idx, int target, int sum) {
        if (idx + 1 == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(numbers, idx + 1, target, sum + numbers[idx + 1]);
        dfs(numbers, idx + 1, target, sum - numbers[idx + 1]);
    }
}