import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        int len = origin.length(), max = 0;

        for (int i = 0; i < len; i++)
            max = Math.max(max, maxSub(origin.substring(i, len)));

        System.out.println(max);

        scanner.close();
    }

    private static int maxSub(String sub) {
        int j = 0, len = sub.length(), max = 0;
        int[] table = new int[len];

        for (int i = 1; i < len; i++) {
            while (j > 0 && sub.charAt(i) != sub.charAt(j))
                j = table[j - 1];
            if (sub.charAt(i) == sub.charAt(j)) {
                max = Math.max(max, table[i] = ++j);
            }
        }
        return max;
    }
}
