import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pavi on 16/2/17.
 */
public class Graph {
    int v;
    AdjList[] adjLists;

    Graph(int v) {
        this.v = v;
        adjLists = new AdjList[v];

        for (int i = 0; i < v; i++) {
            adjLists[i] = new AdjList();
        }
    }

    public void addEdge(int from, int to) {
        adjLists[from].addNode(to);
        adjLists[to].addNode(from);
    }

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.println("On v" + i);
            Node temp = adjLists[i].root;
            while (temp != null) {
                System.out.print("->" + temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");

            AdjList adjList = this.adjLists[n];
            Node temp = adjList.root;
            while (temp != null) {
                if (!visited[temp.data]) {
                    visited[temp.data] = true;
                    queue.add(temp.data);
                }
                temp = temp.next;
            }
        }

    }

    private void DFSUtil(boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        AdjList adjList = this.adjLists[s];
        Node temp = adjList.root;
        while(temp != null) {
            if (!visited[temp.data]) {
                visited[temp.data] = true;
                DFSUtil(visited, temp.data);
            }
            temp = temp.next;
        }
    }

    public void DFS(int s) {
        System.out.println();
        boolean[] visited = new boolean[v];
        DFSUtil(visited, s);
    }

}
