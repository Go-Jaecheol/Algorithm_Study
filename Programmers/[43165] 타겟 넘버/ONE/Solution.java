class Solution {
    private int answer;
    public int solution(int[] numbers, int target) {

        DFS(numbers, target, 0, 0);

        return answer;
    }

    private void DFS(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (result == target)
                answer++;
            return;
        }

        DFS(numbers, target, depth + 1, result + numbers[depth]);
        DFS(numbers, target, depth + 1, result - numbers[depth]);
    }
}