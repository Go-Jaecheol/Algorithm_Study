# [1780] 종이의 개수 - C++, Python

## :mag: Algorithm
**분할 정복**

## :computer: Logic
### C++
```C
void Check_Paper(int index, int col_sp, int row_sp)
```
함수를 통해 종이를 9개로 나누고 각각 나눠진 종이에 적힌 숫자가 같으면 카운트하고 넘어가고  
숫자 하나라도 다르면 `Check_Paper(index/3, col_sp, row_sp);` **재귀**하는 방식
```C
int Check_Execption(int n)
```
처음부터 모두 다 같은 숫자가 나오는 경우(1번 규칙)에는 예외 처리하는 함수를 사용
***
### Python
```Python
def checkSame(row_sp, col_sp, index)
```
하나라도 다른 숫자가 있으면 **False** 반환, 전부 같으면 **True** 반환
```Python
def dividePaper(row_sp, col_sp, index)
```
**checkSame**의 반환 값이 **True**면 카운트, **False**면 **재귀**
## :memo: Review
오랜만에 해서 그런지 생각보다 오래 걸렸다,,

특히 재귀함수 힘들어 하는 건 여전하고

갈 길이 멀구만 ^^;;
