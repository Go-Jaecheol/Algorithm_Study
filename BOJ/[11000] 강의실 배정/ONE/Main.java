import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][2];
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int j = 0; j < N; j++){
            int end = arr[j][1];
            if(!pqueue.isEmpty() && pqueue.peek() <= arr[j][0])
                pqueue.remove();
            pqueue.add(end);
        }

        System.out.println(pqueue.size());

        scanner.close();
    }
}
