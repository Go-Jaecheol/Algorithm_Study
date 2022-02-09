# [42840] 모의고사 - JAVA

## :black_circle: Algorithm
**Brute Force**

## :black_circle: Logic

- 수포자 3명이 문제를 각각 정해진 배열의 순서대로 찍음
- 가장 많은 문제를 맞힌 사람을 찾기
- 맞힌 문제수가 같다면 번호 값을 오름차순 정렬

> _Key Idea_
> - 학생을 클래스로 우선순위 큐에서 사용할 수 있도록 구현
> - 맞힌수의 내림차순으로 정렬되게하고 맞힌 수가 같다면 번호로 오름차순 정렬함

```Java
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        GiveUpMath[] array = initArray();
        PriorityQueue<GiveUpMath> queue = new PriorityQueue<>();

        for (GiveUpMath std : array){
            std.setCount(grading(std, answers));
            queue.add(std);
        }

        GiveUpMath first = queue.poll();
        answer.add(first.getNum());

        while (!queue.isEmpty()) {
            GiveUpMath current = queue.poll();
            if(current.getCount() == first.getCount())
                answer.add(current.getNum());
        }

        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = answer.get(i);

        return result;
    }
```

### Test Code

```Java
public class SolutionTest {
    Solution solution;

    @BeforeEach
    public void setSol(){
        solution = new Solution();
    }

    @Test
    public void solution_1(){
        int[] result = solution.solution(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new int[]{1, 3, 2, 4, 2});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}
```

## :black_circle: Review
완전탐색이다보니 쉬운문제였던 것같다