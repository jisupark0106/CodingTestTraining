import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      char[] charArray = br.readLine().toCharArray();
      System.out.println(checkPs(charArray));
    }
  }

  public static String checkPs(char[] charArray) {
    int count = 0;
    
    if (charArray.length % 2 != 0) {
      return "NO";
    }

    for (char c : charArray) {
      if (c == '(') {
        count++;
      } else {
        if (count <= 0) {
          return "NO";
        }
        count--;
      }
    }
    if (count == 0) {
      return "YES";
    }
    return "NO";
  }
}
