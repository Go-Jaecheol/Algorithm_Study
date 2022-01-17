public class Solution {
    public int solution(String name) {
        int answer = 0;

        answer += upDown(name);
        answer += leftRight(name);

        return answer;
    }

    private boolean isUp(char c){
        return c >= 'B' && c <= 'N';
    }

    private boolean isDown(char c){
        return c >= 'O' && c <= 'Z';
    }

    private boolean isA(char c){
        return c == 'A';
    }

    private int verticalCount(char c){
        if(isUp(c))
            return c - 'A';
        if(isDown(c))
            return 'Z'- c + 1;
        return 0;
    }

    private int upDown(String name){
        int sum = 0;
        for(int i = 0; i < name.length(); i++)
            sum += verticalCount(name.charAt(i));
        return sum;
    }

    private int leftRight(String name) {
        int len = name.length();
        int moveCnt = len - 1;

        for (int i = 0; i < len; i++) {
            int next = i + 1;

            while (next < len && isA(name.charAt(next)))
                next++;

            moveCnt = Math.min(moveCnt, i + len - next + Math.min(i, len - next));
        }

        return moveCnt;
    }

}
