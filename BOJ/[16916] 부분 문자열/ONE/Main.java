import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String origin = scanner.next();
        String sub = scanner.next();

        if (KMP(origin, sub))
            System.out.println(1);
        else
            System.out.println(0);

        scanner.close();
    }

    private static int[] makeTable(String pattern) {
        int len = pattern.length(), index = 0;
        int[] table = new int[len];

        for (int i = 1; i < len; i++) {
            // 일치하는 문자가 발생했을 때(idx > 0), 연속적으로 더 일치하지 않으면 index = table[index - 1] 로 돌려준다
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index))
                index = table[index - 1];

            if (pattern.charAt(i) == pattern.charAt(index)) {
                index += 1;
                table[i] = index;
            }
        }
        return table;
    }

    private static boolean KMP(String origin, String sub) {
        int originLen = origin.length(), subLen = sub.length();
        int[] table = makeTable(sub);

        int j = 0;

        for (int i = 0; i < originLen; i++) {
            while (j > 0 && origin.charAt(i) != sub.charAt(j))
                j = table[j - 1];

            if (origin.charAt(i) == sub.charAt(j)) {
                if(j == subLen - 1)
                    return true;
                j++;
            }
        }

        return false;
    }
}