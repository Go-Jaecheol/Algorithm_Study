# [17406] 배열 돌리기 4
## Algorithm
- Permutation
- Bruteforce
## Logic
1. 회전 연산의 가능한 모든 순열을 구한다.
2. 각 순열마다 회전 연산을 수행한 후 배열 A의 값을 구한다.
3. 최솟값을 구한다.
```js
    let res = 5001;
    for (let orderIndex = 0; orderIndex < possibleOrders.length; orderIndex++) {
        const changedMatrix = JSON.parse(JSON.stringify(matrix));
        for (let k = 0; k < K; k++) {
            const leftTop = {
                r: spinOperations[possibleOrders[orderIndex][k]][0] - spinOperations[possibleOrders[orderIndex][k]][2] - 1,
                c: spinOperations[possibleOrders[orderIndex][k]][1] - spinOperations[possibleOrders[orderIndex][k]][2] - 1
            }
            const rightBottom = {
                r: spinOperations[possibleOrders[orderIndex][k]][0] + spinOperations[possibleOrders[orderIndex][k]][2] - 1,
                c: spinOperations[possibleOrders[orderIndex][k]][1] + spinOperations[possibleOrders[orderIndex][k]][2] - 1
            }
    
            // 회전 연산 수행
            while (leftTop.r !== rightBottom.r) {
                let prev = null;
                for (let colIndex = leftTop.c; colIndex <= rightBottom.c; colIndex++) {
                    let temp = changedMatrix[leftTop.r][colIndex];
                    changedMatrix[leftTop.r][colIndex] = prev;
                    prev = temp;
                }
                for (let rowIndex = leftTop.r + 1; rowIndex <= rightBottom.r; rowIndex++) {
                    let temp = changedMatrix[rowIndex][rightBottom.c];
                    changedMatrix[rowIndex][rightBottom.c] = prev;
                    prev = temp;
                }
                for (let colIndex = rightBottom.c - 1; colIndex >= leftTop.c; colIndex--) {
                    let temp = changedMatrix[rightBottom.r][colIndex];
                    changedMatrix[rightBottom.r][colIndex] = prev;
                    prev = temp;
                }
                for (let rowIndex = rightBottom.r - 1; rowIndex >= leftTop.r; rowIndex--) {
                    let temp = changedMatrix[rowIndex][leftTop.c];
                    changedMatrix[rowIndex][leftTop.c] = prev;
                    prev = temp;
                }
                leftTop.r++;
                leftTop.c++;
                rightBottom.r--;
                rightBottom.c--;
            }
        }

        let operationRes = 5001;
        for (let rowIndex = 0; rowIndex < N; rowIndex++) {
            let rowSum = changedMatrix[rowIndex].reduce((p, c) => p + c);
            operationRes = Math.min(operationRes, rowSum);
        }

        res = Math.min(operationRes, res);
    }
```
## Review
아직 배열 다루는게 서툴어서 시간을 엄청 잡아먹힌 문제다. 하지만, 덕분에 자바스크립트에서 배열이 어떻게 다뤄지는지 잘 알게 되었다.
