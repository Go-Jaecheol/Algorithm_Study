const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    solution();
    process.exit();
});

function solution() {
    let N = +input[0];
    let inningEvents = [];
    for (let i = 0; i < N; i++) {
        inningEvents[i] = input[i + 1].map(elem => +elem);
    }

   // 순열생성 후 getScore로 최대 점수 가져오기
   let res = 0;
   const permutations = getPermutation([1, 2, 3, 4, 5, 6, 7, 8]);
   
   for (let permIndex = 0; permIndex < permutations.length; permIndex++) {
        const permutation = permutations[permIndex];
        permutation.splice(3, 0, 0);
        res = Math.max(res, getScore(N, inningEvents, permutation));
   }

   console.log(res);
}

function getPermutation(elements) {
    if (elements.length === 1) return [elements];

    const permutations = [];

    const smallerPerms = getPermutation(elements.slice(1));

    const first = elements[0];

    for (let permIndex = 0; permIndex < smallerPerms.length; permIndex++) {
        const smallerPerm = smallerPerms[permIndex];
        
        for (let positionIndex = 0; positionIndex <= smallerPerm.length; positionIndex++) {
            const permPrefix = smallerPerm.slice(0, positionIndex);
            const permSuffix = smallerPerm.slice(positionIndex);
            permutations.push(permPrefix.concat([first], permSuffix));
        }
    }

    return permutations;
}

function getScore(innings, inningEvents, hitterOrder) {
    let curHitter = 0;
    let score = 0;

    for (let i = 0; i < innings; i++) {
        let outCount = 0;
        let bases = [0, 0, 0]; // 1루, 2루, 3루

        while (outCount < 3) {
            let event = inningEvents[i][hitterOrder[curHitter]];
            curHitter = (curHitter + 1) % 9;
            if (event === 0) outCount++;
            else {
                for (let b = 2; b >= 0; b--) { // 주자 이동
                    if (bases[b]) {
                        let next = b + event;
                        bases[b] = 0;
                        if (next > 2) {
                            score++;
                        } else {
                            bases[next] = 1;
                        }
                    }
                }
                // 타자 이동
                let next = event - 1;
                if (next > 2) {
                    score++;
                } else {
                    bases[next] = 1;
                }
            }
        }
    }

    return score;
}
