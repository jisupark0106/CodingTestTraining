import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    Deque<Integer> deque = new ArrayDeque<>();
    int orderCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < orderCase; i++) {
      String[] arg = br.readLine().split(" ");
      switch (arg[0]) {
        case "push_front":
          deque.addFirst(Integer.parseInt(arg[1]));
          break;

        case "push_back":
          deque.addLast(Integer.parseInt(arg[1]));
          break;

        case "pop_front":
          println(deque.isEmpty() ? -1 : deque.removeFirst());
          break;

        case "pop_back":
          println(deque.isEmpty() ? -1 : deque.removeLast());
          break;

        case "size":
          println(deque.size());
          break;

        case "empty":
          println(deque.isEmpty() ? "1" : "0");
          break;

        case "front":
          println(deque.isEmpty() ? -1 : deque.getFirst());
          break;

        case "back":
          println(deque.isEmpty() ? -1 : deque.getLast());
          break;
      }
    }
    bw.flush();
    bw.close();
  }

  private static void println(Object arg) throws IOException {
    bw.write(arg.toString());
    bw.newLine();
  }
}
