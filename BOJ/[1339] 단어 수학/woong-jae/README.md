# [1339] 단어 수학
## 💡Algorithm
- 그리디 알고리즘
## 📚Logic
주어진 단어가 ABB, BBA, BBB, ABA라고 가정해보자. A 와 B 중 어느것이 우선순위가 더 높을까?

위의 단어를 숫자로 표현해보자
- ABB = 100*A + B*10 + B
- BBA = 100*B + B*10 + A
- BBB = 100*B + B*10 + B
- ABA = 100*A + B*10 + A

모두 더하면 202*A + 242*B 로 표현할 수 있다. B가 가중치가 더 높기 때문에 더 높은 수를 부여받아야하는 것을 알 수 있다.

### 구현
입력을 받으면서 각 알파벳에 가중치를 더해준다. 이것을 내림차순으로 ```sort```하면 원하는 값을 얻을 수 있다.
```c++
for (int i = 0; i < n; i++) {
    int digit = 1;
    cin >> word;
    for (int i = (int)word.length() - 1; i >= 0; i--) {
        word_value[word.at(i) - 65].second += digit;
        digit *= 10;
    }
    wordlist.push_back(word);
}
sort(word_value.begin(), word_value.end(), compare);
```
## 📝Review
처음에는 자리수와 빈도수로 우선순위를 정했다. 자리 수가 같다면 빈도수가 높은 것이 높은 숫자를 부여받게 코드를 짰다.

하지만, 이렇게 구현을 하니 자리 수는 같지만 빈도수가 앞도적으로 높아 높은 숫자를 부여받아야 하는 경우가 반례로 나타났다.

한참 생각해도 아이디어가 생각나지 않아서 다른 사람의 아이디어만 살짝 엿봤다. 세상에 똑똑한 사람이 참 많은 것 같다.
