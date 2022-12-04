import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> adjInfo;
    private static int[] prevInfo;
    private static int[] inDegree;
    private static int n;
    private static final String CANNOT_FIND = "?";
    private static final String NO_CONSISTENCY = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder answers = new StringBuilder();

        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            initialize();
            prevInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int index = 0; index < n; index++) {
                int current = prevInfo[index];

                fillAdj(current, index);
                inDegree[current] += index;
            }

            int newInfo = Integer.parseInt(br.readLine());

            for (int count = 0; count < newInfo; count++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (adjInfo.get(from).contains(to)) {
                    updateInfo(from, to);
                } else if (adjInfo.get(to).contains(from)) {
                    updateInfo(to, from);
                }
            }

            Queue<Integer> orders = new LinkedList<>();
            for (int index = 1; index <= n; index++) {
                if (inDegree[index] == 0) {
                    orders.add(index);
                }
            }

            // 0인 정점이 2개 이상이면 순위를 정할 수 없는 경우
            if (orders.size() > 1) {
                answers.append(CANNOT_FIND);
                continue;
            }

            int count = 0;
            StringBuilder order = new StringBuilder();
            while(!orders.isEmpty()) {
                int now = orders.poll();
                order.append(now).append(" ");
                count++;

                for (int next : adjInfo.get(now)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        orders.add(next);
                    }
                }
            }

            if (count != n) {
                answers.append(NO_CONSISTENCY);
            } else {
                answers.append(order);
            }
            answers.append("\n");
        }
        System.out.print(answers);
    }

    private static void initialize() {
        adjInfo = new ArrayList<>();
        for (int index = 0; index <= n; index++) {
            adjInfo.add(new ArrayList<>());
        }
        inDegree = new int[n + 1];
    }

    // 주어진 정점으로부터 다른 모든 정점으로의 인접 정보 추가
    private static void fillAdj(int from, int idx) {
        for (int index = idx + 1; index < n; index++) {
            adjInfo.get(from).add(prevInfo[index]);
        }
    }

    private static void updateInfo(int from, int to) {
        inDegree[from]++;
        inDegree[to]--;
        adjInfo.get(from).remove((Integer) to);
        adjInfo.get(to).add(from);
    }
}
