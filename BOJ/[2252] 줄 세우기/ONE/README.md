# [2252] 줄 세우기 - JAVA

## :black_circle: Algorithm
**위상 정렬**

## :black_circle: Logic

```Java
        for(int i = 1; i <= N; i++)
            if(indegree[i] == 0)   // if it has no edges
                queue.add(i);

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }
```

앞번호를 인덱스로 하는 리스트에 뒷번호를 추가  
뒷번호를 인덱스로 하는 indegree 배열에 카운트를 추가  
indegree 배열은 vertex 가 몇개의 edge 를 가지고 있는지를 나타냄  
  
indegree 가 0인 vertex 는 먼저 나와야하는 숫자임을 의미하기 때문에  
출력하고 해당하는 리스트에 뒷번호들의 indegree 배열들을 -1 해줌

## :black_circle: Review
위상 정렬이라는 개념을 몰라서 개념을 공부한 후에 구현  
시뮬레이션 문제를 많이하다가 이렇게 짧은 문제를 푸니까 어색하다