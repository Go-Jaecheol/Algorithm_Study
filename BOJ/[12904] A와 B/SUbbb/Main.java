import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final char A = 'A';
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String target = br.readLine();

        Queue<String> words = new LinkedList<>();
        words.add(target);
        for (int index = 0; index < target.length() - original.length(); index++) {
            if (words.isEmpty()) {
                System.out.println(ZERO);
                return;
            }

            String word = words.poll();
            if (isLastA(word)) {
                words.add(deleteLastWord(new StringBuilder(word)).toString());
            } else {
                words.add(reverseWord(deleteLastWord(new StringBuilder(word))).toString());
            }
        }

        if (words.poll().equals(original)) {
            System.out.println(ONE);
            return;
        }
        System.out.println(ZERO);
    }

    private static boolean isLastA(String word) {
        return getLastWord(word) == A;
    }

    private static char getLastWord(String word) {
        return word.charAt(word.length() - 1);
    }

    private static StringBuilder deleteLastWord(StringBuilder word) {
        word.deleteCharAt(word.length() - 1);
        return word;
    }

    private static StringBuilder reverseWord(StringBuilder word) {
        word.reverse();
        return word;
    }
}