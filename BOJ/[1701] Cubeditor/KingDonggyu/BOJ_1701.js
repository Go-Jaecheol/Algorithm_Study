function buildPatternTable(word) {
  let prefixIndex = 0;
  let suffixIndex = 1;

  const patternTable = new Array(word.length).fill(0);

  while (suffixIndex < word.length) {
    if (word[prefixIndex] === word[suffixIndex]) {
      patternTable[suffixIndex] = prefixIndex + 1;
      prefixIndex += 1;
      suffixIndex += 1;
    } else if (prefixIndex === 0) {
      suffixIndex += 1;
    } else {
      prefixIndex = patternTable[prefixIndex - 1];
    }
  }

  return patternTable;
}

function solution(text) {
  let patternTable;
  let maxLen = 0;
  
  for (let i = 0; i < text.length - 2; i++) {
    patternTable = buildPatternTable(text.slice(i));
    maxLen = Math.max(maxLen, ...patternTable);
  }

  return maxLen;
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
