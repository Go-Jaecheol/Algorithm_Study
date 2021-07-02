# [17070] 파이프 옮기기 1
## 💡Algorithm
- DP
## 📚Logic
파이프의 위치를 (1,1), (1,2) 처럼 좌표 두 개로 나타내는 것이 아니라, 놓여진 상태로 나타냈다.
파이프 상태를 가로(0), 대각선(1), 세로(2)로 나타내어 cache에 사용되는 메모리를 줄였다.
```c++
int total_move(int cur_r, int cur_c, int state) {
    if (cur_r == n && cur_c == n) return 1;
    int &ret = cache[cur_r][cur_c][state];
    if (ret != -1) return ret;
    
    ret = 0;
    switch (state) {
        case 0:
            if (cur_c + 1 <= n && house[cur_r][cur_c + 1] != 1) ret += total_move(cur_r, cur_c + 1, 0);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        case 1:
            if (cur_c + 1 <= n && house[cur_r][cur_c + 1] != 1) ret += total_move(cur_r, cur_c + 1, 0);
            if (cur_r + 1 <= n && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c, 2);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        case 2:
            if (cur_r + 1 <= n && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c, 2);
            if (cur_r + 1 <= n && cur_c + 1 <= n && house[cur_r + 1][cur_c + 1] != 1 && house[cur_r][cur_c + 1] != 1 && house[cur_r + 1][cur_c] != 1) ret += total_move(cur_r + 1, cur_c + 1, 1);
            break;
        default:
            break;
    }
    
    return ret;
}
```
## 📝Review
오랜만에 푼 DP 문제다. 어렵지 않은 문제다. 이제 쉬운 문제는 호다닥 풀 수 있다.
