# [16916] 부분 문자열
## Alogrithm
- KMP
## Logic
KMP 알고리즘을 사용해서 S가 P의 부분 문자열인지 확인한다.

KMP 알고리즘의 핵심은 "몇 글자 매칭됐냐"에 따라 다음 시작할 위치를 특정할 수 있다는 것이다.

```js
function solution() {
    let [S, P] = input;
    let pi = getPartialMatch(P);
    let begin = 0, matched = 0;
    while(begin <= S.length - P.length) {
        if(matched < P.length && S[begin + matched] === P[matched]) {
            if(++matched === P.length) {
                console.log(1);
                return;
            }
        }
        else {
            if(matched === 0) begin++;
            else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }
    }
    console.log(0);
}
```
## Review
KMP 알고리즘은 최근에 공부했는데도 어려운 것 같다... 이렇게 계속 한 번씩 봐주는게 큰 도움이 되는 것 같다.
