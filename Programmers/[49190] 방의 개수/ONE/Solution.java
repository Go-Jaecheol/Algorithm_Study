import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Point o = (Point)obj;
        return this.x == o.x && this.y == o.y;
    }
}

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        Point origin = new Point(0, 0);
        Map<Point, ArrayList<Point>> visited = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point newPoint = new Point(origin.x + dx[arrow], origin.y + dy[arrow]);

                if (!visited.containsKey(newPoint)) {
                    visited.put(newPoint, makeList(origin));

                    if (visited.get(origin) == null)
                        visited.put(origin, makeList(newPoint));

                    else
                        visited.get(origin).add(newPoint);
                }
                else if (visited.containsKey(newPoint) &&
                        !(visited.get(newPoint).contains(origin))) {

                    visited.get(newPoint).add(origin);
                    visited.get(origin).add(newPoint);
                    answer++;
                }
                origin = newPoint;
            }
        }

        return answer;
    }

    private ArrayList<Point> makeList(Point point) {
        ArrayList<Point> edge = new ArrayList<>();
        edge.add(point);
        return edge;
    }
}