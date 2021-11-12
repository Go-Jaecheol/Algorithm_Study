import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0; i < T; i++){
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] time = new int[N + 1];
            int[] minTime = new int[N + 1];

            int[] indegree = new int[N + 1];
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            Queue<Integer> queue = new LinkedList<>();

            for(int j = 0; j <= N; j++)
                graph[j] = new ArrayList<>();

            for(int j = 1; j <= N; j++)
                time[j] = scanner.nextInt();

            for(int j = 0; j < K; j++){
                int X = scanner.nextInt();
                int Y = scanner.nextInt();

                graph[X].add(Y);
                indegree[Y]++;
            }

            for(int j = 1; j <= N; j++)
                if(indegree[j] == 0)
                    queue.add(j);

            while (!queue.isEmpty()){
                int current = queue.poll();

                for(int back : graph[current]){
                    minTime[back] = Math.max(minTime[back], minTime[current] + time[current]);
                    indegree[back]--;

                    if(indegree[back] == 0)
                        queue.add(back);
                }
            }

            for(int j = 1; j <= N; j++)
                minTime[j] += time[j];

            int W = scanner.nextInt();
            System.out.println(minTime[W]);
        }
        scanner.close();
    }
}
