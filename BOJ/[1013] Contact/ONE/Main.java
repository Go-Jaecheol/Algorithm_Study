import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String vega = "(100+1+|01)+";

        for (int i = 0; i < T; i++) {
            String pattern = scanner.next();
            if(pattern.matches(vega))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        scanner.close();
    }
}
