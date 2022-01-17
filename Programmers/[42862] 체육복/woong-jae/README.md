# [42865] 체육복
## Algorithm
- Bruteforce
## Logic
1. 체육복을 빌려줄 수 있는 학생과 체육복이 진짜 없는 학생을 걸러낸다.
2. 빌려줄 수 있는 학생이 빌려준다
```js
function simulateClothesLend(reserve, reserveIndex, possibleStudent) {
    let maxPossibleStudent = possibleStudent.reduce((prev, cur) => cur ? prev + 1 : prev) - 1;
    if (reserveIndex >= reserve.length) return maxPossibleStudent;

    const reserveStudent = reserve[reserveIndex];
    if (checkBoundary(reserveStudent - 1, possibleStudent.length) && !possibleStudent[reserveStudent - 1]) {
        possibleStudent[reserveStudent - 1] = true;
        maxPossibleStudent = Math.max(maxPossibleStudent, simulateClothesLend(reserve, reserveIndex + 1, possibleStudent));   
        possibleStudent[reserveStudent - 1] = false;
    }

    if (checkBoundary(reserveStudent + 1, possibleStudent.length) && !possibleStudent[reserveStudent + 1]) {
        possibleStudent[reserveStudent + 1] = true;
        maxPossibleStudent = Math.max(maxPossibleStudent, simulateClothesLend(reserve, reserveIndex + 1, possibleStudent));   
        possibleStudent[reserveStudent + 1] = false;
    }

    maxPossibleStudent = Math.max(maxPossibleStudent, simulateClothesLend(reserve, reserveIndex + 1, possibleStudent));

    return maxPossibleStudent;
}
```
## Review
너무 난잡하게 푼 것 같다. 아직 자바스크립트를 제대로 활용하지 못하고 있다는 생각이 든다. 더 연습하자.
