import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int inTime;
    int outTime;

    public Node(int inTime, int outTime) {
        this.inTime = inTime;
        this.outTime = outTime;
    }

    @Override
    public int compareTo(Node o) {
        if(inTime == o.inTime)
            return outTime - o.outTime;
        return inTime - o.inTime;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int[] route : routes)
            queue.add(new Node(route[0], route[1]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            while (!queue.isEmpty()) {
                Node next = queue.poll();
                if (isOverlap(current, next)){
                    current = overlapNode(current, next);
                    continue;
                }
                queue.add(next);
                break;
            }
            answer++;
        }
        return answer;
    }

    private boolean isOverlap(Node current, Node next) {
        return next.inTime >= current.inTime && next.inTime <= current.outTime || next.outTime >= current.inTime && next.outTime <= current.outTime;
    }

    private Node overlapNode(Node current, Node next){
        return new Node(Math.max(current.inTime, next.inTime), Math.min(current.outTime, next.outTime));
    }
}