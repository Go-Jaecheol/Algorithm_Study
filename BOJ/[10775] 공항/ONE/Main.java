import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int G = scanner.nextInt();
        int P = scanner.nextInt();
        int cnt = 0;

        parent = new int[G+1];

        for(int i = 1; i <= G; i++)
            parent[i] = i;

        for(int j = 0; j < P; j++){
            int g = scanner.nextInt();
            int emptyGate = find(g);

            if(emptyGate == 0)
                break;
            cnt++;
            union(emptyGate,emptyGate - 1);
        }
        System.out.println(cnt);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }
}
