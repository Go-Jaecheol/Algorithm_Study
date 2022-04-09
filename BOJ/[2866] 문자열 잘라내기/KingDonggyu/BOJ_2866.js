function solution([R, C, ...table]) {
  const strList = new Array(C).fill('');
  let isDuplicate = true;
  let count = +R - 1;

  while (isDuplicate && table.length) {
    const row = table.pop();
    const map = new Map();

    isDuplicate = false;

    for (let x = 0; x < C; x++) {
      const str = strList[x] + row[x];

      if (!map.has(str)) {
        map.set(str, true);
      } else {
        isDuplicate = true;
      }
      strList[x] = str;
    }
    if (isDuplicate) count -= 1;
  }

  return count;
}

const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on('line', (line) => {
  if (!input.length) {
    input.push(...line.trim().split(' '));
  } else {
    input.push(line);
    if (input.length === +input[0] + 2) {
      rl.close();
    }
  }
}).on('close', () => {
  console.log(solution(input));
  process.exit();
});
