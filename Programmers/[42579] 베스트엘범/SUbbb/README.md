# [42579] 베스트 앨범

## :pushpin: **Algorithm**

해시

## :round_pushpin: **Logic**

```java
static Map<String, List<Song>> genreSongMap = new HashMap<>();
static Map<String, Integer> genrePlayMap = new HashMap<>();
static List<GenreCount> genreCountList = new ArrayList<>();
```

- `genreSongMap`은 장르별 {노래 인덱스, 재생 수} 리스트를 저장한다.
- `genrePlayMap`은 장르별 전체 재생 수를 저장한다.
- `genreCountList`는 {장르, 재생 수} 리스트를 저장한다.
- 주어진 배열 2개를 탐색하면서, `genreSongMap`과 `genrePlayMap`을 완성한다.
- 완성된 `genrePlayMap`의 엔트리를 `genreCountList`에 넣고, 이를 재생 수 기준 내림차순 정렬한다.
- `genreCountList`를 탐색하면서, 장르별 {노래 인덱스, 재생 수} 리스트를 가져와 재생 수 기준 내림차순 정렬, 노래 인덱스 기준 오름차순 정렬한다.
- 정렬된 리스트의 인덱스를 2개만 `answer`에 추가한다.

## :black_nib: **Review**
- 맵을 여러 개 써야 해서 좀 귀찮았다.
- 리스트에 대한 정렬을 클래스가 `Comparable`을 구현하는 방식으로 하려했는데, 의도대로 되지 않았다.