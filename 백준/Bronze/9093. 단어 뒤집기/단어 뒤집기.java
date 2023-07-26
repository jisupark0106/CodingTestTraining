import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder result = new StringBuilder();

      while (st.hasMoreElements()) {
        String s = st.nextToken();
        result.append(new StringBuilder(s).reverse());

        if (st.hasMoreElements()) {
          result.append(" ");
        }
      }
      System.out.println(result);
    }
  }
}
