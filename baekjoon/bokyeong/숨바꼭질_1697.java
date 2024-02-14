import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		
		boolean[] isVisited = new boolean[100001];
		isVisited[N] = true;
		
		int ans = Integer.MAX_VALUE;
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				int cur = queue.poll();
				if (cur == K) {
					ans = level;
				}
				
				if (cur <= 50000 && cur < K && !isVisited[cur * 2]) {
					isVisited[cur * 2] = true;
					queue.offer(cur * 2);
				}
				
				if (cur < K && !isVisited[cur + 1]) {
					isVisited[cur + 1] = true;
					queue.offer(cur + 1);
				}
				
				if (cur > 0 && !isVisited[cur - 1]) {
					isVisited[cur - 1] = true;
					queue.offer(cur - 1);
				}
				
				size--;
			}
			
			level++;
			if (level >= ans) {
				break;
			}
		}
		
		System.out.println(ans);
	}
}
