import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<List<Integer>> adjs;
    private static int[] inDegree;
    private static Queue<Integer> problems;

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

            adjs.get(from).add(to);
            inDegree[to]++;
        }

        for (int index = 1; index <= N; index++) {
            if (inDegree[index] == 0) {
                problems.add(index);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!problems.isEmpty()) {
            int problem = problems.poll();
            lookAdjacent(problem);
            answer.append(problem).append(" ");
        }

        System.out.println(answer);
    }

    private static void init() {
        inDegree = new int[N + 1];
        adjs = new ArrayList<>();
        problems = new PriorityQueue<>();
        for (int index = 0; index <= N; index++) {
            adjs.add(new ArrayList<>());
        }
    }

    private static void lookAdjacent(int problem) {
        for (int next : adjs.get(problem)) {
            if (inDegree[next] > 0) {
                inDegree[next]--;
            }
            if (inDegree[next] == 0) {
                problems.add(next);
            }
        }
    }
}
