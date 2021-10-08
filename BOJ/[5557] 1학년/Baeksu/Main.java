import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] ary;
    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ary = new int[N];
        list = new long[21];

        String s = br.readLine();
        s = s.replace(" ", "");
        for (int i = 0; i < N; i++)
            ary[i] = s.charAt(i) - '0';

        list[ary[0]] = 1;

        func(0);

        System.out.println(list[ary[N-1]]);
    }

    static void func(int n) {
        if(n == N-2)
            return;
        long[] temp = new long[21];
        for(int i = 0 ; i <= 20; i++){
            if(list[i] != 0) {
                if(i - ary[n+1] >= 0)
                    temp[i-ary[n+1]] += list[i];
                if(i + ary[n+1] <= 20)
                    temp[i+ary[n+1]] += list[i];
            }
        }
        list = temp.clone();
        func(n+1);
    }
}