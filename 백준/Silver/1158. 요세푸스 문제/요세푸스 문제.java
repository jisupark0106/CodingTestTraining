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
    int jump = Integer.parseInt(arg[1]) - 1;

    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      l.add(i, i + 1);
    }

    int index = 0;
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      index += jump;
      
      if (l.size() <= index) {
        index = index % l.size();
      }
      result[i] = l.remove(index);
    }

    System.out.println(Arrays.toString(result).replace("[", "<").replace("]", ">"));
  }
}
