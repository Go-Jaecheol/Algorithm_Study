import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = "(100+1+|01)+";
        String sound = scanner.next();

        if(sound.matches(pattern))
            System.out.println("SUBMARINE");
        else
            System.out.println("NOISE");

        scanner.close();
    }
}
