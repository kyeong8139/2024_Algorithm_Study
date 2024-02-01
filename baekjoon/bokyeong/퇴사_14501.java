/**
 * 브랜치 적용
 */
import java.util.Scanner;

public class Main{
	
	static int money = 0;
	static int N;
	
	static int[] times;
	static int[] pays;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		times = new int[N + 1];
		pays = new int[N + 1];
		
		// 0에는 더미데이터로서 1 추가 (다음날로 넘어갈 수 있도록)
		times[0] = 1;
		for (int i = 1; i <= N; i++) {
			times[i] = sc.nextInt();
			pays[i] = sc.nextInt();
		}
		
		getMoney(0, 0);
		
		System.out.println(money);
	}
	
	public static void getMoney(int startDay, int cur) {
		// 오늘을 포함하므로 끝나는 날은 오늘 날짜 + 걸리는 시간 - 1 (당일)
		int endDay = startDay + times[startDay] - 1;
		// 끝나는 날이 N+1일째면 종료
		if (endDay > N) {
			return;
		}
		
		cur += pays[startDay];
		money = Math.max(cur, money);
		
		// 끝난 다음날부터 상담을 잡음
		for (int i = endDay + 1; i <= N; i++) {
			getMoney(i, cur);
		}
	}
}