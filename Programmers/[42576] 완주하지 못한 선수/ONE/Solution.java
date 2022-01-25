import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer;
        HashMap<String, Integer> map = initMap(participant);
        removeCompletion(map, completion);
        answer = findUnfinished(map);

        return answer;
    }

    private HashMap<String, Integer> initMap(String[] participant) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        return map;
    }

    private void removeCompletion(HashMap<String, Integer> map, String[] completion) {
        for(String player : completion)
            map.put(player, map.get(player) - 1);
    }

    private String findUnfinished(HashMap<String, Integer> map) {
        String unfinished = "";
        for (String player : map.keySet())
            if(map.get(player) == 1){
                unfinished = player;
                break;
            }
        return unfinished;
    }
}