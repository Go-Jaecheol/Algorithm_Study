import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		long N;
		long result = 0;
		int[] dice = new int[6];
		int[] min_face = new int[6];
		long[] sum = new long[3];
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextLong();   // 1<=N<=1000000 
		scanner.nextLine();
		
		for(int i = 0; i < 6; i++) {
			dice[i] = scanner.nextInt(); // 1<=dice[i]<=50
		}
		
		if(N == 1) {
			Arrays.sort(dice);
			for(int i = 0; i < 5; i++)
				result += dice[i];
			System.out.println(result);
			System.exit(0);
		}
		
		for(int j = 0; j < 3; j++) {
			min_face[j] = Math.min(dice[j], dice[5 - j]);
		}
		
		sum[2] = 4 * (min_face[0] + min_face[1] + min_face[2]);
		
		sum[1] = (4 * (N - 1) + 4 * (N - 2)) * Math.min((min_face[0] + min_face[1]), Math.min((min_face[1] + min_face[2]), (min_face[0] + min_face[2])));
		
		sum[0] = (4 * (N - 1) * (N - 2) + (N - 2) * (N -2)) * Math.min(min_face[0], Math.min(min_face[1], min_face[2])); 
		
		for(int k = 0; k < 3; k++) {
			result += sum[k];
		}
		System.out.println(result);
		scanner.close();
	}
}