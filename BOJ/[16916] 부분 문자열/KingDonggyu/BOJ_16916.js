function buildPatternTable(word) {
  let prefixIndex = 0;
  let suffixindex = 1;

  const patternTable = new Array(word.length).fill(0);

  while (suffixindex < word.length) {
    if (word[prefixIndex] === word[suffixindex]) {
      patternTable[suffixindex] = prefixIndex + 1;
      prefixIndex += 1;
      suffixindex += 1;
    } else if (prefixIndex === 0) {
      patternTable[suffixindex] = 0;
      suffixindex += 1;
    } else {
      prefixIndex = patternTable[prefixIndex - 1];
    }
  }

  return patternTable;
}

function solution(text, word) {
  let textIndex = 0;
  let wordIndex = 0;

  const patternTable = buildPatternTable(word);

  while (textIndex < text.length) {
    if (text[textIndex] === word[wordIndex]) {
      if (wordIndex === word.length - 1) {
        return 1;
      }
      textIndex += 1;
      wordIndex += 1;
    } else if (wordIndex > 0) {
      wordIndex = patternTable[wordIndex - 1];
    } else {
      textIndex += 1;
    }
  }

  return 0;
}

const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on('line', (line) => {
  input.push(line);
  if (input.length == 2) rl.close();
}).on('close', () => {
  console.log(solution(...input));
  process.exit();
});
