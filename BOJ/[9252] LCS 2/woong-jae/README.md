# [9252] LCS 2
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

Cache를 이용해서 역추적을 한다. Cache에 최선을 구한 기록이 있으니, 그것을 토대로 최선 선택을 하며 문자열을 찾아낸다.

cache[index1 + 1][index2] 와 cache[index1][index2 + 1] 중 큰 것으로 파고 들어가다 같은 것이 있으면 문자열에 추가해주고, 두 개의 index 모두 +1 해서 이동한다.

```c++
void reconstruct(int index1, int index2, string& seq) {
    if(index1 < str1.size() && index2 < str2.size()) {//인덱스가 범위를 벗어났는지 확인
        if(str1[index1] == str2[index2]) {//같은 글자를 찾았을 때
            seq.push_back(str1[index1]);
            reconstruct(index1 + 1, index2 + 1, seq);
        } else {//다음 선택을 정함
            if(cache[index1][index2 + 1] > cache[index1 + 1][index2])
                reconstruct(index1, index2 + 1, seq);
            else reconstruct(index1 + 1, index2, seq);
        }
    }
}
```

## 💡Review

LIS4 문제처럼 새로운 cache를 만들어서 풀어보려고 했지만, 문제가 너무 복잡해져서 여러번 실패했다.

그래서 cache에 최선을 구한 것이 있다는 것에 착안해서 코드를 짰더니 됐다.

역추적이 문제마다 해결방법이 달라서 어렵다... 아니면 내가 그냥 못하는건가?
