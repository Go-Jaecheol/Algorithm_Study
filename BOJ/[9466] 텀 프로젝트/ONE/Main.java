import java.util.Scanner;

class Student{
    int selectNum;
    boolean isVisited;
    boolean isFinished;

    public Student(int selectNum){
        this.selectNum = selectNum;
        this.isVisited = false;
        this.isFinished = false;
    }
}

public class Main {
    private static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0; i < T; i ++){
            int n = scanner.nextInt();
            count = n;
            Student[] students = new Student[n + 1];

            for(int j = 1; j <= n; j++){
                int selectNum = scanner.nextInt();
                students[j] = new Student(selectNum);
            }

            for(int j = 1; j <= n ; j++)
                if(!students[j].isFinished)
                    DFS(j, students);

            System.out.println(count);
        }
        scanner.close();
    }

    private static void DFS(int v, Student[] students){
        if (students[v].isVisited){
            students[v].isFinished = true;
            count--;
        } else students[v].isVisited = true;

        if(!students[students[v].selectNum].isFinished)
            DFS(students[v].selectNum, students);

        students[v].isVisited = false;
        students[v].isFinished = true;
    }
}
