# [1781] 컵라면 
## 💡Algorithm
그리디

## 💡Logic
### --- JAVA ---
데드라인과 컵라면 수를 변수로 갖는  
Ramen 클래스를 선언하여 객체배열을 생성한다

입력을 받아 데드라인 기준으로 정렬을 하고  
반복문을 돌려 우선순위큐에 넣는데  
데드라인이 우선순위큐의 사이즈보다 작을경우에  
제일 작은 값을 우선순위 큐에서 뺸다

    for(int i = 0; i < N; i++){
        int deadline = homework.get(i).deadline;    
        int numOfCup = homework.get(i).numOfCup;
        pq.add(numOfCup);
        if(deadline < pq.size())
            pq.poll();
    }

큐에 들어있는 총합을 더해서 출력한다

### --- Python ---
자바 코드와 유사하며 heap queue 사용

## 💡Review
자바 코드에서 우선순위큐로 통과하고  
파이썬 코드에도 우선순위큐를 적용하여 자바코드와 유사한 방식으로 풀려고 했으나,  
자꾸 시간초과가 나서 찾아보니 더 간단하게 할수 있는 방법이 있어서 적용하여 통과하였다

두 언어로 하기 빡세노!