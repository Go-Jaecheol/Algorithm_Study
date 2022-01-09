# [17135] 캐슬 디펜스
## Algorithm
- Combination
- Brute Force
## Logic
1. 궁수의 위치의 모든 조합을 구한다.
2. 각 조합별로 게임을 수행했을 때 제거할 수 있는 적을 계산한다.
3. 최대값을 구한다.

```js
function getKilledEnemy(options, initialBoard, archerPosition) {
    const {N, M, D} = options;
    let board = [];
    for (let rowIndex = 0; rowIndex < N; rowIndex++) { // Create new board to simulate
        board[rowIndex] = [];
        for (let colIndex = 0; colIndex < M; colIndex++) {
            let element = initialBoard[rowIndex][colIndex];
            board[rowIndex][colIndex] = element;
        }
    }

    let res = 0;
    let enemyExists = true;
    while(enemyExists) { // Simulate until no enemy exists
        let chosenEnemy = [];
        for (let archerIndex = 0; archerIndex < archerPosition.length; archerIndex++) {
            let chosenEnemyInfo = {r: null, c: null, d: null};
            for (let rowIndex = N - 1; rowIndex >= 0; rowIndex--) { 
                for (let colIndex = 0; colIndex < M; colIndex++) {
                    if (board[rowIndex][colIndex] === 1) {
                        let distance = Math.abs(N - rowIndex) + Math.abs(archerPosition[archerIndex] - colIndex);
                        if (D >= distance) {
                            if (chosenEnemyInfo.d === null) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            } else if (chosenEnemyInfo.d > distance) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            } else if (chosenEnemyInfo.d == distance && chosenEnemyInfo.c > colIndex) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            }
                        }
                    }
                }
            }
            if (chosenEnemyInfo.d !== null) chosenEnemy.push(chosenEnemyInfo);
        }
        for (let enemyIndex = 0; enemyIndex < chosenEnemy.length; enemyIndex++) {
            let {r, c} = chosenEnemy[enemyIndex];
            if (board[r][c] === 1) {
                board[r][c] = 0;
                res++;
            }
        }
        
        enemyExists = false;
        for (let rowIndex = N - 1; rowIndex >= 0; rowIndex--) { 
            for (let colIndex = 0; colIndex < M; colIndex++) {
                if (board[rowIndex][colIndex] === 1) {
                    board[rowIndex][colIndex] = 0;
                    if (rowIndex + 1 < N) {
                        board[rowIndex + 1][colIndex] = 1;
                        enemyExists = true;
                    }
                }
            }
        }
    }

    return res;
}
```

## Review
조합을 사용해야한다는 것과 시뮬레이션만 잘 구현하면 쉽게 풀 수 있는 문제인 것 같다.
