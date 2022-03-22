# [42746] 가장 큰 수 - JAVA

## :black_circle: Algorithm
**Sorting**

## :black_circle: Logic

- 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 _**가장 큰 수**_ 찾기
- `numbers`의 길이는 1 이상 100,000 이하입니다
- `numbers`의 원소는 0 이상 1,000 이하입니다

> _Key Idea_
> - 숫자로 0만 주어지는 배열은 합을 구해서 0이면 "0"으로 처리되도록 해줍니다
> - 원소중 가장 긴 숫자의 길이가 `4`기 때문에, 원래의 숫자를 반복하여 만들어지는 앞의 4자리 수를 객체에 저장합니다
> - 위에서 얻은 숫자를 비교하여 큰 것이 앞으로 가도록 정렬하고,
> - 만약에 위에서 얻은 숫자가 같다면 원래의 수가 적은 것으로 정렬해야 가장 큰 수를 얻을 수 있습니다

```Java
    public String solution(int[] numbers) {
        ArrayList<Number> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        if(Arrays.stream(numbers).sum() == 0)
            return "0";

        for (int number : numbers)
            list.add(new Number(Integer.toString(number)));

        for (Number number : list)
            number.setChanged();

        list.sort((o1, o2) -> {
            if (o1.changed.equals(o2.changed))
                return Integer.parseInt(o1.original) - Integer.parseInt(o2.original);
            return Integer.parseInt(o2.changed) - Integer.parseInt(o1.changed);
        });

        for(Number number : list)
            builder.append(number.original);

        return builder.toString();
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
        String result = solution.solution(new int[]{6,10,2});
        assertEquals("6210", result);
    }

    @Test
    public void solution_2(){
        String result = solution.solution(new int[]{3,30,34,5,9});
        assertEquals("9534330", result);
    }

    @Test
    public void solution_3(){
        String result = solution.solution(new int[]{1, 10, 100, 1000});
        assertEquals("1101001000", result);
    }

    @Test
    public void solution_4(){
        String result = solution.solution(new int[]{9,998});
        assertEquals("9998", result);
    }

    @Test
    public void solution_5(){
        String result = solution.solution(new int[]{30,3021});
        assertEquals("303021", result);
    }
}
```

## :black_circle: Review
처음에는 맨뒷숫자를 반복하여 늘려서 비교를 했는데,  
반례를 발견하여 수전체를 반복해야된다는 것을 알아 풀 수 있던 문제  
생각을 많이할 수 있는 좋은 문제였던 것 같다!