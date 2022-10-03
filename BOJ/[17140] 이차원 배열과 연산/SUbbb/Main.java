import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int k;
    static int[][] array = new int[100][100];

    static class Node implements Comparable<Node> {
        int number;
        int numCount;

        public Node(int number, int numCount) {
            this.number = number;
            this.numCount = numCount;
        }

        @Override
        public int compareTo(Node o) {
            if (this.numCount == o.numCount) return this.number - o.number;
            return this.numCount - o.numCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        int rowSize = 3;
        int colSize = 3;
        int answer;

        for (answer = 0; answer <= 100; answer++) {
            int[][] temp = new int[101][101];
            if (array[r][c] == k) break;

            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            int tmpSize = 0;
            int[] countNums;

            if (rowSize >= colSize) {
                for (int i = 0; i < rowSize; i++) {
                    countNums = new int[101];
                    for (int j = 0; j < colSize; j++)
                        if (array[i][j] != 0)
                            countNums[array[i][j]]++;

                    for (int n = 1; n < 101; n++)
                        if (countNums[n] != 0)
                            priorityQueue.add(new Node(n, countNums[n]));

                    tmpSize = Math.max(tmpSize, priorityQueue.size());

                    int idx = 0;
                    while(!priorityQueue.isEmpty()) {
                        if (idx == 100) break;
                        Node node = priorityQueue.poll();
                        temp[i][idx++] = node.number;
                        temp[i][idx++] = node.numCount;
                    }
                }

                colSize = tmpSize * 2;
                if (colSize > 99) colSize = 99;
            } else {
                for (int i = 0; i < colSize; i++) {
                    countNums = new int[101];
                    for (int j = 0; j < rowSize; j++)
                        if (array[j][i] != 0)
                            countNums[array[j][i]]++;

                    for (int n = 1; n < 101; n++)
                        if (countNums[n] != 0)
                            priorityQueue.add(new Node(n, countNums[n]));

                    tmpSize = Math.max(tmpSize, priorityQueue.size());

                    int idx = 0;
                    while(!priorityQueue.isEmpty()) {
                        if (idx == 100) break;
                        Node node = priorityQueue.poll();
                        temp[idx++][i] = node.number;
                        temp[idx++][i] = node.numCount;
                    }
                }

                rowSize = tmpSize * 2;
                if (rowSize > 99) rowSize = 99;
            }
            array = temp;
        }

        if (answer > 100) answer = -1;

        System.out.println(answer);
    }
}