import java.util.LinkedList;
import java.util.Queue;

class Paper {
    int priority;
    int index;

    public Paper(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }

    public boolean isMyPaper(int location) {
        return this.index == location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> queue = initQueue(priorities);

        while (!queue.isEmpty()) {
            Paper first = queue.poll();
            if (!isMostImportant(queue, first)){
                queue.add(first);
                continue;
            }
            answer++;
            if(first.isMyPaper(location))
                break;
        }

        return answer;
    }

    public Queue<Paper> initQueue(int[] priorities) {
        Queue<Paper> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++)
            queue.add(new Paper(priorities[i],i));

        return queue;
    }

    private boolean isMostImportant(Queue<Paper> queue, Paper current) {
        for (Paper paper : queue)
            if(current.priority < paper.priority)
                return false;
        return true;
    }
}