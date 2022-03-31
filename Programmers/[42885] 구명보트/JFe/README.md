# [42885] 구명보트 - Python

## 🔍 Algorithm
**Greedy**

## 💻 Logic

```Python
def solution(people, limit):
    answer, left, right = 0, 0, len(people)-1
    # 오름차순 정렬
    people.sort()
    # 전부 태울 때까지 반복
    while left <= right:
        answer += 1
        boat = people[right]
        right -= 1
        # 전부 태운 경우
        if left > right : break
        # 제일 가벼운 사람(left)도 같이 태울 수 있는 경우
        if boat + people[left] <= limit:
            left += 1
    return answer
```

- **오름차순 정렬**  
  제일 무게가 나가는 사람을 기준으로 확인하면서 배에 태우기 위해  
- **전부 태울 때까지 반복**  
  남아있는 제일 가벼운 사람의 위치인 `left`가 남아있는 제일 무거운 사람의 위치인 `right`보다 커질 때까지 반복  
- **전부 태운 경우**  
  남아있는 제일 가벼운 사람의 위치인 `left`가 남아있는 제일 무거운 사람의 위치인 `right`보다 커진 경우  
- **제일 가벼운 사람도 같이 태울 수 있는 경우**  
  남아있는 제일 가벼운 사람의 위치는 `left`  
  `left` 위치에 있는 사람을 더한 무게가 `limit` 이하인 경우에는 `left` **+1**  

## 📝 Review

pop()을 이용해서 해결하는 방식으로 구현했는데 효율성 첫 번째 테스트케이스에서 시간초과가 났다,,  
그래서 pop()을 사용하지 않고 해결할 수 있는 방법을 생각해서 다시 풀었다.  
대표적인 그리디 문제인 동전 문제처럼 제일 무게가 많이 나가는 사람을 기준으로 생각해야 함.  

