import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Integer> crane = new ArrayList<>(N);
        for(int i = 0; i < N; i++)
            crane.add(scanner.nextInt());

        int M = scanner.nextInt();
        ArrayList<Integer> box = new ArrayList<>();
        for(int j = 0; j < M; j++)
            box.add(scanner.nextInt());

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if(crane.get(0) < box.get(0)) // failed to move
            System.out.println(-1);
        else {
            int cnt = 0;
            while(box.size() != 0){
                int idx = 0;  // for crane
                int tmp = 0;  // for box
                while(idx < N) {
                    if(tmp == box.size())
                        break;
                    if(box.get(tmp) <= crane.get(idx)){
                        box.remove(tmp);
                        idx++;
                    }
                    else
                        tmp++;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
        scanner.close();
    }
}
