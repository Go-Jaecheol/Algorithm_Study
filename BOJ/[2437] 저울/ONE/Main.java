import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] weights = new int[N];

        for(int i = 0; i < N; i++)
            weights[i] = scanner.nextInt();

        Arrays.sort(weights);

        int sum = 0;
        for(int j = 0; j < N; j++){
            if(sum + 1 < weights[j])
                break;
            sum += weights[j];
        }

        System.out.println(sum + 1);

        scanner.close();
    }
}
