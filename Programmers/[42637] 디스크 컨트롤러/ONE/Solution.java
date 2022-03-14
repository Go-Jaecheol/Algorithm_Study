import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    int requestTime;
    int runTime;

    public Task(int requestTime, int runTime) {
        this.requestTime = requestTime;
        this.runTime = runTime;
    }
}

class Solution {

    public int solution(int[][] jobs) {
        int time = 0;
        int count = 0;
        int sum = 0;

        PriorityQueue<Task> readyQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.requestTime));

        for (int[] job : jobs)
            readyQueue.add(new Task(job[0], job[1]));

        PriorityQueue<Task> runQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.runTime));

        while (count < jobs.length) {
            while (!readyQueue.isEmpty() && time >= readyQueue.peek().requestTime)
                runQueue.add(readyQueue.poll());

            if(!runQueue.isEmpty()){
                Task current = runQueue.poll();
                sum += current.runTime + (time - current.requestTime);
                time += current.runTime;
                count++;
            }
            else
                time++;
        }
        return sum / count;
    }
}