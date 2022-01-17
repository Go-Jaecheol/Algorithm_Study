
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
function solution(n, lost, reserve) {
    let answer = 0;
    let possibleStudent = new Array(n + 1).fill(true);

    for(let lostIndex = 0; lostIndex < lost.length; lostIndex++) {
        possibleStudent[lost[lostIndex]] = false; 
    }

    let reserveCheck = [];
    for (let reserveIndex = 0; reserveIndex < reserve.length; reserveIndex++) {
        if (!possibleStudent[reserve[reserveIndex]]) {
            possibleStudent[reserve[reserveIndex]] = true;
            continue;
        }
        reserveCheck.push(reserve[reserveIndex]);
    }

    answer = simulateClothesLend(reserveCheck, 0, possibleStudent);

    return answer;
}

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

function checkBoundary(target, bound) {
    if (1 <= target && target < bound) return true;
    return false;
}
