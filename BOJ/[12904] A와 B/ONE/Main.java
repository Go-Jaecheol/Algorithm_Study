import java.util.Scanner;

public class Main {
    private static boolean head;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        String T = scanner.next();
        head = true;

        while (S.length() < T.length())
            T = remove(T);

        if(!head)
            T = reverse(T);

        if(S.equals(T))
            System.out.println(1);
        else
            System.out.println(0);

        scanner.close();
    }

    private static String remove(String T) {
        if(head){
            if (T.charAt(T.length() - 1) == 'B')
                head = false;
            return T.substring(0, T.length() - 1);
        }
        else {
            if (T.charAt(0) == 'B')
                head = true;
            return T.substring(1);
        }
    }

    private static String reverse(String T) {
        StringBuilder builder = new StringBuilder(T);
        return builder.reverse().toString();
    }
}
