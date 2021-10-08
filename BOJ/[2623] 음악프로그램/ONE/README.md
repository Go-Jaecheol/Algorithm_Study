# [2623] 음악프로그램 - JAVA

## :black_circle: Algorithm
**위상 정렬**

## :black_circle: Logic
```Java
        for(int i = 1; i <= N; i++)
            if (indegree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);

            for(int i = 0; i < graph[current].size(); i++){
                int next = graph[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        if(answer.size() == N)
            for (int num : answer)
                System.out.println(num);
        else
            System.out.println(0);
```


**[2252] 줄 세우기** 와 **[1766] 문제집** 과 유사한 문제  
다른 점은 위상 정렬이 이루어 질수 없는 경우를 찾아 내는 것인데,  
이는 indegree 배열의 값이 0 이되면 큐에 삽입을 하고 큐의 사이즈가 0이  
될 때까지 반복하는 방식인데 만약 순서를 정하는 것이 불가능 하다면  
N 크기만큼의 answer 배열이 만들어지지 않고 반복문이 끝나게 된다

## :black_circle: Review
생각을 조금만 하면 되는 문제