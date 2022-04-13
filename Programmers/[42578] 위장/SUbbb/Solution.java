import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1]))
                map.put(cloth[1], map.get(cloth[1]) + 1);
            else
                map.put(cloth[1], 1);
        }
        
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet())
            answer *= (entry.getValue() + 1);
        
        return answer - 1;
    }
}