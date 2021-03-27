# [10775] 공항
## 💡Algorithm
- Greedy
- Disjoint set
## 📚Logic
비행기를 최대한 많이 도킹할려면 주어진 gi번 게이트에 도킹시키는 것이 제일 좋은 방법일 것이다.

gi번 부터 1번까지 내려가면서 **도킹할 수 있는 게이트를 찾아서 (도킹할 게이트 - 1) 과 union**해준다. 

Union을 사용함으로써 부모를 통해 어느 게이트가 도킹이 가능한 상태인지 확인이 가능하다. 

도킹할 수 있는 게이트가 없다면 종료한다.
```c++
for (int i = 0; i < p; i++) {
    int gi, gate;
    cin >> gi;
    gate = find(gi);
    if (gate == 0) break;
    unite(gate, gate - 1);
    cnt++;
}
```
### Union-Find
```c++
int find(int x) {
    if (x == parent[x]) return x;
    else return parent[x] = find(parent[x]);
}

void unite(int x, int y) {
    x = find(x);
    y = find(y);
    parent[x] = y;
}
```
## 📝Review
Disjoint Set이 뭔지 몰라서 남의 코드 보고 공부하면서 했다. 문제를 푼게 아니라 공부했다는게 맞는 표현일듯 ㅎㅎ;
