import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> adjInfo;
    private static int[] minTimes;
    private static int[] setupTime;
    private static int[] inDegree;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        initialize();

        for (int index = 1; index <= n; index++) {
            int[] infos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            setupTime[index] = infos[0];

            for (int idx = 1; idx < infos.length; idx++) {
                int from = infos[idx];
                if (from == -1) {
                    break;
                }
                adjInfo.get(from).add(index);
                inDegree[index]++;
            }
        }

        Queue<Integer> orders = new LinkedList<>();
        for (int index = 1; index <= n; index++) {
            if (inDegree[index] == 0) {
                orders.add(index);
                minTimes[index] = setupTime[index];
            }
        }

        while(!orders.isEmpty()) {
            int now = orders.poll();

            for (int next : adjInfo.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    orders.add(next);
                }
                minTimes[next] = Math.max(minTimes[now] + setupTime[next], minTimes[next]);
            }
        }

        print();
    }

    private static void initialize() {
        adjInfo = new ArrayList<>();
        for (int index = 0; index <= n; index++) {
            adjInfo.add(new ArrayList<>());
        }
        minTimes = new int[n + 1];
        setupTime = new int[n + 1];
        inDegree = new int[n + 1];
    }

    private static void print() {
        for (int index = 1; index <= n; index++) {
            System.out.println(minTimes[index]);
        }
    }
}