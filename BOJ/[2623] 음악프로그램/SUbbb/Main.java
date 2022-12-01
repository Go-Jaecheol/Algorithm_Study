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
            int[] singers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int singer = 1; singer < singers[0]; singer++) {
                int from = singers[singer];
                int to = singers[singer + 1];

                adjs.get(from).add(to);
                inDegree[to]++;
            }
        }

        for (int index = 1; index <= N; index++) {
            if (inDegree[index] == 0) {
                problems.add(index);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!problems.isEmpty()) {
            int problem = problems.poll();
            lookAdjacent(problem);
            answer.add(problem);
        }

        if (answer.size() != N) {
            System.out.println(0);
            return;
        }

        answer.forEach(System.out::println);
    }

    private static void init() {
        inDegree = new int[N + 1];
        adjs = new ArrayList<>();
        problems = new LinkedList<>();
        for (int index = 0; index <= N; index++) {
            adjs.add(new ArrayList<>());
        }
    }

    private static void lookAdjacent(int problem) {
        for (int next : adjs.get(problem)) {
            inDegree[next]--;
            if (inDegree[next] == 0) {
                problems.add(next);
            }
        }
    }
}
