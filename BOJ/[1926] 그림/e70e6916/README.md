# [1926] 그림 - Python

## :mag: Algorithm

**BFS**

## :round_pushpin: Logic

```paper```의 값이 1일 경우 상하좌우를 확인하는 BFS를 이용한다. 상하좌우 중 1인 경우가 있을 시 0으로 초기화 된 
N x M 크기의 리스트```picture```의 현재 인덱스 값에 +1을 해준다. BFS가 종료되면 1을 return한다.

```paper```의 값이 1일 아닐 경우 0을 return한다. 또, ```picture```의 값이 0보다 클 경우
이미 방문했던 인덱스로 여겨 바로 이 또한 0을 return한다.


위 과정을 2중 for문으로 반복하며 return 값을 0으로 선언 된 ```cnt```에 더해주어 그림의 개수를 구한다. 
그리고 ```picture```의 값 중 max값을 구하면 가장 큰 그림의 크기 또한 알 수 있다. 


## :memo: Review

큰 생각이 필요하지 않은 문제였다. 나름 쉬웠다.