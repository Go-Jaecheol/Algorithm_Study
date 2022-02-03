import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> tmpAns = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++)
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((v1,v2)->(map.get(v2)).compareTo(map.get(v1)));

        for (String key : list) {
            int first = getFirst(genres, plays, key);
            int second = getSecond(genres,plays,key,first);

            tmpAns.add(first);
            if(second != -1)
                tmpAns.add(second);
        }

        return getResult(tmpAns);
    }

    private int getFirst(String[] genres, int[] plays, String key) {
        int first = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < genres.length; i++)
            if(genres[i].equals(key))
                if (plays[i] > max){
                    max = plays[i];
                    first = i;
                }

        return first;
    }

    private int getSecond(String[] genres, int[] plays, String key, int first) {
        int second = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < genres.length; i++)
            if(genres[i].equals(key))
                if (plays[i] > max && i != first){
                    max = plays[i];
                    second = i;
                }

        return second;
    }

    private int[] getResult(ArrayList<Integer> tmpAns){
        int[] answer = new int[tmpAns.size()];

        for(int i = 0; i < tmpAns.size(); i++)
            answer[i] = tmpAns.get(i);

        return answer;
    }
}