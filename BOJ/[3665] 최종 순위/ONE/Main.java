import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();

        for(int i = 0; i < T; i++){
            ArrayList<Integer> answer = new ArrayList<>();
            ranking(answer);

            if(answer.size() == n){
                for (Integer integer : answer)
                    System.out.print(integer + " ");
                System.out.println();
            }
            else
                System.out.println("IMPOSSIBLE");
        }
        scanner.close();
    }

    private static int findIndex(ArrayList<Integer> arrayList, int num){
        int index = -1;
        for(int i = 0; i < arrayList.size(); i++)
            if(arrayList.get(i) == num)
                index = i;
        return index;
    }

    private static void changeRank(ArrayList<Integer>[] graph, int[] indegree, int a, int b){
        int index = findIndex(graph[a], b);

        if(index == -1){ // if b is forwarder than a
            index = findIndex(graph[b], a);
            graph[b].remove(index);
            indegree[a]--;
            graph[a].add(b);
            indegree[b]++;
        }
        else{
            graph[a].remove(index);
            indegree[b]--;
            graph[b].add(a);
            indegree[a]++;
        }
    }

    private static void ranking(ArrayList<Integer> answer){
        int m;
        int[] previousRank;
        int[] indegree;
        ArrayList<Integer>[] graph;
        Queue<Integer> queue = new LinkedList<>();

        n = scanner.nextInt();
        previousRank = new int[n];
        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < n; i++)
            previousRank[i] = scanner.nextInt();

        for(int i = 0; i < n - 1; i++){
            int front = previousRank[i];
            for(int j = i + 1; j < n; j++){
                int back = previousRank[j];
                graph[front].add(back);
                indegree[back]++;
            }
        }

        m = scanner.nextInt();

        for(int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            changeRank(graph, indegree, a, b);
        }

        for(int i = 0; i < n; i++)
            if(indegree[previousRank[i]] == 0)
                queue.add(previousRank[i]);

        while(!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }
    }
}
