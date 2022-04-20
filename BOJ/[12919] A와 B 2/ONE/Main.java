import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        DFS(S, T, true);

        if(check)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static String reverse(String T) {
        StringBuilder builder = new StringBuilder(T);
        return builder.reverse().toString();
    }

    private static void DFS(String S, String T, boolean head) {
        if (T.length() == S.length()) {
            if(T.equals(S) && head || reverse(T).equals(S) && !head)
                check = true;
            return;
        }

        if (head) {
            if(T.charAt(T.length() - 1) == 'A')
                DFS(S, T.substring(0, T.length() - 1), true);
            if(T.charAt(0) == 'B')
                DFS(S, T.substring(1), false);
        }

        else {
            if(T.charAt(0) == 'A')
                DFS(S, T.substring(1), false);
            if(T.charAt(T.length() - 1) == 'B')
                DFS(S, T.substring(0, T.length() - 1), true);
        }
    }
}
