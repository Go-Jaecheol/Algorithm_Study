import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Step{
    int floor;
    int count;

    public Step(int floor, int count){
        this.floor = floor;
        this.count = count;
    }
}

public class Main {
    private static int F, S, G, U, D;
    private static boolean[] visited = new boolean[1000001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        F = scanner.nextInt();
        S = scanner.nextInt();
        G = scanner.nextInt();
        U = scanner.nextInt();
        D = scanner.nextInt();

        BFS();

        scanner.close();
    }

    private static void BFS(){
        Queue<Step> queue = new LinkedList<>();

        queue.add(new Step(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()){
            Step current = queue.poll();

            // 도착했을 때
            if(current.floor == G){
                System.out.println(current.count);
                return;
            }

            // U버튼 누르고 올라가야할 때
            if(current.floor + U <= F && !visited[current.floor + U]){
                queue.add(new Step(current.floor + U, current.count + 1));
                visited[current.floor + U] = true;
            }

            // D버튼 누르고 내려가야할 때
            if(current.floor - D >= 1 && !visited[current.floor - D]){
                queue.add(new Step(current.floor - D, current.count + 1));
                visited[current.floor - D] = true;
            }
        }
        // 이동할 수 없을 때
        System.out.println("use the stairs");
    }
}
