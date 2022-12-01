import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer>[] adjs;
    private static List<Integer> studentOrder = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init();

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjs[from].add(to);
        }

        for (int index = 1; index <= N; index++) {
            if (!visited[index]) {
                dfs(index);
            }
        }

        Collections.reverse(studentOrder);
        print();
    }

    private static void init() {
        visited = new boolean[N + 1];
        adjs = new ArrayList[N + 1];
        for (int index = 0; index <= N; index++) {
            adjs[index] = new ArrayList<>();
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int next : adjs[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }

        studentOrder.add(start);
    }

    private static void print() {
        StringJoiner sj = new StringJoiner(" ");
        studentOrder.forEach(student -> sj.add(String.valueOf(student)));
        System.out.println(sj);
    }
}
