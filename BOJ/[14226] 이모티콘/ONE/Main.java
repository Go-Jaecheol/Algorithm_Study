import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Step{
    int screen; // 화면에 있는 이모티콘 수
    int clipboard; // 클립보드에 있는 이모티콘 수
    int sec; // 걸린 시간

    public Step(int screen, int clipboard, int sec){
        this.screen = screen;
        this.clipboard = clipboard;
        this.sec = sec;
    }
}

public class Main {
    private static int S;
    private static boolean[][] visited = new boolean[1001][1001]; // [클립보드의 이모티콘 수][화면의 이모티콘 수]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        S = scanner.nextInt();

        BFS();

        scanner.close();
    }

    private static void BFS(){
        Queue<Step> queue = new LinkedList<>();

        queue.add(new Step(1, 0, 0));
        visited[0][1] = true;

        while (!queue.isEmpty()){
            Step current = queue.poll();

            if(current.screen == S){
                System.out.println(current.sec);
                return;
            }

            // 화면의 이모티콘을 클립보드에 복사
            queue.add(new Step(current.screen, current.screen, current.sec + 1));

            // 클립보드를 화면에 붙여넣기
            if(current.clipboard != 0 && current.screen + current.clipboard <= S && !visited[current.clipboard][current.screen + current.clipboard]){
                queue.add(new Step(current.screen + current.clipboard, current.clipboard, current.sec + 1));
                visited[current.clipboard][current.screen + current.clipboard] = true;
            }

            // 화면의 이모티콘 1개 삭제
            if(current.screen > 0 && !visited[current.clipboard][current.screen - 1]){
                queue.add(new Step(current.screen - 1, current.clipboard, current.sec + 1));
                visited[current.clipboard][current.screen - 1] = true;
            }
        }
    }
}
