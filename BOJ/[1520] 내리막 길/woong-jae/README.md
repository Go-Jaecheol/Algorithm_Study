# [1520] 내리막 길
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

상하좌우의 값을 확인해서 지금 수보다 작다면 재귀해서 들어간다. 기저사례는 마지막에 도달했을 때가 된다.
```
int move(int row, int col) {
    if(row == m - 1 && col == n - 1) return 1;
    int& ret = cache[row][col];
    if(ret != -1) return ret;
    
    int res = 0, cur = map[row][col];
    if(col < n - 1 && cur > map[row][col + 1]) res += move(row, col + 1);//오른쪽
    if(row < m - 1 && cur > map[row + 1][col]) res += move(row + 1, col);//밑
    if(col > 0 && cur > map[row][col - 1]) res += move(row, col - 1);//왼쪽
    if(row > 0 && cur > map[row - 1][col]) res += move(row - 1, col);//위
    ret = res;
    
    return ret;
}
```

## 💡Review

별로 어렵지 않은 문제.

