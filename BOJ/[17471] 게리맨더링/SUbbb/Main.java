import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dosi {
    ArrayList<Integer>[] dosi;
    int[] population;
    int[] area;
    boolean[] visited;
    int size;
    int answer = Integer.MAX_VALUE;

    public Dosi(int N) {
        dosi = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            dosi[i] = new ArrayList<>();
        }
        area = new int[N + 1];
        size = N;
    }

    public int searchDivision() {
        dfs(1);
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    private void dfs(int n) {
        if (n == size + 1) {
            int pop1=0, pop2=0;
            for (int i = 1; i <= size; i++) {
                if (area[i] == 1) pop1 += population[i-1];
                else pop2 += population[i-1];
            }

            visited = new boolean[size + 1];
            int cnt = 0;
            for (int i = 1; i <= size; i++) {
                if (!visited[i]) {
                    bfs(i, area[i]);
                    cnt++;
                }
            }

            if (cnt == 2) answer = Math.min(answer, Math.abs(pop1 - pop2));
            return;
        }
        area[n] = 1;
        dfs(n + 1);
        area[n] = 2;
        dfs(n + 1);
    }

    private void bfs(int idx, int areaN) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < dosi[now].size(); i++) {
                int next = dosi[now].get(i);
                if(area[next] == areaN && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line;

        Dosi d = new Dosi(N);
        d.population = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(line[0]); j++) {
                d.dosi[i+1].add(Integer.parseInt(line[j+1]));
            }
        }

        System.out.println(d.searchDivision());

        br.close();
    }
}