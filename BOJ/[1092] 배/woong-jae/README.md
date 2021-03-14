# [1092] 배
## 💡Algorithm
- 그리디 알고리즘
- 정렬
## 📚Logic
크레인이 버틸 수 있는 무게와 박스를 내림차순으로 정렬한다.

```box```의 수가 0이 될때까지 크레인에 실으면서 박스를 제거해준다.
```c++
while(box.size()) {
    int size = (int)box.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < box.size(); j++) {
            if (box[j] <= crain[i]) {
                box.erase(box.begin() + j);
                break;
            }
        }
    }
    if (size == box.size()) return -1;
    time++;
}
```
## 📝Review
풀긴 풀었지만 알고리즘이 효율적이지 못한 것 같다. 

916ms나 걸린다... c++이여서 통과했지, python이나 다른 언어였으면 시간초과가 났을 것 같다.

다른 풀이도 참고해봐야겠다.
