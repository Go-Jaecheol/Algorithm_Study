# [42579] 베스트앨범 - JAVA

## :black_circle: Algorithm
**Hash**, **정렬**

## :black_circle: Logic

- 가장 많이 재생된 노래를 장르별로 두개씩 모음
- 1순위 : 속한 노래가 많이 재생된 장르
- 2순위 : 장르 내에서 많이 재생된 노래
- 3순위 : 장르 내에서 재생횟수가 같을 경우에 고유 번호가 낮은 노래
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택
- 모든 장르는 재생횟수가 다르다

> _Key Idea_
>- 해시맵을 만들어 각 장르별로 총 재생수의 합을 각각 구한다
>- 해시맵의 key 들로 리스트를 만들어 value 값으로 오름차순 정렬해준다
>- 그리고 각 키별로 plays 배열에 있는 값들 중에 최댓값의 인덱스를 구해 first 에 넣는다
>- second 는 first 를 제외한 최댓값의 인덱스를 구하는데, 값이 없을 수도 있기 때문에 값이 -1 이면 정답배열에 넣지 않는다

```Java
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
```

### Test Code

```Java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int[] result = solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500});
        assertArrayEquals(new int[]{4,1,3,0}, result);
    }
}
```

## :black_circle: Review
Hashmap 보다는 정렬이 더 중요도가 높았던 것 같은 문제  
난이도는 별로 안어려운것 같다