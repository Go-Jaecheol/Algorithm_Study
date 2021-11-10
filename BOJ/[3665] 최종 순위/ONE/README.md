# [3665] 최종 순위 - JAVA

## :black_circle: Algorithm
**위상 정렬**

## :black_circle: Logic

작년의 발표된 순위 정보를 이용해서  
연결리스트와 indegree에 정보를 입력
```Java
        for(int i = 0; i < n - 1; i++){
            int front = previousRank[i];
            for(int j = i + 1; j < n; j++){
                int back = previousRank[j];
                graph[front].add(back);
                indegree[back]++;
            }
        }
```

작년 순위에서 변동된 팀들이 a, b 입력으로 주어지는데,  
여기서 주의할 점은 a 와 b 의 입력 순서대로 순위 변동이 일어난 것이 아니라  
**상대적인 순위변동** 이라는 점이다  
그래서 각 그래프에서 a 와 b 의 포함여부를 비교하여  
원래 순위가 a가 앞인지 b가 앞인지 찾아낸다

```Java
    private static void changeRank(ArrayList<Integer>[] graph, int[] indegree, int a, int b){
        int index = findIndex(graph[a], b);

        if(index == -1){ // if b is forwarder than a
            index = findIndex(graph[b], a);
            graph[b].remove(index);
            indegree[a]--;
            graph[a].add(b);
            indegree[b]++;
        }
        else{
            graph[a].remove(index);
            indegree[b]--;
            graph[b].add(a);
            indegree[a]++;
        }
    }
```
a 와 b 의 순서를 알아낸 후 작년 순위를 기반으로 만들어진 리스트에서  
원래 정보를 삭제하고 바뀐 순위 정보대로 새로 리스트에 삽입한다.

그 후 위상 정렬을 진행하는데,  
큐를 이용해서 진행하고  
전체 진행이 끝난후에 만들어진 answer 리스트의 크기가  
n 과 같다면 제대로 순위가 정해진 것이고,  
다르다면 잘못된 정보로 인해 cycle이 발생한 것이기 때문에 "IMPOSSIBLE" 을 출력


여기서 "?"인 경우를 넣지않고 문제가 풀렸고 생각이 안나서 질문을 찾아봤는데,  
질문에서 상대적인 순위가 바뀌는 '모든'경우를 말해주기 때문에,  
아예 일관성이 없거나, 정확한 정답을 알거나 두개가 된다는 것을 알았다

## :black_circle: Review
문제 자체는 어렵지 않았는데  
"?" 인 경우를 찾는데 시간을 허비한 것 같다  
