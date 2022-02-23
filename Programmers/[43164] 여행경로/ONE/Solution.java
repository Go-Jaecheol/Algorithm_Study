import java.util.ArrayList;

class Ticket {
    String dept;
    String land;

    public Ticket(String dept, String land) {
        this.dept = dept;
        this.land = land;
    }

    public boolean isICNDept() {
        return this.dept.equals("ICN");
    }

    public boolean isNext(Ticket ticket) {
        return this.land.equals(ticket.dept);
    }
}

class Solution {
    private String[] answer;
    public String[] solution(String[][] tickets) {
        ArrayList<Ticket> list = new ArrayList<>();

        for(String[] ticket : tickets)
            list.add(new Ticket(ticket[0], ticket[1]));

        answer = new String[list.size() + 1];

        for (int i = 0; i < list.size(); i++)
            if(list.get(i).isICNDept()){
                boolean[] visited = new boolean[list.size()];
                String[] newAnswer = new String[list.size() + 1];
                DFS(newAnswer, list, i, 0, visited);
            }

        return answer;
    }

    private void DFS(String[] newAnswer, ArrayList<Ticket> list, int index, int depth, boolean[] visited) {
        if (depth == list.size() - 1) {
            newAnswer[list.size() - 1] = list.get(index).dept;
            newAnswer[list.size()] = list.get(index).land;

            minStringArray(newAnswer);
            return;
        }

        newAnswer[depth] = list.get(index).dept;

        for(int i = 0; i < list.size(); i++)
            if(!visited[i] && list.get(index).isNext(list.get(i))){
                visited[index] = true;
                DFS(newAnswer, list, i, depth + 1, visited);
                visited[index] = false;
            }
    }

    private void minStringArray(String[] newAnswer) {
        if(answer[0] == null) {
            answer = copyArray(newAnswer);
            return;
        }

        for(int i = 0; i < answer.length; i++) {
            if (answer[i].compareTo(newAnswer[i]) > 0) {
                answer = copyArray(newAnswer);
                return;
            }

            else if(answer[i].compareTo(newAnswer[i]) < 0)
                return;
        }

    }

    private String[] copyArray(String[] ary) {
        String[] tmp = new String[ary.length];
        for(int i =0; i < ary.length; i++)
            tmp[i] = ary[i];
        return tmp;
    }
}