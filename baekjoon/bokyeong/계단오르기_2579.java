import java.util.Scanner;

public class 계단오르기_2579{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] steps = new int[N+1];
		for (int i = 1; i <= N; i++) {
			steps[i] = sc.nextInt(); 
		}
		
		int[] dp = new int[N+1];
		dp[1] = steps[1];
		if (N >= 2) {
			dp[2] = steps[1] + steps[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + steps[i-1] + steps[i], dp[i-2] + steps[i]);
		}
		
		System.out.println(dp[N]);
	}
}
