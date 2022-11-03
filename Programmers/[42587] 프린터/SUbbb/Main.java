import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Pair {
    int index;
    int priority;

    public Pair(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    static Queue<Pair> taskQueue = new LinkedList<>();
    static List<Integer> priorityList = new ArrayList<>();

    public int solution(int[] priorities, int location) {
        for (int index = 0; index < priorities.length; index++) {
            int priority = priorities[index];
            taskQueue.add(new Pair(index, priority));
            priorityList.add(priority);
        }

        priorityList.sort(Comparator.reverseOrder());

        int index = 0;
        int maxPriority = priorityList.get(index);
        int answer = 0;
        while (!taskQueue.isEmpty()) {
            Pair current = taskQueue.poll();

            if (current.priority == maxPriority) {
                if (++index < priorityList.size())
                    maxPriority = priorityList.get(index);
                answer++;
                if (current.index == location) {
                    break;
                }
            }

            taskQueue.add(current);
        }

        return answer;
    }
}