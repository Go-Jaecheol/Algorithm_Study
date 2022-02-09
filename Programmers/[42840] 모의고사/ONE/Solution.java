import java.util.ArrayList;
import java.util.PriorityQueue;

class GiveUpMath implements Comparable<GiveUpMath> {
    private int num;
    private int count;
    private int[] solvingAry;

    public GiveUpMath(int num, int[] solvingAry) {
        this.num = num;
        this.solvingAry = solvingAry;
        count = 0;
    }

    public int getNum() {
        return this.num;
    }

    public int getCount() {
        return this.count;
    }

    public int[] getSolvingAry() {
        return this.solvingAry;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(GiveUpMath o) {
        if(count == o.count)
            return num - o.num;
        return o.count - count;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        GiveUpMath[] array = initArray();
        PriorityQueue<GiveUpMath> queue = new PriorityQueue<>();

        for (GiveUpMath std : array){
            std.setCount(grading(std, answers));
            queue.add(std);
        }

        GiveUpMath first = queue.poll();
        answer.add(first.getNum());

        while (!queue.isEmpty()) {
            GiveUpMath current = queue.poll();
            if(current.getCount() == first.getCount())
                answer.add(current.getNum());
        }

        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = answer.get(i);

        return result;
    }

    private GiveUpMath[] initArray () {
        GiveUpMath[] ary = new GiveUpMath[3];

        ary[0] = new GiveUpMath(1, new int[]{1, 2, 3, 4, 5});
        ary[1] = new GiveUpMath(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        ary[2] = new GiveUpMath(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        return ary;
    }

    private int grading(GiveUpMath std, int[] answers) {
        int count  = 0;
        for (int i = 0; i < answers.length; i++)
            if(answers[i] == std.getSolvingAry()[i % std.getSolvingAry().length])
                count++;
        return count;
    }
}