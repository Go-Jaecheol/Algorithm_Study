사용한 알고리즘
dynamic programming
Logic

dp를 사용했다.


처음에는 cache를 그냥 len(a1) * len(a2)로 줬는데 존나 시간초과 떠서
short_cache라고 하고 조금 길이를 줄여 봤는데
그래도 시간초과 뜬다

그냥 전체적인 알고리즘은 cache에 일치하면 1로 저장하고
그리고 나서 lcs 함수에서 recursive하게 돌아가면서 temp.append(lcs(i+1,j+1))하고
그 중에서 max값에 1을 더해서 max_num으로 return하고

그리고 max_num들이 모여 있는 num_arr이라는 곳에서 최종 max값을 출력하는 건데..

시간초과가 빡 뜬다




Review

short_cache에서 element를 어떻게 잘 다음걸로 넘기는 방법만 알면 빠를 것 같은데
어렵네

그건 내일 생각해봐야겠다고 생각했는데 문제 또 새거 풀어야하네 ? ㅅㅂ

그냥.. 죽고싶다
난 좆밥인 걸 인정하고 알고리즘 책을 봤었어야 했는데
존나 똥고집으로 풀다가 머리 바닥에 존나 깨졌다
