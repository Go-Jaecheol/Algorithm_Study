import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        Arrays.sort(citations);

        for (int i = citations[n - 1]; i >= 0; i--) {
            if (isHindex(citations, i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    private boolean isHindex(int[] citations, int H) {
        int s = 0, l = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= H) l++;
            if (citations[i] <= H) s++;
        }

        if (l >= H && s <= H) return true;
        return false;
    }
}