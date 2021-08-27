import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i = 0; i < N; i++){
            int a, b, c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if(i == 0){ // 처음 입력은 저장
                maxDp[0] = minDp[0] = a;
                maxDp[1] = minDp[1] = b;
                maxDp[2] = minDp[2] = c;
            }

            else {
                // 최댓값의 DP
                int max_tmp_0 = maxDp[0], max_tmp_1 = maxDp[1], max_tmp_2 = maxDp[2];
                maxDp[0] = a + Math.max(max_tmp_0, max_tmp_1);
                maxDp[1] = b + Math.max(Math.max(max_tmp_0, max_tmp_1), max_tmp_2);
                maxDp[2] = c + Math.max(max_tmp_1, max_tmp_2);
                // 최솟값의 DP
                int min_tmp_0 = minDp[0], min_tmp_1 = minDp[1], min_tmp_2 = minDp[2];
                minDp[0] = a + Math.min(min_tmp_0, min_tmp_1);
                minDp[1] = b + Math.min(Math.min(min_tmp_0, min_tmp_1), min_tmp_2);
                minDp[2] = c + Math.min(min_tmp_1, min_tmp_2);
            }
        }
        Arrays.sort(maxDp);
        Arrays.sort(minDp);

        System.out.println(maxDp[2] + " " + minDp[0]);

        scanner.close();
    }
}
