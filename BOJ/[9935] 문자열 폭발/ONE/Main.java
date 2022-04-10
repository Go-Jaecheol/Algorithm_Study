import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        String bomb = scanner.next();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);

            builder.append(c);

            if (builder.length() >= bomb.length()) {
                boolean check = true;

                for (int j = 0; j < bomb.length(); j++) {
                    char targetC = builder.charAt(builder.length() - bomb.length() + j);
                    char bombC = bomb.charAt(j);

                    if (targetC != bombC) {
                        check = false;
                        break;
                    }
                }

                if (check)
                    builder.delete(builder.length() - bomb.length(), builder.length());
            }
        }

        if(builder.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(builder);

        scanner.close();
    }
}
