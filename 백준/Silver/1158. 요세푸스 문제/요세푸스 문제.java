import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    String[] arg = br.readLine().split(" ");

    int N = Integer.parseInt(arg[0]);
    int jumpIndex = Integer.parseInt(arg[1]) - 1;

    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      l.add(i, i + 1);
    }

    int removed = 0;
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      removed += jumpIndex;
      while (l.size() <= removed) {
        removed = removed - l.size();
      }
      result[i] = l.remove(removed);
    }

    System.out.println(Arrays.toString(result).replace("[", "<").replace("]", ">"));

  }

}
