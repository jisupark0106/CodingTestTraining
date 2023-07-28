import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Node {

    int index;
    int priority;

    Node(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      String[] info = br.readLine().split(" ");

      StringTokenizer st = new StringTokenizer(br.readLine());
      // 우선순위 정렬
      List<Integer> priorities = new ArrayList<>();
      // 큐에 들어간 도큐먼트
      Queue<Node> document = new ArrayDeque<>();

      for (int j = 0; j < Integer.parseInt(info[0]); j++) {
        int priority = Integer.parseInt(st.nextToken());
        priorities.add(priority);
        document.add(new Node(j, priority));
      }
      // 타겟 인덱스 지정
      int targetIndex = Integer.parseInt(info[1]);
      // 우선순위 정렬
      priorities.sort(Collections.reverseOrder());
      
      // 큐에서 하나씩 뽑아서
      // 1. 우선순위가 맞는지
      // 2. 우선순위가 아니면 document의 맨 뒤로 보냄
      // 3. 우선순위가 맞아 ? 출력 -- 우선순위 리스트에서 제거, 큐에서 제거
      // 4. result count 둬서 +1 target Index 면 출력하고 종료

      int printCount = 0;

      while (true) {
        Node n = document.remove();

        if (priorities.get(0) != n.priority) {
          document.add(n);
          continue;
        }

        priorities.remove(0);
        printCount++;

        if(n.index == targetIndex){
          System.out.println(printCount);
          break;
        }
      }
    }
  }
}
