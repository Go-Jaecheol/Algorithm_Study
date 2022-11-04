import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Song {
    int index;
    int playCount;

    public Song(int index, int playCount) {
        this.index = index;
        this.playCount = playCount;
    }
}

class GenreCount {
    String genre;
    int playCount;

    public GenreCount(String genre, int playCount) {
        this.genre = genre;
        this.playCount = playCount;
    }
}

class Solution {
    static Map<String, List<Song>> genreSongMap = new HashMap<>();
    static Map<String, Integer> genrePlayMap = new HashMap<>();
    static List<GenreCount> genreCountList = new ArrayList<>();
    static int size = 0;

    public int[] solution(String[] genres, int[] plays) {
        size = genres.length;

        for (int index = 0; index < size; index++) {
            String genre = genres[index];
            int play = plays[index];

            List<Song> songList = genreSongMap.getOrDefault(genre, new ArrayList<>());
            songList.add(new Song(index, play));
            genreSongMap.put(genre, songList);

            genrePlayMap.put(genre, genrePlayMap.getOrDefault(genre, 0) + play);
        }

        for (Map.Entry<String, Integer> entry : genrePlayMap.entrySet()) {
            genreCountList.add(
                    new GenreCount(entry.getKey(), entry.getValue())
            );
        }

        genreCountList = genreCountList.stream()
                .sorted((o1, o2) ->  o2.playCount - o1.playCount)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (GenreCount gc : genreCountList) {
            String genre = gc.genre;
            List<Song> songList = genreSongMap.get(genre);
            songList = songList.stream()
                    .sorted((o1, o2) -> {
                        if (o1.playCount == o2.playCount) {
                            return o1.index - o2.index;
                        }
                        return o2.playCount - o1.playCount;
                    })
                    .collect(Collectors.toList());

            int count = 0;

            for (Song s : songList) {
                count++;
                answer.add(s.index);
                if (count == 2) {
                    break;
                }
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}