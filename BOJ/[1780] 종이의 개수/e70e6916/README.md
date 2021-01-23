# [1780] 종이의 개수 - Python

## :mag: Algorithm

분할 정복

## :round_pushpin: Logic

```search_paper(n, start_x, start_y)```함수에서 2차원 리스트로 되어 있는 행렬을 이중 for문으로 확인한다.

행렬의 원소들이 모두 같을 경우 ```num = {-1: {'count': 0}, 0: {'count': 0}, 1: {'count': 0}}``` dictionary를 통해 원소값에 해당되는 ```count```를 +1 증가시킨다.

행렬의 원소들이 모두 같은 값이 아닐 경우 ```divide_paper(n, start_x, start_y)```을 호출하여 행렬의 크기를 나타내는 ```size```값을 3으로 나누고 이를 이용한 이중 for문을 통해 다시 ```search_paper(n, start_x, start_y)```함수를 호출한다.  

## :memo: Review
처음에는 ```search_paper(paper)```, ```divide_paper(paper)```로 설정하여 행렬을 분할한 값들로 만든 list를 주고 받았다.

그러자 시간초과가 났고 빡쳐서 담배 3개 정도 핀 후 새로 떠오른 아이디어로 시도했다.  

오랜만에 코딩하면서 승부욕이 생겨 재밌었다.