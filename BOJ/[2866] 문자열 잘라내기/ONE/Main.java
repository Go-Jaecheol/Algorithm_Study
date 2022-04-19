import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0, idx = 1;
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < R; i++)
            list.add(br.readLine());

        ArrayList<String> colStrings = makeCols(list, C);

        while (true) {
            if (isDup(colStrings, idx)) {
                System.out.println(count);
                break;
            } else {
                count++;
                idx++;
            }
        }
    }

    private static ArrayList<String> makeCols(ArrayList<String> list, int C) {
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            StringBuilder builder = new StringBuilder();

            for (String s : list)
                builder.append(s.charAt(i));

            temp.add(builder.toString());
        }
        return temp;
    }
    private static boolean isDup(ArrayList<String> list, int idx) {
        Map<String, Integer> map = new HashMap<>();

        for (String col : list){
            col = col.substring(idx);
            map.put(col, map.getOrDefault(col, 0) + 1);

            if (map.get(col) >= 2)
                return true;
        }
        return false;
    }
}
