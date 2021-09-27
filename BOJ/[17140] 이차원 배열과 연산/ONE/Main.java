import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int num;
    int numCount;

    public Node(int num, int numCount){
        this.num = num;
        this.numCount = numCount;
    }

    @Override
    public int compareTo(Node o) {
        if(this.numCount > o.numCount)
            return 1;
        else if(this.numCount < o.numCount)
            return -1;
        else
            return this.num - o.num;
    }
}

public class Main {
    private static int r, c, k, count;
    private static int rowSize = 3, colSize = 3; // default matrix size
    private static int[][] matrix = new int[101][101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        r = scanner.nextInt();
        c = scanner.nextInt();
        k = scanner.nextInt();

        for(int i = 1; i <= 3; i++)
            for(int j = 1; j <= 3; j++)
                matrix[i][j] = scanner.nextInt();

        while (count <= 100){
            if(matrix[r][c] == k) {
                System.out.println(count);
                break;
            }
            operation();
            count++;
        }

        if(count > 100)
            System.out.println(-1);

        scanner.close();
    }

    private static void operation(){
        int[][] temp = new int[101][101];

        if(rowSize >= colSize){
            // R operation
            int checkMax = 0; // for row or col size X 2
            for(int i = 1; i <= rowSize; i++){
                PriorityQueue<Node> queue = new PriorityQueue<>();
                int[] countNum = new int[101];

                for(int j = 1; j <= colSize; j++)
                    countNum[matrix[i][j]]++;

                for(int j = 1; j <= 100; j++)
                    if(countNum[j] != 0)
                        queue.add(new Node(j, countNum[j]));

                checkMax = Math.max(checkMax, queue.size());

                int index = 1;
                while (!queue.isEmpty()){
                    Node current = queue.poll();
                    temp[i][index++] = current.num;
                    temp[i][index++] = current.numCount;
                }
            }
            if(checkMax * 2 > colSize)
                colSize = checkMax * 2;
        }
        else {
            // C operation
            int checkMax = 0; // for row or col size X 2
            for(int i = 1; i <= colSize; i++){
                PriorityQueue<Node> queue = new PriorityQueue<>();
                int[] countNum = new int[101];

                for(int j = 1; j <= rowSize; j++)
                    countNum[matrix[j][i]]++;

                for(int j = 1; j <= 100; j++)
                    if(countNum[j] != 0)
                        queue.add(new Node(j, countNum[j]));

                checkMax = Math.max(checkMax, queue.size());

                int index = 1;
                while (!queue.isEmpty()){
                    Node current = queue.poll();
                    temp[index++][i] = current.num;
                    temp[index++][i] = current.numCount;
                }
            }
            if(checkMax * 2 > rowSize)
                rowSize = checkMax * 2;
        }
        matrix = temp;
    }
}
