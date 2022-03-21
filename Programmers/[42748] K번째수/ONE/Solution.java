import java.util.ArrayList;
import java.util.Arrays;

class Command {
    int i;
    int j;
    int k;

    public Command(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer;
        ArrayList<Command> list = new ArrayList<>();

        for (int[] command : commands)
            list.add(new Command(command[0], command[1], command[2]));

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++)
            answer[i] = find(list.get(i), array);

        return answer;
    }

    private int find(Command command, int[] array) {
        int[] subArray = Arrays.copyOfRange(array, command.i - 1, command.j);

        Arrays.sort(subArray);

        return subArray[command.k - 1];
    }
}