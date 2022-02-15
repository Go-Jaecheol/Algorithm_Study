class Solution {
    public int[] solution(int brown, int yellow) {
        // 두 개의 합을 두 개의 곱으로 나타낸다

        int[] answer = new int[2];

        solving(brown, yellow, answer);

        return answer;
    }

    private boolean isYellowRight(int bw, int brown, int yellow) {
        int bh = (brown + yellow) / bw;
        int yw = bw - 2;
        int yh = bh - 2;

        return yellow == yw * yh;
    }

    private void solving(int brown, int yellow, int[] answer) {
        int sum = brown + yellow;

        for (int i = 3; i <= sum; i++) {
            if(sum % i != 0)
                continue;
            if (i >= sum / i && isYellowRight(i, brown, yellow)) {
                answer[0] = i;
                answer[1] = sum / i;
                return;
            }
        }
    }
}