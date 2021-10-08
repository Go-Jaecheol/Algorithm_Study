import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            int num = scanner.nextInt();
            int front = scanner.nextInt();
            for(int j = 0; j < num - 1; j++){
                int back = scanner.nextInt();
                indegree[back]++;
                graph[front].add(back);
                front = back;
            }
        }

        for(int i = 1; i <= N; i++)
            if (indegree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        if(answer.size() == N)
            for (int num : answer)
                System.out.println(num);
        else
            System.out.println(0);

        scanner.close();
    }
}
