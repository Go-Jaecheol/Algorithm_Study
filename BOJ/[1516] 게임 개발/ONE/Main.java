import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Building{
    int num;
    int time;

    public Building(int num, int time){
        this.num = num;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int[] minTime;
        int[] indegree;
        ArrayList<Integer>[] graph;
        ArrayList<Building> buildings = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        N = scanner.nextInt();
        minTime = new int[N + 1];
        indegree = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        buildings.add(new Building(0,0)); // add 0 index building

        for (int i = 1; i <= N; i++) {
            int time = scanner.nextInt();
            int preBuildingNum = scanner.nextInt();

            if (preBuildingNum == -1) {
                buildings.add(new Building(i, time));
                continue;
            }

            buildings.add(new Building(i, time));
            while (preBuildingNum != -1) {
                graph[preBuildingNum].add(i);
                indegree[i]++;
                preBuildingNum = scanner.nextInt();
            }
        }

        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0)
                queue.add(i);

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;
                minTime[next] = Math.max(minTime[next], minTime[current] + buildings.get(current).time);

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.println(buildings.get(i).time + minTime[i]);

        scanner.close();
    }
}
