import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            String functions = scanner.next();
            int n = scanner.nextInt();
            String array = scanner.next();

            ArrayList<Integer> list = numArray(array);
            System.out.println(execute(functions, list));
        }

        scanner.close();
    }

    private static ArrayList<Integer> numArray(String ary) {
        ArrayList<Integer> num = new ArrayList<>();
        String[] tokens = ary.substring(1, ary.length() - 1).split(",");

        if(tokens[0].equals(""))
            return num;

        for(String token : tokens)
            num.add(Integer.parseInt(token));

        return num;
    }

    private static String execute(String functions, ArrayList<Integer> list) {
        boolean check = true; // true : 정방향 , false : 역방향

        for (int i = 0; i < functions.length(); i++) {
            char function = functions.charAt(i);

            if (function == 'R')
                check = !check;

            else {
                if (list.size() == 0)
                    return "error";
                if (check)
                    list.remove(0);
                else
                    list.remove(list.size() - 1);
            }
        }

        return makeArray(list, check);
    }

    private static String makeArray(ArrayList<Integer> list, boolean check) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        if (check) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    builder.append(list.get(i));
                else
                    builder.append(",").append(list.get(i));
            }
        }

        else {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (i == list.size() - 1)
                    builder.append(list.get(i));
                else
                    builder.append(",").append(list.get(i));
            }
        }

        builder.append("]");

        return builder.toString();
    }
}
