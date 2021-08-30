import java.util.ArrayList;
import java.util.Scanner;

enum Color{
    RED, BLUE
}

class Vertex{
    ArrayList<Integer> adjList;
    Color color;

    public Vertex(ArrayList<Integer> adjList, Color color){
        this.adjList = adjList;
        this.color = color;
    }
}

public class Main {
    private static boolean isBipartite;
    private static Vertex[] vertices;
    public static void main(String[] args) {
        int K;
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();

        for(int i = 0; i < K; i++){
            int V, E;
            isBipartite = true;

            V = scanner.nextInt();
            E = scanner.nextInt();

            vertices = new Vertex[V + 1];

            for(int j = 1; j <= V; j++)
                vertices[j] = new Vertex(new ArrayList<>(), null);

            for(int j = 0; j < E; j++){
                int a, b;

                a = scanner.nextInt();
                b = scanner.nextInt();

                vertices[a].adjList.add(b);
                vertices[b].adjList.add(a);
            }

            for(int j = 1; j <= V; j++){
                if(!isBipartite)
                    break;

                if(vertices[j].color == null)
                    DFS(j, Color.RED);
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }

        scanner.close();
    }

    private static void DFS(int start, Color color){
        vertices[start].color = color;

        for(int adjVertex : vertices[start].adjList){
            if(color == vertices[adjVertex].color){
                isBipartite = false;
                return;
            }

            if(vertices[adjVertex].color == null){
                if(color == Color.RED)
                    DFS(adjVertex, Color.BLUE);
                else
                    DFS(adjVertex, Color.RED);
            }
        }
    }
}
