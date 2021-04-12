import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Long> cardPack = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
            cardPack.add(scanner.nextLong());

        long ans = 0;
        while(cardPack.size() > 1){
            long tmp_1 = cardPack.poll();
            long tmp_2 = cardPack.poll();

            ans += tmp_1 + tmp_2;
            cardPack.add(tmp_1 + tmp_2);
        }
        System.out.println(ans);
    }
}
