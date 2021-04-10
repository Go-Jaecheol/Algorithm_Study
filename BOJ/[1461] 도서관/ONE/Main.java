import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, ans = 0, max =0;
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 0; i < N; i++){
            int tmp = scanner.nextInt();
            if(tmp < 0) {
                minus.add(Math.abs(tmp));
                if(Math.abs(tmp) > max)
                    max = Math.abs(tmp);
            }
            else {
                plus.add(tmp);
                if(tmp > max)
                    max = tmp;
            }
        }

        Collections.sort(plus);
        Collections.sort(minus);

        int cnt = plus.size() - 1;
        while(cnt >= 0){
            ans += plus.get(cnt);
            cnt -= M;
        }

        cnt = minus.size() - 1;
        while(cnt >= 0){
            ans += minus.get(cnt);
            cnt -= M;
        }

        System.out.println(ans * 2 - max);

        scanner.close();
    }
}
