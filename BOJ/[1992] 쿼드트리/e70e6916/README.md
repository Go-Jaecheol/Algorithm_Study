# [1992] 쿼드트리 - Python

## :mag: Algorithm

분할 정복

## :round_pushpin: Logic

```search_matrix(n, start_x, start_y)```함수에서 2차원 리스트로 되어 있는 행렬을 이중 
for문으로 확인한다.

행렬의 원소들이 모두 같을 경우 ```data```를 출력한다.

행렬의 원소들이 모두 같은 값이 아닐 경우 ```divide_matrix(n, start_x, start_y)```을 호출하여 행렬의 크기를 나타내는 ```size```값을 2로 나누고 이를 이용한 이중 for문을 통해 다시 ```search_matrix(n, start_x, start_y)```함수를 호출한다.  

## :memo: Review

[1780] 문제를 해결하고 나니 쉬웠다.    