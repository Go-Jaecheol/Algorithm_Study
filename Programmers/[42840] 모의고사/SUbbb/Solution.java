import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] std1 = {1,2,3,4,5};
        int[] std2 = {2,1,2,3,2,4,2,5};
        int[] std3 = {3,3,1,1,2,2,4,4,5,5};

        int[] scores = new int[3];

        scores[0] = countScore(answers, std1);
        scores[1] = countScore(answers, std2);
        scores[2] = countScore(answers, std3);

        int max = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (scores[i] == max)
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int countScore(int[] answers, int[] std) {
        int score = 0;
        for (int i = 0, idx = 0; i < answers.length; i++) {
            if (idx >= std.length)
                idx = idx % std.length;
            if (std[idx++] == answers[i])
                score++;
        }
        return score;
    }
}