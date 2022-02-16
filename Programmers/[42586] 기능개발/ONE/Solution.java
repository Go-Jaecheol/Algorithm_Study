import java.util.*;

class Work {
    int progress;
    int speed;

    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        ArrayList<Integer> cntAry = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++)
            queue.add(new Work(progresses[i], speeds[i]));

        while (!queue.isEmpty()) {
            int count = 0;
            develop(queue);

            Work first = queue.peek();
            if (first.progress >= 100){
                queue.poll();
                count++;
                while (!queue.isEmpty()) {
                    if(queue.peek().progress < 100)
                        break;
                    queue.poll();
                    count++;
                }
            }
            if(count > 0)
                cntAry.add(count);
        }

        return changeToIntAry(cntAry);
    }

    private void develop(Queue<Work> queue) {
        for (Work work : queue)
            work.progress += work.speed;
    }

    private int[] changeToIntAry(ArrayList<Integer> cntAry) {
        int[] answer = new int[cntAry.size()];

        for (int i = 0; i < cntAry.size(); i++)
            answer[i] = cntAry.get(i);

        return answer;
    }
}