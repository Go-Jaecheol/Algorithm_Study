# [1516] 게임 개발 - JAVA

## :black_circle: Algorithm
**위상 정렬**, **DP**

## :black_circle: Logic

```Java
        while(!queue.isEmpty()){
        int current = queue.poll();

        for(int i = 0; i < graph[current].size(); i++){
        int next = graph[current].get(i);
        indegree[next]--;
        minTime[next] = Math.max(minTime[next], minTime[current] + buildings.get(current).time);

        if(indegree[next] == 0)
        queue.add(next);
        }
```

앞서 풀어봤던 위상정렬과 같은 방식으로 그래프와 배열을 생성하고,  
다음에 지을 건물에 걸리는 시간을 계산할 때  

- 다음 건물을 짓는 최소 시간 = max(다음 건물을 짓는 최소 시간, 현재 건물을 짓는 최소 시간 + 현재 건물을 짓는 시간)
  
이는 "여러 개의 건물을 동시에 지을 수 있다" 라는 조건 때문인데,  
한 건물을 짓기 위해 2개의 건물이 필요할 때,  
2개의 건물 중에서 더 오래 걸리는 것으로 하는 것이  
결국 최종 건물을 짓는데 걸리는 최소 시간이기 때문이다. 

위상 정렬이 끝난 후 걸리는 최소 시간들에 본 건물을 짓는 데 걸리는 시간을 합하여 출력

## :black_circle: Review
근처까지 가서 많이 헤맸던 문제  
저 개념을 생각해내는데 시간이 진짜 오래걸렸다  
다음에 다시 봐야할 문제