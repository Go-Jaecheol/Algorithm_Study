function solution(N, number) {
    const dp = [null];

    for (let x = 1; x < 9; x++) {
        const calc = [];
        for (let y = 1; y < x; y++) {
            for (const op1 of dp[y]) {
                for (const op2 of dp[x - y]) {
                    calc.push(op1 + op2);
                    if (op1 - op2 >= 0) {
                        calc.push(op1 - op2);
                    }
                    calc.push(op1 * op2);
                    if (op1 !== 0 && op2 !== 0) {
                        calc.push(Math.floor(op1 / op2));
                    }
                }
            }
        }
        calc.push(Number(String(N).repeat(x)));
        const set = new Set(calc);

        if (set.has(number)) {
            return x;
        }
        
        dp.push([...set]);
    }

    return -1;
}