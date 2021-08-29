import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] ary = new int[N][3];
        int[] dp1 = new int[3];
        int[] dp2 = new int[3];
        int[] temp = new int[6];

        sc.nextLine();

        for (int i = 0;i<N;i++) {
            String s = sc.nextLine();
            s = s.replace(" ", "");
            for (int j = 0;j<3;j++) {
                ary[i][j] = s.charAt(j) - '0';
                if (i == 0)
                    dp1[j] = dp2[j] = ary[0][j];
            }
        }

        for (int i=1;i<N;i++) {
            for (int j=0;j<3;j++) {
                if (j == 0) {
                    temp[0] = Math.max(dp1[0], dp1[1]) + ary[i][j];
                    temp[3] = Math.min(dp2[0], dp2[1]) + ary[i][j];
                } else if (j == 1) {
                    temp[1] = Math.max(dp1[0], Math.max(dp1[1], dp1[2])) + ary[i][j];
                    temp[4] = Math.min(dp2[0], Math.min(dp2[1], dp2[2])) + ary[i][j];
                } else {
                    temp[2] = Math.max(dp1[1], dp1[2]) + ary[i][j];
                    temp[5] = Math.min(dp2[1], dp2[2]) + ary[i][j];
                }
            }
            dp1[0] = temp[0];
            dp1[1] = temp[1];
            dp1[2] = temp[2];
            dp2[0] = temp[3];
            dp2[1] = temp[4];
            dp2[2] = temp[5];
        }
        Arrays.sort(dp1);
        Arrays.sort(dp2);

        System.out.print(dp1[2] + " " + dp2[0]);

        sc.close();
    }
}
