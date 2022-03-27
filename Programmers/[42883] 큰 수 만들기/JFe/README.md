# [42883] 큰 수 만들기 - Python

## 🔍 Algorithm
**Greedy**

## 💻 Logic

```Python
def solution(number, k):
    answer, cnt = [], 0
    number = list(number)
    # 숫자 추가하면서 제거할 숫자 확인
    for n in number:
        # index error 나지 않도록
        if 0 < len(answer):
            # 맨 뒤 숫자가 현재 숫자 n보다 작으면 pop
            while cnt < k and answer[-1] < n:
                answer.pop()
                cnt += 1
                # index error 나지 않도록
                if 0 == len(answer): break
        # 숫자 추가
        answer.append(n)
    # k개 숫자를 전부 제거하지 않은 경우
    if cnt != k:
        for _ in range(k-cnt):
            answer.pop()
    answer = "".join(answer)
    return answer
```

- **숫자 추가하면서 제거할 숫자 확인**  
  숫자 하나씩 반복문을 돌면서 **append** 해주고, 제거할 숫자를 확인한 뒤 **k**개만큼 제거  
- **맨 뒤 숫자가 현재 숫자 n보다 작으면 pop**  
  맨 뒤 숫자가 현재 숫자 **n**보다 작으면 맨 뒤 숫자 **pop**해주고 `cnt` **+1**  
  `cnt`가 **k**개 될 때까지만 반복  
- **k개 숫자를 전부 제거하지 않은 경우**  
  제거할 숫자가 남은 경우에는 숫자가 **내림차순**으로 정렬된 상태이기 때문에  
  남은 개수만큼 뒤에서부터 **pop**해서 제거  

## 📝 Review

문제를 제대로 이해했다고 생각했는데 풀이를 잘못 생각하고 그걸로 계속 해결하려고 해서 시간이 걸렸다,,  
문제에서 주는 입출력 예시 말고 다른 특이한 상황에 테스트케이스를 생각해내는 실력도 중요하니까 많이 해봐야겠다,,

