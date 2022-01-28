# [42842] 카펫
## Algorithm
- Brute force
## Logic
노란색을 기준으로 세로 길이를 1부터 키워간다. 그러다 노란색 주위를 갈색으로 덮었을 때 필요한 갈색 타일의 수가 주어진 `brown`과 같다면 원하는 가로와 세로 길이를 찾은 것이다.
```js
function solution(brown, yellow) {
    let answer = [];
    const yellowWidth = yellow;
    let yellowHeight = 1;
    
    while(yellowWidth / yellowHeight >= yellowHeight) {
        if(yellowWidth % yellowHeight === 0) {
            let width = yellowWidth / yellowHeight + 2;
            let height = yellowHeight;
            if((height + width) * 2 === brown) {
                answer[0] = width; answer[1] = height + 2;
                break;
            }
        }
        yellowHeight++;
    }
    
    
    return answer;
}
```
## Review
쉬운 문제..
