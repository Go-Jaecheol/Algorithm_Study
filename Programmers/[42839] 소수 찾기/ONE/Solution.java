import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> answer = new ArrayList<>();
    private boolean[] check;
    public int solution(String numbers) {
        int length = numbers.length();
        char[] numAry = initAry(numbers);
        check = new boolean[length];

        make(numAry, length, "");

        return answer.size();
    }

    private char[] initAry(String numbers) {
        char[] numAry = new char[numbers.length()];

        for (int i = 0; i < numbers.length(); i++)
            numAry[i] = numbers.charAt(i);

        return numAry;
    }

    private void make(char[] numAry, int length, String numString) {
        if(!numString.equals("") && numString.length() <= length){
            int num = Integer.parseInt(numString);

            if(isPrimeNum(num) && !answer.contains(num))
                answer.add(Integer.valueOf(numString));

            if(numString.length() == length)
                return;
        }

        for(int i = 0; i < length; i++){
            if(!check[i]){
                check[i] = true;
                make(numAry,length,numString + numAry[i]);
                check[i] = false;
            }
        }
    }

    private boolean isPrimeNum(int num) {
        if(num == 0 || num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}