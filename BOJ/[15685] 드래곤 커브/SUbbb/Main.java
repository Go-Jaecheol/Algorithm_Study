import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DragonMap {
    int[][] map = new int[101][101];
    int[] rangeX = { 1, 0, -1, 0 };
    int[] rangeY = { 0, -1, 0, 1 };

    public void drawDragonCurves(int x, int y, int d, int g) {
        List<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dirList.size() - 1; j >= 0; j--) {
                dirList.add(getCountClockDir(dirList.get(j)));
            }
        }

        map[x][y] = 1;
        for (Integer dir : dirList) {
            x += rangeX[dir];
            y += rangeY[dir];
            map[x][y] = 1;
        }
    }

    public int countSquares() {
        int counts = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
                    counts++;
                }
            }
        }

        return counts;
    }

    private int getCountClockDir(int dir) {
        return (dir + 1) % 4;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        DragonMap dragons = new DragonMap();

        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dragons.drawDragonCurves(info[0], info[1], info[2], info[3]);
        }
        br.close();

        System.out.println(dragons.countSquares());
    }
}