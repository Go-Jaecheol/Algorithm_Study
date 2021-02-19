# [14502] 연구소 - Python

## :mag: Algorithm

**BFS, Brute force**

## :round_pushpin: Logic

1. 입력받은 ```lab```에 값이 2(바이러스)인 인덱스를 (i, j)형태로 ```virus```리스트에 모두 넣는다.


2. ```build_wall()```를 호출한다. 값이 0인 인덱스를 (i, j)형태로 ```zero```리스트에 모두 넣는다.
**```zero```리스트에서 ```combinations```모듈을 통해 3개를 뽑는 모든 경우의 수를 ```combi```리스트에 저장한다.**
   그 후 다음과 같은 방식으로 1(벽) 3개를 만든다.
   ```angular2html
    for c in combi:
        copy_lab = [lab[x][:] for x in range(N)]
        for i in range(3):
            copy_lab[c[i][0]][c[i][1]] = 1
   ```


3. 1(벽)을 3개 설정한 후 ```spread_virus()```를 호출한다. ```for vi in virus:```반복문으로 
   ```vi```를 ```queue```에 먼저 추가한 뒤 **BFS**를 통해 ```copy_lab```에 2(바이러스)를 퍼뜨린다.
또한, 0으로 초기화된 ```visited```를 이용하여 재방문을 방지한다.
   

4. ```spread_virus()```의 BFS가 종료되면 ```check_safe()```을 호출하여 ```copy_lab```에 0의 값을 
가진 인덱스 개수```cnt```를 센다. ```if safe < cnt: safe = cnt```로 0(안전영역)이 max인 수를 저장한다.

## :memo: Review

벽 세우는 방법 : 재귀 → ```combinations``` 모듈을 이용한 반복문

리스트 복사 : ```deepcopy``` 모듈 이용 → 반복문을 통한 복사

방문 리스트 : ```visited```리스트에 append 한 뒤 ```if not in visited``` → 0으로 초기화 된 ```visited``` 이용, 방문 시 1 ```if  visited[x][y] == 0```

처음엔 pypy3도 통과를 못했었는데, 위와 같은 방법으로 코드 변경 후 pypy3, python3 모두 통과 했다.
위 방법들을 제외하고도 여러 코드 수정이 많았다... 이번 문제로 시간초과를 해결하기 위한 여러 방법들을 조금 터득한 듯 하다.


