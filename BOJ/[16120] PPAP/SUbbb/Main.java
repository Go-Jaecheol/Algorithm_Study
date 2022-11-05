import java.io.*;

public class Main {
    static final String PPAP = "PPAP";
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ppap = br.readLine();

        String answer = PPAP;

        for (int index = 0; index < ppap.length(); index++) {
            char ch = ppap.charAt(index);
            stringBuilder.append(ch);

            if (stringBuilder.length() >= 4 && getString().equals(PPAP)) {
                deleteString();
            }
        }

        if (!stringBuilder.toString().equals("P")) {
            answer = "NP";
        }

        System.out.println(answer);
    }

    private static String getString() {
        return stringBuilder.substring(stringBuilder.length() - 4, stringBuilder.length());
    }

    private static void deleteString() {
        stringBuilder.delete(stringBuilder.length() - 4 + 1, stringBuilder.length());
    }
}
