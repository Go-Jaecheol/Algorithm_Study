import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Puyo {
    char[][] field = new char[12][6];
    int[] x_ary = { -1, 0, 1, 0 };
    int[] y_ary = { 0, 1, 0, -1 };
    List<Pair> remove;
    Queue<Pair> queue;
    int[][] visited;

    public boolean searchChains() {
        remove = new LinkedList<>();
        queue = new LinkedList<>();
        visited = new int[12][6];
        boolean pop = false;

        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == '.') continue;
                if (visited[i][j] != 0) continue;

                char now = field[i][j];
                int cnt = 1;
                visited[i][j] = cnt++;
                queue.add(new Pair(i, j));
                remove.add(new Pair(i, j));

                while(!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    int curX = cur.x, curY = cur.y;

                    for (int t = 0; t < 4; t++) {
                        int ni = curX + x_ary[t], nj = curY + y_ary[t];

                        if (isBoundary(ni, nj)) continue;
                        if (visited[ni][nj] > 0) continue;

                        if (now == field[ni][nj]) {
                            visited[ni][nj] = cnt++;
                            queue.add(new Pair(ni, nj));
                            remove.add(new Pair(ni, nj));
                        }
                    }
                }
                if (cnt >= 5) {
                    pop = true;
                    for (Pair p : remove) {
                        field[p.x][p.y] = '.';
                    }
                }
                remove.clear();
            }
        }
        if (pop) {
            updateField();
        }
        return pop;
    }

    private void updateField() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (field[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (field[k][i] != '.') {
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private boolean isBoundary(int x, int y) {
        return x < 0 | x > 11 | y < 0 | y > 5;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int chains = 0;
        Puyo puyo = new Puyo();

        for (int i = 0; i < 12; i++) {
            line = br.readLine();
            for (int j = 0; j < 6; j++) {
                puyo.field[i][j] = line.charAt(j);
            }
        }

        while(puyo.searchChains()) {
            chains++;
        }

        System.out.println(chains);

        br.close();
    }
}