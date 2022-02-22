class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if(isChangedOneAlpha(begin, words[i]))
                answer = Math.min(answer, DFS(words[i], target, words, i, visited, 1));
        }

        if(answer == words.length + 1)
            return 0;

        return answer;
    }

    private boolean isChangedOneAlpha(String current, String next) {
        int count = 0;
        for (int i = 0; i < current.length(); i++)
            if(current.charAt(i) != next.charAt(i)){
                count++;
                if (count > 1)
                    return false;
            }
        return true;
    }

    private int DFS(String current, String target, String[] words, int index, boolean[] visited, int cnt) {
        if(current.equals(target))
            return cnt;

        if(visited[index])
            return cnt;
        
        visited[index] = true;
        
        int result = 0;
        for (int i = 0; i < words.length; i++)
            if(index != i && isChangedOneAlpha(current, words[i]) && !visited[i])
                result = DFS(words[i], target, words, i, visited, cnt + 1);
        
        return result;
    }
}