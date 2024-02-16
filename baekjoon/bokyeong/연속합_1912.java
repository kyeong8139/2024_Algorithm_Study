import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}
}
