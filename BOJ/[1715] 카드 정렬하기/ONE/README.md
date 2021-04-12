# [1715] 카드 정렬하기
## 💡Algorithm
그리디

## 💡Logic
### --- JAVA ---
이번 문제는 우선순위큐를 사용해야  
편하게 풀 수 있을것 같아 우선순위큐를 사용했다  

N 개수의 카드팩을 입력받고  
N이 1개라면 비교할 필요가 없기에 0을 출력하고  
N이 2 이상에서 우선순위 큐에 저장되어있는 값 2개를 차례로 불러와  
ans에 더해주고 두개를 더한 값을 다시 큐에 넣어 준다

    while(cardPack.size() > 1){
        long tmp_1 = cardPack.poll();
        long tmp_2 = cardPack.poll();

        ans += tmp_1 + tmp_2;
        cardPack.add(tmp_1 + tmp_2);
    }

### --- Python ---

JAVA의 코드와 유사

## 💡Review
이번 문제는 우선순위큐를 사용한다면 크게 어렵지 않던 문제였던 것 같다  
자바와 파이썬에서 둘다 우선순위 큐를 사용하여 풀었는데 거의 비슷했던 것 같다.