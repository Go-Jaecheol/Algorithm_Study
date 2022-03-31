# [1701] Cubeditor
## Algorithm
- KMP
## Logic
시작하는 부분을 0부터 1씩 증가시키면서 KMP 알고리즘의 부분 일치 테이블을 만드는 부분을 실행해준다.

부분 일치 테이블에는 접두사와 접미사가 같은 부분 문자열의 길이가 저장된다. 접두사와 접미사가 같다는 말은 두 번 이상 등장했다는 소리이기 때문에 정답 후보가 된다.

각 시작 지점마다 정답 후보의 최대 길이를 비교해 최종 답을 구한다.
```js
function solution() {
    const string = input[0];
    let res = 0, begin = 0;
    while(string.length - begin > res) {
        res = Math.max(res, getPartialMax(string.slice(begin++)));
    }
    console.log(res);
}
```
## Review
KMP 알고리즘에 대해 제대로 이해하고 있어야 풀 수 있는 문제라고 생각한다. KMP 알고리즘은 다음에도 복습해야겠다.
