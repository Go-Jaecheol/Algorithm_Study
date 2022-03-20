import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> increase = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> decrease = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            String[] tokens = operation.split(" ");

            switch (tokens[0]) {
                case "I" :
                    insert(increase, decrease, tokens[1]);
                    break;
                case "D" :
                    delete(increase, decrease, tokens[1]);
            }
        }
        return find(increase, decrease);
    }

    private void insert(PriorityQueue<Integer> increase, PriorityQueue<Integer> decrease, String num) {
        increase.add(Integer.parseInt(num));
        decrease.add(Integer.parseInt(num));
    }

    private void delete(PriorityQueue<Integer> increase, PriorityQueue<Integer> decrease, String num) {
        if (num.equals("1") && !decrease.isEmpty()) {
            int current = decrease.poll();
            increase.remove(current);
        } else if (num.equals("-1") && !increase.isEmpty()) {
            int current = increase.poll();
            decrease.remove(current);
        }
    }

    private int[] find(PriorityQueue<Integer> increase, PriorityQueue<Integer> decrease) {
        int[] answer = new int[2];

        if (increase.isEmpty() || decrease.isEmpty())
            return answer;

        answer[0] = decrease.poll();
        answer[1] = increase.poll();

        return answer;
    }
}