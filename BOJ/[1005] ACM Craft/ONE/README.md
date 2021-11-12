# [1005] ACM Craft - JAVA

## :black_circle: Algorithm
**위상 정렬**, **DP**

## :black_circle: Logic

```Java
            while (!queue.isEmpty()){
                int current = queue.poll();

                for(int back : graph[current]){
                    minTime[back] = Math.max(minTime[back], minTime[current] + time[current]);
                    indegree[back]--;

                    if(indegree[back] == 0)
                        queue.add(back);
                }
            }

            for(int j = 1; j <= N; j++)
                minTime[j] += time[j];
```

**[1516] 게임 개발** 에서 했던 방식과 똑같이  
- 다음 건물을 짓는 최소 시간 = max(다음 건물을 짓는 최소 시간, 현재 건물을 짓는 최소 시간 + 현재 건물을 짓는 시간)
  
위의 원리를 사용하여 해결

## :black_circle: Review
**[1516] 게임 개발** 와 똑같은 문제  
위의 문제를 풀었다면 금방 풀 수 있는 문제