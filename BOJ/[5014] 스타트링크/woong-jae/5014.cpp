#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int F, S, G, U, D;

int getMinButtonPress() {
    vector<int> visited(F + 1, -1);
    queue<int> q;
    
    q.push(S); visited[S] = 0;
    while(q.size()) {
        int cur = q.front();
        
        if (cur + U <= F && visited[cur + U] == -1) {
            q.push(cur + U);
            visited[cur + U] = visited[cur]+ 1;
        }
        if (cur - D >= 1 && visited[cur - D] == -1) {
            q.push(cur - D);
            visited[cur - D] = visited[cur] + 1;
        }
        
        q.pop();
    }
    
    return visited[G];
}

int main() {
    cin >> F >> S >> G >> U >> D;
    int res = getMinButtonPress();
    if (res == -1) cout << "use the stairs" << '\n';
    else cout << res << '\n';
}
