function solution(str) {
  let count = 0;

  for (let i = 0; i < str.length; i++) {
    if (str[i] === 'P') {
      count += 1;
      continue;
    }

    if (count < 2 || str[i + 1] !== 'P') {
      return 'NP';
    }

    count -= 2;
  }

  if (count === 1) return 'PPAP';
  return 'NP';
}

const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', (line) => {
  console.log(solution(line));
  rl.close();
}).on('close', () => {
  process.exit();
});
