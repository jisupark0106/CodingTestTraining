import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static int count = 0;
  static class Node {

    int data;
    LinkedList<Node> adj;
    boolean visited;

    Node(int data) {
      this.data = data;
      this.visited = false;
      this.adj = new LinkedList<Node>();
    }

    void addAdj(Node node) {
      adj.add(node);
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int node = Integer.parseInt(br.readLine());
    int edge = Integer.parseInt(br.readLine());

    Node[] nodes = new Node[node + 1];
    for (int i = 1; i < nodes.length; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 0; i < edge; i++) {
      StringTokenizer stn = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(stn.nextToken());
      int n2 = Integer.parseInt(stn.nextToken());

      nodes[n1].addAdj(nodes[n2]);
      nodes[n2].addAdj(nodes[n1]);
    }

    DFS(nodes[1]);

    System.out.println(count);

  }

  static void DFS(Node node) {
    if (node.visited) {
      return;
    }
    node.visited = true;

    for (Node n : node.adj) {
      if (!n.visited) {
        count++;
        DFS(n);
      }
    }
  }
}
