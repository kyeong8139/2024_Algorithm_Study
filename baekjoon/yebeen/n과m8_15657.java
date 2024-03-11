import java.util.Arrays;
import java.util.Scanner;

public class n과m8 {
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

		find(0, 0, -1, "", visited);
		System.out.println(sb);

	}

	public static void find(int cnt, int i, int exnum, String result, boolean[] visited) {
//		System.out.println(" " + result);
		if (cnt == M) {
			sb.append(result + "\n");
			return;
		}

		for (int sum = 0; sum < N; sum++) {
			if (cnt == 0) {
				String str = num[sum] + " ";
//				visited[sum] = true;
				find(cnt + 1, i + 1, num[sum], result + str, visited);
//				visited[sum] = false;
			} else {
				if (exnum <= num[sum]) {
//					if (!visited[sum]) {
						String str = num[sum] + " ";
						visited[sum] = true;
						find(cnt + 1, i + 1, num[sum], result + str, visited);
//						visited[sum] = false;
//					}
				}
			}

		}
	}

}
/*
 * public static void find(int cnt, int exidx, String result) { //
 * System.out.println(" " + result); if (cnt == M) { sb.append(result + "\n");
 * return; }
 * 
 * for (int sum = 0; sum < N; sum++) { if (cnt == 0) { String str = num[sum] +
 * " "; find(cnt + 1, num[sum], result + str); } else { if (exidx <= num[sum]) {
 * String str = num[sum] + " "; find(cnt + 1, num[sum], result + str); } }
 * 
 * } }
 */
