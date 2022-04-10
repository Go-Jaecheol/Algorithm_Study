function solution(S, T) {
  function recursion(startIndex, endIndex, isReverse) {
    if (endIndex - startIndex + 1 === S.length) {
      let slicedT = T.slice(startIndex, endIndex + 1);
      if (isReverse) slicedT = slicedT.split('').reverse().join('');
      if (slicedT === S) return 1;
      return 0;
    }

    let result = 0;

    const start = isReverse ? endIndex : startIndex;
    const end = isReverse ? startIndex : endIndex;

    if (T[end] === 'A') {
      result = isReverse
        ? recursion(startIndex + 1, endIndex, isReverse)
        : recursion(startIndex, endIndex - 1, isReverse);

      if (!result && T[start] === 'B') {
        result = isReverse
          ? recursion(startIndex, endIndex - 1, !isReverse)
          : recursion(startIndex + 1, endIndex, !isReverse);
      }
    } else if (T[start] === 'B') {
      result = isReverse
        ? recursion(startIndex, endIndex - 1, !isReverse)
        : recursion(startIndex + 1, endIndex, !isReverse);
    }

    return result;
  }

  return recursion(0, T.length - 1, false);
}

const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on('line', (line) => {
  input.push(line);
  if (input.length === 2) rl.close();
}).on('close', () => {
  console.log(solution(...input));
  process.exit();
});
