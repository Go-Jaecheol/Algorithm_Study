# [42865] 체육복
## Algorithm
- Bruteforce
## Logic
1. 각 학생이 체육복을 몇개 들고있는지 확인한다.
2. 학생 배열을 순회하면서 체육복이 없는 학생이라면 왼쪽부터 확인해서 체육복을 빌릴 수 있다면 빌린다.
```js
function solution(n, lost, reserve) {
    let answer = 0;
    
    let students = new Array(n).fill(1);
    
    reserve.forEach(elem => students[elem - 1] = 2);
    lost.forEach(elem => {
        if(students[elem - 1] > 0) students[elem - 1]--;
    });
    
    students.forEach((elem, i) => {
        if(elem === 0) {
            let left = i - 1, right = i + 1;
            if(left >= 0 && students[left] > 1) {
                students[left]--;
                students[i]++;
                answer++;
            }
            else if (right < n && students[right] > 1) {
                students[right]--;
                students[i]++;
                answer++;
            }
        } 
        else {
            answer++;
        }
    });
    
    return answer;
}
```
## Review
너무 난잡하게 푼 것 같다. 아직 자바스크립트를 제대로 활용하지 못하고 있다는 생각이 든다. 더 연습하자.

220124: 다시 풀었다. 이렇게 쉬운 문제를 왜 어렵게 풀었지. 성장했나?ㅋㅋ;
