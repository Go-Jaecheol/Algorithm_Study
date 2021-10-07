import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Work implements Comparable<Work> {
    int num;

    public Work(int num){
        this.num = num;
    }

    @Override
    public int compareTo(Work o) {
        return this.num - o. num;
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Work> queue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int N, M;

        N = scanner.nextInt();
        M = scanner.nextInt();

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            int front = scanner.nextInt();
            int back = scanner.nextInt();

            graph[front].add(back);
            indegree[back]++;
        }

        for(int i = 1; i <= N; i++)
            if(indegree[i] == 0)
                queue.add(new Work(i));

        while (!queue.isEmpty()){
            Work current = queue.poll();
            System.out.print(current.num + " ");

            for(int i = 0; i < graph[current.num].size(); i++){
                int next = graph[current.num].get(i);
                indegree[next]--;

                if(indegree[next] == 0)
                    queue.add(new Work(next));
            }
        }

        scanner.close();
    }
}
