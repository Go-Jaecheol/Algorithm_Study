# [9466] 텀 프로젝트 - Python

## :mag: Algorithm

DFS

## :round_pushpin: Logic

```python
def dfs(x):
    global success
    visited[x] = True
    student = students[x]
    team.append(x)
    if visited[student]:
        if student in team:
            success += len(team) - team.index(student)
    else:
        dfs(student)
```

**DFS**를 통해 배열 `students`를 탐색하며 사이클을 이루는지 확인한다.

만약 사이클을 이루면 사이클을 발견했을 때의 index를 배열 `team`의 길이에 뺸 값을 변수 `success`에 더한다.

모든 탐색이 종료되면 최종 업데이트한 `successs`를 출력한다.

## :memo: Review

사이클을 이루는지 확인하기만 하면 되는 쉬운 DFS 문제.
