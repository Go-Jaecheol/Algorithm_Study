# [42587] 프린터 - Java

## :pushpin: **Algorithm**

스택, 큐

## :round_pushpin: **Logic**

```java
static Queue<Pair> taskQueue = new LinkedList<>();
static List<Integer> priorityList = new ArrayList<>();

int index = 0;
int maxPriority = priorityList.get(index);
int answer = 0;
while (!taskQueue.isEmpty()) {
    Pair current = taskQueue.poll();

    if (current.priority == maxPriority) {
        if (++index < priorityList.size())
            maxPriority = priorityList.get(index);
        answer++;
        if (current.index == location) {
            break;
        }
    }

    taskQueue.add(current);
}
```

- List에 일의 중요도를 내림차순으로 정렬해 가지고 있는다.
- Queue에 삽입한 일들을 하나씩 pop하면서 현재 가장 높은 중요도와 같은 중요도를 가지는 지 확인하고, 그 index가 location과 동일하다면 종료된다.

## :black_nib: **Review**
- 간단한 문제였다.
- 일의 중요도를 저장하는 리스트를 쓰는 방식이 관건이었다.