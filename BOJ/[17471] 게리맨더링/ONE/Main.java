import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Sector{
    int idx;
    int population;

    public Sector(int idx, int population){
        this.idx = idx;
        this.population = population;
    }
}

public class Main {
    private static int N, result = Integer.MAX_VALUE;
    private static Sector[] sectors;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접 연결 리스트
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        sectors = new Sector[N + 1];

        for(int i = 1; i <= N; i++){
            int population = scanner.nextInt();
            sectors[i] = new Sector(i, population);
        }

        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for(int i = 1; i <= N; i++){
            int adjNum = scanner.nextInt();
            for(int j = 0; j < adjNum; j++){
                int temp = scanner.nextInt();
                list.get(i).add(temp);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i <= N / 2; i++){
            combination(1, i, arrayList);
        }

        if(result == Integer.MAX_VALUE)
            result = -1;

        System.out.println(result);

        scanner.close();
    }

    private static void combination(int start, int r, ArrayList<Integer> A){
        if(r == 0) {
            gerrymandering(A);
            return;
        }

        for(int i = start; i <= N; i++){
            A.add(i);
            combination(i + 1, r - 1, A);
            A.remove(A.size() - 1);
        }
    }

    private static boolean isConnect(int num, ArrayList<Integer> A){
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[num] = true;
        queue.add(num);

        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i : list.get(current))
                if(!visited[i] && A.contains(i)){
                    visited[i] = true;
                    count++;
                    queue.add(i);
                }
        }
        return count == A.size();
    }

    private static void gerrymandering(ArrayList<Integer> A){
        int sumA = 0, sumB = 0;

        if(!isConnect(sectors[A.get(0)].idx, A)) // A가 잘 연결됐는지 확인
            return;

        ArrayList<Integer> B = new ArrayList<>(); // A 구역을 제외한 B 구역 리스트 생성
        for(int i = 1; i <= N; i++){
            if(A.contains(i))
                continue;
            B.add(i);
        }

        if(!isConnect(sectors[B.get(0)].idx, B)) // B가 잘 연결됐는지 확인
            return;

        for(int i = 0; i < A.size(); i++)
            sumA += sectors[A.get(i)].population;

        for(int i = 0; i < B.size(); i++)
            sumB += sectors[B.get(i)].population;

        result = Math.min(result, Math.abs(sumA - sumB));
    }
}
