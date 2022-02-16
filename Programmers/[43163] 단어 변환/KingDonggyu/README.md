# [43163] 단어 변환 - Python

## :mag: Algorithm

### BFS

## :round_pushpin: Logic

💡 **BFS**를 통해 `words` 중 **큐에서 pop**한 단어와 다른 문자가 하나인 단어를 **큐에 push**한다.

```python
while q:
    x, l = q.pop(0)
    if x == target: return l
    
    for i, word in enumerate(words):
        if visited[i]: continue
        changed = 0
        for j in range(len(begin)):
            if x[j] != word[j]:
                changed += 1
        if changed == 1:
            q.append((word, l+1))
            visited[i] = True
```

- 큐에 push 한 단어에 대한 방문 여부를 `visited` 에 저장하여 재방문 시 `continue` 함으로써 불필요한 연산을 줄인다.

- pop한 단어가 `target`과 같을 경우 return한다.

## :memo: Review

BFS의 특성을 잘 반영한 기초적인 문제였다.