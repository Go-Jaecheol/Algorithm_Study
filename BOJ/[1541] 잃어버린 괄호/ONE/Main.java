import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);

        String expr = scanner.next();

        String[] minusToken = expr.split("-");

        for (int i = 0; i < minusToken.length; i++) {
            int plusNum = 0;

            String[] plusToken = minusToken[i].split("\\+");

            for(String plus : plusToken)
                plusNum += Integer.parseInt(plus);

            if(i == 0)
                answer += plusNum;
            else
                answer -= plusNum;
        }

        System.out.println(answer);

        scanner.close();
    }
}
