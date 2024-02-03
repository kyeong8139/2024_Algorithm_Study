import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			// 답은 부호 있는 64비트 정수형으로 표현 가능함
			long answer = 0L;
			int N = sc.nextInt();

			// 주가 입력 받음
			int[] prices = new int[N + 2];
			for (int i = 1; i <= N; i++) {
				prices[i] = sc.nextInt();
			}

			// 가장 높은 가격을 찾기 위한 Idx 변수
			int startDay = 1;
			int maxDay = -1;

			// 탐색 시작일이 N-1일 이내 (N일일 경우, MAX여도 판매할 날이 없음)
			while (startDay < N) {

				int maxPrice = 0;
				boolean isDown = true; // 계속 내림세인지 계산할 변수
				
				for (int i = startDay; i <= N; i++) {
					// maxPrice가 동일할 경우에도 maxDay를 갱신해줌
					if (prices[i] >= maxPrice) {
						maxDay = i;
						maxPrice = prices[i];
					}
					
					if (prices[i] < prices[i+1]) {
						isDown = false;
					}
				}

				// maxIdx가 startDay와 같은 경우(내림세) 탐색 종료
				if (isDown) {
					break;
				}

				long profit = 0L; // max값보다 작거나 같아서 구매한 금액의 총합
				for (int i = startDay; i < maxDay; i++) {
					profit += (long) maxPrice - (long) prices[i];
				}

				answer += profit; // 이득 계산
				startDay = maxDay + 1; // max값의 다음날부터 다시 탐색
			}

			System.out.println(answer);
		}
	}
}