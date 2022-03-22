import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dosi {
    int N;
    int minDiff = Integer.MAX_VALUE;
    int[][] map;
    int[][] copyMap;
    int[] rangeX = { -1, 0, 1, 0 };
    int[] rangeY = { 0, 1, 0, -1 };

    public Dosi(int N) {
        this.N = N;
        map = new int[N + 1][N + 1];
    }

    public int vote() {
        for (int d1 = 1; d1 <= N; d1++) {
            for (int d2 = 1; d2 <= N; d2++) {
                for (int x = 1; x <= N; x++) {
                    for (int y = 1; y <= N; y++) {
                        if (!(x + d1 + d2 <= N && y - d1 >= 1 && y + d2 <= N)) continue;
                        copyMap = new int[N + 1][N + 1];
                        popSum1(x, y, d1);
                        popSum2(x, y ,d2);
                        popSum3(x, y, d1, d2);
                        popSum4(x, y, d1, d2);
                        setLine(x, y, d1, d2);
                        sum();
                    }
                }
            }
        }
        return minDiff;
    }

    private void sum() {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] popSum = new int[6];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                popSum[copyMap[i][j]]+=map[i][j];
            }
        }
        for(int i=1; i<=5; i++) {
            max = Math.max(max, popSum[i]);
            min = Math.min(min, popSum[i]);
        }
        minDiff = Math.min(minDiff, max-min);
    }

    private void setLine(int x, int y, int d1, int d2) {
        for(int i = 0; i <= d1; i++) {
            copyMap[x+i][y-i] = 5;
        }
        for(int i = 0; i <= d2; i++) {
            copyMap[x+i][y+i] = 5;
        }
        for(int i = 0; i <= d2; i++) {
            copyMap[x+d1+i][y-d1+i] = 5;
        }
        for(int i = 0; i <= d1; i++) {
            copyMap[x+d2+i][y+d2-i] = 5;
        }
        for(int alpha = 0; alpha < d1; alpha++) {
            isConnected(x+alpha+1, y-alpha);
        }
        for(int alpha = 0; alpha < d2; alpha++) {
            isConnected(x+alpha+1, y+alpha);
        }
    }

    private void isConnected(int x, int y) {
        copyMap[x][y] = 5;

        for(int i=0; i<4; i++) {
            int nx = x + rangeX[i];
            int ny = y + rangeY[i];
            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
            if (copyMap[nx][ny] != 5) isConnected(nx,ny);
        }
    }

    private void popSum1(int x, int y, int d1) {
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                copyMap[i][j] = 1;
            }
        }
    }

    private void popSum2(int x, int y, int d2) {
        for (int i = 1; i <= x + d2; i++) {
            for (int j = y + 1; j <= N; j++) {
                copyMap[i][j] = 2;
            }
        }
    }

    private void popSum3(int x, int y, int d1, int d2) {
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                copyMap[i][j] = 3;
            }
        }
    }

    private void popSum4(int x, int y, int d1, int d2) {
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = y - d1 + d2; j <= N; j++) {
                copyMap[i][j] = 4;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Dosi dosi = new Dosi(N);
        String[] line;

        for (int i = 1; i <= N; i++) {
            line = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                dosi.map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        System.out.println(dosi.vote());

        br.close();
    }
}