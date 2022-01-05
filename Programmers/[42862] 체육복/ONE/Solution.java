public class Solution {
    public int solution(int n, int[] lost, int[] reserve){
        int answer = 0;
        int[] students = new int[n + 1];

        reserveStd(students, reserve);
        lostStd(students, lost);
        borrow(n, students);

        answer = countResult(n, students);

        return answer;
    }

    private void reserveStd(int[] students, int[] reserve){
        for(int reserveStd : reserve)
            students[reserveStd]++;
    }

    private void lostStd(int[] students, int[] lost){
        for(int lostStd : lost)
            students[lostStd]--;
    }

    private boolean isReserve(int suit){
        return suit > 0;
    }

    private boolean isNoSuit(int suit){
        return suit < 0;
    }

    private boolean withinRange(int n, int student){
        return student >= 1 && student <= n;
    }

    private void borrowFromFront(int i, int[] students){
        students[i]++;
        students[i - 1]--;
    }

    private void borrowFromBack(int i, int[] students){
        students[i]++;
        students[i + 1]--;
    }

    private boolean isFrontReserve(int n, int i, int[] students){
        return withinRange(n, i - 1) && isReserve(students[i - 1]);
    }

    private boolean isBackReserve(int n, int i, int[] students){
        return withinRange(n, i + 1) && isReserve(students[i + 1]);
    }

    private void borrow(int n, int[] students){
        for(int i = 1; i <= n; i++)
            if(isNoSuit(students[i])){
                if(isFrontReserve(n, i, students))
                    borrowFromFront(i, students);
                else if(isBackReserve(n, i, students))
                    borrowFromBack(i, students);
            }
    }

    private boolean haveSuit(int student){
        return student >= 0;
    }

    private int countResult(int n, int[] students){
        int result = 0;
        for(int i = 1; i <= n; i++)
            if(haveSuit(students[i]))
                result++;
        return result;
    }
}
