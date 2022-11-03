import java.util.*;
import java.io.*;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetString = br.readLine();
        String bombString = br.readLine();

        for (int index = 0; index < targetString.length(); index++) {
            char currentCharacter = targetString.charAt(index);
            stack.push(currentCharacter);

            if (stack.size() >= bombString.length() && searchBomb(bombString)) {
                bomb(bombString.length());
            }
        }

        String answer = stackToString();
        System.out.println(answer.equals("") ? "FRULA" : answer);
    }

    private static boolean searchBomb(String bombString) {
        int start = stack.size() - bombString.length();
        int end = stack.size();
        int bombIndex = 0;

        for (int index = start; index < end; index++) {
            if (stack.get(index) != bombString.charAt(bombIndex++)) {
                return false;
            }
        }

        return true;
    }

    private static void bomb(int count) {
        while (count > 0) {
            stack.pop();
            count--;
        }
    }

    private static String stackToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}