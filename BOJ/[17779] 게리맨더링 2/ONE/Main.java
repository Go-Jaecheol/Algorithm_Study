import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N, result = Integer.MAX_VALUE;
    private static int[][] district;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        district = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                district[i][j] = scanner.nextInt();

        for(int x = 1; x <= N; x++)
            for (int y = 1; y <= N; y++)
                for(int d1 = 1; x + 1 + d1 <= N && y - d1 >= 1; d1++)
                    for(int d2 = 1; x + d1 + d2 <= N && y + d2 <= N; d2++)
                        result = Math.min(result, population(x, y, d1, d2));

        System.out.println(result);

        scanner.close();
    }

    private static int population(int x, int y, int d1, int d2){
        // 5번 선거구 표시
        boolean[][] isDistrict5 = new boolean[N + 1][N + 1];
        // 5번 구역 사각형이 위에서 밑으로 내려감
        int size = 1;  // 한줄의 가로 크기
        // 시작 col
        int currentCol = y;

        // 사각형의 높이는 x ~ x + d1 + d2
        for(int r = 0; r <= d1 + d2; r++){
            // 가로 길이만큼 표시
            for(int c = 0; c < size; c++)
                isDistrict5[x + r][currentCol + c] = true;

            // 시작열 정해주기
            // 행이 d1만큼 내려오지 않았다면 시작열은 한칸 왼쪽으로
            if (r < d1)
                currentCol--;
                // d1보다 더 많이 내려왔다면 시작열을 한칸 오른쪽으로
            else
                currentCol++;

            // 가로가 커지는 중이면
            if (r < d1 && r < d2)
                size += 2;
            // 가로가 작아지는 중이면
            else if (r >= d1 && r >= d2)
                size -= 2;
        }

        int[] distSum = new int[6];

        for(int r = 1; r <= N; r++)
            for(int c = 1; c <= N; c++){
                // 5번 선거구
                if(isDistrict5[r][c])
                    distSum[5] += district[r][c];

                // 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
                else if(1 <= r && r < x + d1 && 1 <= c && c <= y)
                    distSum[1] += district[r][c];

                // 2번 선거구: 1 ≤ r ≤ x + d2, y < c ≤ N
                else if(1 <= r && r <= x+d2 && y < c)
                    distSum[2] += district[r][c];

                // 3번 선거구: x + d1 ≤ r ≤ N, 1 ≤ c < y - d1 + d2
                else if(x+d1 <= r && r <= N && 1 <= c && c < y - d1 + d2)
                    distSum[3] += district[r][c];

                // 4번 선거구: x + d2 < r ≤ N, y - d1 + d2 ≤ c ≤ N
                else distSum[4] += district[r][c];
            }

        Arrays.sort(distSum);

        return distSum[5] - distSum[1];
    }
}
