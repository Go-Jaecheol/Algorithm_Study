import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N, max = Integer.MIN_VALUE;
    private static ArrayList<Integer> numList = new ArrayList<>();
    private static ArrayList<Character> oprList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        N = scanner.nextInt();
        input = scanner.next();

        for(int i = 0; i < N; i++){
            if(i % 2 == 0)
                numList.add(Character.getNumericValue(input.charAt(i)));
            else
                oprList.add(input.charAt(i));
        }

        DFS(numList.get(0), 0);

        System.out.println(max);

        scanner.close();
    }

    private static int calculation(char opr, int a, int b){
        switch (opr){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return  0;
        }
    }

    private static void DFS(int result, int oprIndex){
        if(oprIndex == oprList.size()){
            max = Math.max(max, result);
            return;
        }

        int calc = calculation(oprList.get(oprIndex), result, numList.get(oprIndex + 1));
        DFS(calc, oprIndex + 1);

        if(oprIndex + 1 < oprList.size()){
            calc = calculation(oprList.get(oprIndex + 1), numList.get(oprIndex + 1), numList.get(oprIndex + 2));
            DFS(calculation(oprList.get(oprIndex), result, calc), oprIndex + 2);
        }
    }
}
