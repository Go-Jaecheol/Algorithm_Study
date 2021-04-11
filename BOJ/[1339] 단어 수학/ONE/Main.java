import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] alpha = new int[26];   // 0~9에 해당하는 alpha 26개

        String tmp;
        for(int i = 0; i < N; i++) {
            tmp = scanner.next();
            int len_tmp = (int)Math.pow(10, tmp.length() - 1);
            for(int j = 0; j < tmp.length(); j++){
                alpha[(int)tmp.charAt(j) - 65] += len_tmp;
                len_tmp /= 10;
            }
        }

        Arrays.sort(alpha);

        int cnt = 9;
        int sum = 0;

        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0)
                break;
            sum += alpha[i] * cnt;
            cnt--;
        }

        System.out.println(sum);

        scanner.close();
    }
}
