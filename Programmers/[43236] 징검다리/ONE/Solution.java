import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        return binSearch(distance, rocks, n);
    }

    private int binSearch(int distance, int[] rocks, int n) {
        long left = 1, right = distance, mid = 0;
        long answer = 0;

        while (left <= right) {
            int cnt = 0;
            int before = 0;

            mid = (left + right) / 2;

            for (int current : rocks) {
                if(current - before < mid)
                    cnt++;
                else
                    before = current;
            }

            if(distance - before < mid)
                cnt++;

            if (cnt <= n) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
            else
                right = mid - 1;
        }

        return (int)answer;
    }
}