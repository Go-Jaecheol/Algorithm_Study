# [43236] 징검다리 - JAVA

## :black_circle: Algorithm
**Binary Search**

## :black_circle: Logic

> _Key Idea_
> - left = 1, right = distance(최대거리) 로 두고 mid(target) : 거리의 최솟값 을 이분탐색으로 찾는다
> - 현재 위치와 다음돌의 위치와의 거리를 계산하여 mid 보다 작다면 제거해야 할 돌의 개수를 카운트 해준다
> - 그렇지 않으면 현재 돌을 다음돌로 바꾼다
> - 마지막돌과 목적지의 거리가 mid 보다 작다면 마지막 돌도 없애준다
> - 없애야 될 돌의 개수가 n 개 이하이면 거리가 더 길어질수 있으므로 left = mid + 1을 해서 탐색한다
> - 그렇지 않으면 mid 보다 거리가 더 적어야 하기 때문에 right = mid - 1 으로 탐색한다

```Java
private int binSearch(int distance, int[] rocks, int n) {
    long left = 1, right = distance, mid = 0;
    long answer = 0;

    while (left <= right) {
        int cnt = 0;
        int before = 0;

        mid = (left + right) / 2;

        for (int current : rocks) {
            if(current - before < mid)
                cnt++;
            else
                before = current;
        }

        if(distance - before < mid)
            cnt++;

        if (cnt <= n) {
            left = mid + 1;
            answer = Math.max(answer, mid);
        }
        else
            right = mid - 1;
    }

    return (int)answer;
}
```

## :black_circle: Review
처음생각한 아이디어는 조합으로 n개를 뽑고 거리를 오름차순 정렬해서  
거리를 구하는 것이었는데 제한 사항의 개수를 보고 바로 접어버렸다...  
문제가 이분탐색인것을 생각해서 구해야하는 target이 거리인것을 알았지만 어떤 조건을  
걸어줘야하는지 도저히 생각나지 않았다...  
이분탐색은 정말 많이 풀어봐야 할 것 같다
