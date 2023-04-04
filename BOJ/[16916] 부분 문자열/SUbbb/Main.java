import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[] patternIndexs;
	private static String original;
	private static String pattern;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		original = br.readLine();
		pattern = br.readLine();

		patternIndexs = new int[pattern.length()];
		makeTable();

		System.out.println(kmpSearch() ? 1 : 0);
	}

	private static void makeTable() {
		int prefix = 0;

		for (int suffix = 1; suffix < pattern.length(); suffix++) {
			while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)){
				prefix = patternIndexs[prefix - 1];
			}

			if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
				patternIndexs[suffix] = ++prefix;
			}
		}
	}

	private static boolean kmpSearch() {
		int orgIndex = 0;
		int patternIndex = 0;
		while (orgIndex < original.length() && patternIndex < pattern.length()) {
			while (patternIndex > 0 && original.charAt(orgIndex) != pattern.charAt(patternIndex)) {
				patternIndex = patternIndexs[patternIndex - 1];
			}

			if (original.charAt(orgIndex) == pattern.charAt(patternIndex)) {
				if (patternIndex == pattern.length() - 1) {
					return true;
				}
				patternIndex++;
			}
			orgIndex++;
		}

		return false;
	}
}
