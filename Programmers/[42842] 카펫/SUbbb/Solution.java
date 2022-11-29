// brown + yellow 의 약수 쌍이 정답
// brown + yellow에 루트 씌운 값 + 1부터 가로 길이 시작

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int horizontal = (int) Math.sqrt(sum);
        int vertical = 0;

        for (; horizontal < sum; horizontal++) {
            if (sum % horizontal != 0) {
                continue;
            }
            vertical = sum / horizontal;
            if (horizontal >= vertical && isCarpet(brown, horizontal, vertical)) {
                break;
            }
        }

        return new int[]{horizontal, vertical};
    }

    private static boolean isCarpet(int brown, int horizontal, int vertical) {
        return (horizontal - 1) * 2 + (vertical - 1) * 2 == brown;
    }
}