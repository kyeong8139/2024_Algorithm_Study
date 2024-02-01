import java.util.Scanner;

public class 퇴사_14501{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] term = new int[N + 1];
		int[] value = new int[N + 1];

		int[] max = new int[N + 6];

		for (int i = 1; i <= N; i++) {
			term[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		int result = 0;

		for (int i = 1; i <= N; i++) {
//			System.out.println(max[term[i] - 1 + i] + " " + (value[i] + max[i - 1]));
			max[term[i] - 1 + i] = Math.max(max[term[i] - 1 + i], value[i] + max[i - 1]);

			max[i] = Math.max(max[i - 1], max[i]);
//			System.out.println(Arrays.toString(max));
		}

		for (int i = 1; i <= N; i++) {
			result = Math.max(result, max[i]);

		}
		System.out.println(result);
	}

}
