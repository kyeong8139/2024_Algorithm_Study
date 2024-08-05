import java.util.Arrays;
import java.util.Scanner;

public class n과m5 {
	static int N;
	static int M;
	static int[] num;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);

		find(0, 0, "", visited);
		System.out.println(sb);

	}

	public static void find(int cnt, int i, String result, boolean[] visited) {
//		System.out.println(" " + result);
		if (cnt == M) {
			sb.append(result + "\n");
			return;
		}

		for (int sum = 0; sum < N; sum++) {
			if(!visited[sum]) {
					String str = num[sum] + " ";
					visited[sum]=true;
					find(cnt + 1, i+1, result + str, visited);
					visited[sum]=false;
//				}
			}

		}
	}

}