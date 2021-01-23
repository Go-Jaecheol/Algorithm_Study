# [1992] 쿼드트리 - C++, Python

## :mag: Algorithm
분할 정복

## :computer: Logic
### C++
```C
void Check_Video(int index, int col_sp, int row_sp)
```
함수를 통해 영상을 4개로 나누고 각각 나눠진 영상에 적힌 숫자가 같으면 카운트하고 넘어가고  
숫자 하나라도 다르면 `Check_Video(index/2, col_sp, row_sp);` 재귀하는 방식
```C
int Check_Execption(int n)
```
처음부터 모두 다 같은 숫자가 나오는 경우에는 예외 처리하는 함수를 사용
***
### Python
```Python
def checkSame(row_sp, col_sp, index)
```
숫자가 하나라도 다르면 **False** 반환, 전부 같으면 **True** 반환
```Python
def divideVideo(row_sp, col_sp, index)
```
**checkSame**의 반환 값이 **True**면 문자열에 추가, **False**면 **재귀**
## :memo: Review
[1780] 종이의 개수 문제랑 비슷한 스타일이다.  
3으로 나눌걸 2로 나누도록 바꾸고 입출력을 문자열로 다루는 것만 빼면 거의 비슷

1780 문제 풀고 바로 풀어서 그런지 시간은 별로 안걸림!

