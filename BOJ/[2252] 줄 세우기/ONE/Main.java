import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            int front = scanner.nextInt();
            int back = scanner.nextInt();

            graph[front].add(back);
            indegree[back]++;
        }

        for(int i = 1; i <= N; i++)
            if(indegree[i] == 0)   // if it has no edges
                queue.add(i);

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }
        scanner.close();
    }
}
