# [43238] 입국심사 - JAVA

## :black_circle: Algorithm
**Binary Search**

## :black_circle: Logic

- 처음에 모든 심사대는 비어있습니다
- 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다
- 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다
- 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다 
- 모든 사람이 심사를 받는데 걸리는 `최소 시간` 찾기

> _Key Idea_
> - 각 심사관이 걸리는 시간의 배열을 `오름차순 정렬`합니다
> - `left` 에 0 과 `right` 에 가장 시간이 오래 걸리는 최악의 경우인 `times[times.length - 1] * n` 을 넣습니다
> - 두 시간의 중간 지점인 `mid` 로 각 심시관들이 `mid` 시간동안 심사할 수 있는 사람의 수를 `sum` 에 모두 더해줍니다
> - 만약 `sum` 이 심사를 받아야할 사람수 `n` 보다 작을 경우 시간을 더 늘려야 하기 때문에 `left` 에 `mid + 1` 을 넣고 _오른쪽으로_ 다시 이분탐색 합니다
> - 그렇지 않다면, 해당 시간에 모든 사람을 심사할 수 있으므로 `answer` 에 `mid` 시간을 넣어주고, `right` 에 `mid - 1` 을 넣고 _왼쪽으로_ 다시 이분 탐색하여 최소의 시간을 찾습니다

```Java
while (left <= right) {
    mid = (left + right) / 2;

    long sum = 0;

    for (int time : times)
        sum += mid / time;

    if (sum < n)
        left = mid + 1;

    else {
        right = mid - 1;
        answer = mid;
    }
}
```

## :black_circle: Review
처음 이 문제를 보고 어떻게 이분탐색을 이용해야할지 몰라서  
다른 사람의 풀이를 보고 이해하여 풀었다  
내가 생각했던 이분탐색은 `target` 이 있어야하고 그것을 찾는 탐색이었는데  
이렇게도 풀 수 있구나... 하는 생각이 들었다
