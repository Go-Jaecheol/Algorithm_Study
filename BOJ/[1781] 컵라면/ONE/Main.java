import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N  = scanner.nextInt();
        int ans = 0;

        ArrayList<Ramen> homework = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
            homework.add(new Ramen(scanner.nextInt(), scanner.nextInt()));

        homework.sort(new Comparator<Ramen>() {
            @Override
            public int compare(Ramen o1, Ramen o2) {
                if (o1.deadline == o2.deadline)
                    return Integer.compare(o1.numOfCup, o2.numOfCup);
                return Integer.compare(o1.deadline, o2.deadline);
            }
        });

        for(int i = 0; i < N; i++){
            int deadline = homework.get(i).deadline;
            int numOfCup = homework.get(i).numOfCup;
            pq.add(numOfCup);
            if(deadline < pq.size())
                pq.poll();
        }

        while(!pq.isEmpty())
            ans += pq.poll();

        System.out.println(ans);
    }
}

class Ramen {
    int deadline;
    int numOfCup;

    public Ramen(int deadline, int numOfCup) {
        this.deadline = deadline;
        this.numOfCup = numOfCup;
    }
}
