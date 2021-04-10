# [11000] 강의실 배정
## 💡Algorithm
그리디, 정렬

## 💡Logic
### --- JAVA ---
기본 로직은 입력 받은 시간표를  
시작시간으로 정렬을 하고 그 상태에서  
시작시간이 같다면 끝나는 시간으로 정렬한다

``` java
Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
``` 
정렬한 후에는 우선순위 큐를 사용하여  
맨처음 원소의 끝나는 시각을 넣고  
그 값으로 N만큼 반복문을 돌며  
큐가 비어있지않고 우선순위큐의 가장 작은 끝나는 시간이  
현재의 시작하는시간보다 작거나 같다면 큐에서 삭제한다

``` java
for(int j = 0; j < N; j++){
            int end = arr[j][1];
            if(!pqueue.isEmpty() && pqueue.peek() <= arr[j][0])
                pqueue.remove();
            pqueue.add(end);
        }
```
### --- Python ---
JAVA 코드와 유사


## 💡Review
이번 문제는 자바와 파이썬에서 사용하는 자료구조 코드 부분에서 어려움을 느꼈다  
앞으로 여러번해서 익숙해져야 할 것 같다