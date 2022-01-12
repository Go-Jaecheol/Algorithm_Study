# [17136] 색종이 붙이기
## Algorithm
- Bruteforce
## Logic
1. 1을 찾는다
    - 1이 없으면 다 채운 것이므로 0 반환.
2. 1에 색종이 1 * 1 부터 5 * 5 까지 사용 가능한 것을 붙였을 때, 최소 값을 가져온다.

```js
function getMinColoredPapers(coloredPapers, paper) {
    let res = Infinity;

    let found = false;
    outer: for (let rowIndex = 0; rowIndex < 10; rowIndex++) {
        for (let colIndex = 0; colIndex < 10; colIndex++) {
            const element = paper[rowIndex][colIndex];
            if (element) {
                found = {r: rowIndex, c: colIndex};
                break outer;
            }
        }
    }
    if (!found) return 0;

    for (let coloredPaperSize = 1; coloredPaperSize <= 5; coloredPaperSize++) {
        if (possibleToUse(paper, coloredPapers, coloredPaperSize, found)) {
            coloredPapers[coloredPaperSize]--;
            updatePaper(paper, coloredPaperSize, found, 0);
            res = Math.min(res, getMinColoredPapers(coloredPapers, paper) + 1);
            updatePaper(paper, coloredPaperSize, found, 1);
            coloredPapers[coloredPaperSize]++;
        }
    }

    return res;
}
```
## Review
처음에 어떻게 풀지 고민하다, 가닥이 잡히니 쉽게 풀 수 있었던 문제. 오랜만에 조합이나 순열 문제가 아니여서 반가웠다.
