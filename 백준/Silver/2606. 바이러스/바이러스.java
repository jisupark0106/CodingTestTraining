import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer>[] nodes;
  static boolean[] visited;

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int node = Integer.parseInt(br.readLine());
    int edge = Integer.parseInt(br.readLine());

    nodes = new ArrayList[node + 1];
    visited = new boolean[node + 1];

    for (int i = 1; i < nodes.length; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < edge; i++) {
      StringTokenizer stn = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(stn.nextToken());
      int n2 = Integer.parseInt(stn.nextToken());

      nodes[n1].add(n2);
      nodes[n2].add(n1);
    }

    DFS(1);

    int count = 0;
    for (int i = 2; i < node + 1; i++) {
      if (visited[i]) {
        count++;
      }
    }

    System.out.println(count);
  }

  static void DFS(int node) {
    if (visited[node]) {
      return;
    }
    visited[node] = true;

    for (int n : nodes[node]) {
      if (!visited[n]) {
        DFS(n);
      }
    }
  }
}
