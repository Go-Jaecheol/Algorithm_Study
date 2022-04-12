import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited;
        int answer = words.length + 1;

        for (int i = 0; i < words.length; i++) {
            visited = new boolean[words.length];
            if (isOneCharDiff(begin, words[i]))
                answer = Math.min(answer, dfs(words[i], target, words, visited, 1, i));
        }

        if (answer == words.length + 1) return 0;

        return answer;
    }

    private int dfs(String begin, String target, String[] words, boolean[] visited, int count, int idx) {
        if (begin.equals(target) || visited[idx]) return count;

        visited[idx] = true;
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            if (idx != i && !visited[i] && isOneCharDiff(begin, words[i]))
                ans = dfs(words[i], target, words, visited, count + 1, i);
        }

        return ans;
    }

    private boolean isOneCharDiff(String str1, String str2) {
        int count = 0;

        for (int i = 0; i < str1.length() && count < 2; i++)
            if (str1.charAt(i) != str2.charAt(i)) count++;

        return count == 1;
    }
}