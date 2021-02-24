# [2668] 숫자고르기 - Python

## :mag: Algorithm

**DFS**


## :round_pushpin: Logic

입력 받은 둘째 줄 정수들을 ```num```리스트에 저장했다.

```dfs```함수에서 먼저, 인자```x```(첫째 줄 정수)를 인자```set_x```리스트에 append한다.

단, ```x```와 ```num[x]``` => 첫째 줄 정수와 둘째 줄 정수가 같을 경우 ```add_set```리스트에
append한 후 return한다.

같지 않으면, 첫째 줄 정수와 같은 값을 ```num```에서 찾고, 찾은 값의 위치 인덱스
(첫째 줄 정수)를 ```set_x```와 함께 인자로 **재귀**한다.

만약, 찾은 값의 위치 인덱스(첫째 줄 정수)가 ```set_x```에 이미 있을 경우
```angular2html
            if i in set_x:
                temp = 0
                for x in set_x:
                    if x in max_set: temp += 1
                if temp == 0:
                    max_set.extend(set_x)
                elif len(set_x) > len(max_set):
                    max_set = set_x
                return
```
위 코드와 같이, 크기가 가장 큰 집합을 가진 ```max_set```리스트와
```set_x```리스트가 서로 중복된 원소가 없으면 extend로  ```max_set```리스트에
```set_x```리스트를 이어 붙이고, 중복된 단 하나라도 있을 경우 더 크기가 큰 리스트가 ```max_set```리스트가 된다.

이 과정을 ```for i in range(1, N+1): dfs(i, [])```  반복한 후 최종 업데이트 된
```max_set```에 ```add_set```을 추가하고 오름차순 정렬하여 리스트 크기와 함께 출력한다.


## :memo: Review

첫째 줄 정수와 둘째 줄 정수 둘다 신경 쓰느라 생각이 조금 복잡해졌지만, 첫째 줄 정수의 
unipue한 특징을 생각하니 금방 해결 할 수 있었다.