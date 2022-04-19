import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        String ppap = "PPAP";
        StringBuilder builder = new StringBuilder();
        int len = origin.length();

        for (int i = 0; i < len; i++) {
            char c = origin.charAt(i);

            builder.append(c);

            if (builder.length() >= 4) {
                boolean check = true;

                for (int j = 0; j < 4; j++) {
                    char originC = builder.charAt(builder.length() - 4 + j);
                    char ppapC = ppap.charAt(j);

                    if (originC != ppapC) {
                        check = false;
                        break;
                    }
                }
                if(check)
                    builder.delete(builder.length() - 4 + 1, builder.length());
            }
        }

        if(builder.toString().equals("P"))
            System.out.println("PPAP");
        else
            System.out.println("NP");

        scanner.close();
    }
}
