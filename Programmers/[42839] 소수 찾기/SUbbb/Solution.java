import java.util.*;

class Solution {
    private static int[] numbers;
    private static Set<Integer> primeNumbers = new HashSet<>();

    public int solution(String numbers) {
        this.numbers = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int size = this.numbers.length;

        // 모든 숫자 만들어보면서 소수인지 확인
        // 이때 순열을 사용해야 같은 수를 뽑더라도 다른 수로 판단
        for (int count = 1; count <= this.numbers.length; count++) {
            permutation(new int[size], new boolean[size], 0, size, count);
        }

        return primeNumbers.size();
    }

    private static void permutation(int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int newNumber = arrayToInt(output);
            if (isPrime(newNumber)) {
                primeNumbers.add(newNumber);
            }
            return;
        }
        for (int index = 0; index < n; index++) {
            if (!visited[index]) {
                visited[index] = true;
                output[depth] = numbers[index];
                permutation(output, visited, depth + 1, n, r);
                output[depth] = 0;
                visited[index] = false;
            }
        }
    }

    // int[]를 int로 변환
    private static int arrayToInt(int[] output) {
        int sum = 0;
        for (int index = 0; index < output.length; index++) {
            sum += output[index] * Math.pow(10, index);
        }
        return sum;
    }

    // 소수 판별, 이때 2보다 작은 수는 소수 X
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        int start = (int) Math.sqrt(number);
        for (int index = start; index < number; index++) {
            if (number % index == 0) {
                return false;
            }
        }
        return true;
    }
}