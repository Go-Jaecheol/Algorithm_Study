# [11053] 가장 긴 증가하는 부분 수열 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

```A_data{입력받은 수열의 원소: {'data': 1}}```로 설정된 dictionary를 이용했다.
```'data'```는 자신을 포함한 증가하는 부분 수열의 길이를 뜻한다.

```for i in A:```를 통해 ```'data'```가 1로 초기화된 ```i```를 ```A_data```에 추가하고 곧바로 ```'data'```의 값을 기준으로 오름차순 정렬한다.

정렬된 ```A_data```의 원소들이 **```i```보다 key 값이 크고 ```'data'```값이 작거나 같은지** for문으로 확인한다. 

해당 조건에 부합하는 경우 ```i```의 ```'data'```값에 해당 key의 ```'data'```값을 더해준후 ```break```로 for문을 종료한다.

## :memo: Review

어려웠다. 문제를 해결하기 위한 아이디어를 도출하는 것이 관건이었다.  