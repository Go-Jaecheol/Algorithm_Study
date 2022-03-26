import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        int count = 1;
        int head = getDays(progresses[0], speeds[0]);

        for (int i = 1; i < progresses.length; i++) {
            int days = getDays(progresses[i], speeds[i]);
            if (head < days) {
                head = days;
                answers.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        answers.add(count);

        return answers.stream().mapToInt(i -> i).toArray();
    }

    private int getDays(int progress, int speed) {
        int remain = (100 - progress) % speed;
        int days = (100 - progress) / speed;
        return remain > 0 ? days + 1 : days;
    }
}