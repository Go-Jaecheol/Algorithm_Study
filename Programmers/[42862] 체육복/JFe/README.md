# [42862] 체육복 - Python

## 🔍 Algorithm
**Greedy**

## 💻 Logic

```Python
def solution(n, lost, reserve):
    answer, dup_list = 0, []
    # lost, reserve 중복 확인
    for i in reserve:
        if i in lost:
            dup_list.append(i)
    # 중복 제거
    lost = list(set(lost) - set(dup_list))
    reserve = list(set(reserve) - set(dup_list))
    # 왼쪽부터 확인하고 빌려주기
    for i in reserve:
        if i - 1 > 0 and i - 1 in lost:
            lost.remove(i-1)
        elif i + 1 <= n and i + 1 in lost:
            lost.remove(i+1)
    answer = n - len(lost)
    return answer
```

- **lost, reserve 중복 확인**  
  여벌 체육복을 가져온 학생이 도난당하는 경우를 확인하기 위해  
  `lost`, `reserve` 중복 확인해서 `dup_list`에 **append**  
- **중복 제거**  
  **set**을 이용해서 `lost`, `reserve` 각각에 `dup_list`와의 중복 제거  
- **왼쪽부터 확인하고 빌려주기**  
  먼저, 앞 번호가 `lost`에 있으면 `lost`에서 해당 번호 삭제  
  없으면 같은 방식으로 뒷 번호도 확인  
  전체 학생 수 **n**에서 `lost`에 남아있는 학생 수를 뺀 값이 정답  

## 📝 Review

간단한 문제.  
항상 VS Code로 문제 풀다가 IDE 사용없이 문제를 푸니 어색했다.  
코테에서는 IDE 사용없이 프로그래머스 이용해서 푸는 경우가 많다고 하니 프로그래머스에 익숙해져야겠다.  

