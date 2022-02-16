# [42586] 기능개발 - JAVA

## :black_circle: Algorithm
**Queue**

## :black_circle: Logic

- 각 기능은 진도가 100%일 때 서비스에 반영
- 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
- 각 배포마다 몇 개의 기능이 배포되는지를 구하기

> _Key Idea_
> - 진도(progress) 와 개발속도(speed) 정보를 가진 **Work class** 생성
> - Work 객체들을 담는 Queue 를 만들어서 삽입
> - 반복문을 돌면서 Queue 의 모든 Work 의 progress 에 speed 를 더해준다
> - Queue 의 맨 앞의 값을 _꺼내지 않고_ progress 값이 100 이상인지를 확인하여
> - 100 이 넘는 다면 뒤에서 progress 값이 100이 넘는것들을 확인하여 count 해준다
> - 위를 Queue 가 empty 가 아닐때 까지 반복

```Java
for (int i = 0; i < progresses.length; i++)
    queue.add(new Work(progresses[i], speeds[i]));

while (!queue.isEmpty()) {
    int count = 0;
    develop(queue);

    Work first = queue.peek();
    if (first.progress >= 100){
        queue.poll();
        count++;
        while (!queue.isEmpty()) {
            if(queue.peek().progress < 100)
                break;
            queue.poll();
            count++;
        }
    }
    if(count > 0)
        cntAry.add(count);
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
        int[] result = solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        assertArrayEquals(new int[]{2, 1}, result);
    }

    @Test
    public void solution_2(){
        int[] result = solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        assertArrayEquals(new int[]{1, 3, 2}, result);
    }
}
```

## :black_circle: Review
조금만 생각하면 됐던 쉬운 문제