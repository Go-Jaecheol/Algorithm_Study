import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+ -", true);
        Stack<Integer> numbers = new Stack<>();

        int prevNumber = -1;
        while(st.hasMoreTokens()) {
            String word = st.nextToken();

            if (prevNumber != -1) {
                numbers.push(prevNumber + Integer.parseInt(word));
                prevNumber = -1;
                continue;
            }

            if (word.equals(PLUS)) {
                prevNumber = numbers.pop();
            } else if (!word.equals(MINUS)) {
                numbers.push(Integer.parseInt(word));
            }
        }

        // numbers에 남은 수들 다 빼기
        int answer = numbers.elementAt(0);
        for (int index = 1; index < numbers.size(); index++) {
            answer -= numbers.elementAt(index);
        }
        System.out.println(answer);
    }
}