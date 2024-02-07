import java.util.Scanner;

public class Main{
	
	static int N;
	static int min = Integer.MAX_VALUE; 
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 수열 입력
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 연산자 입력
		int[] operators = new int[4];
		for (int i = 0; i < operators.length; i++) {
			operators[i] = sc.nextInt();
		}
		
		// 완전탐색 계산 수행
		calcurate(arr[0], 0, operators);
		
		// 출력
		System.out.println(max);
		System.out.println(min);
	}
	
	/**
	 * cnt + 1번째 연산을  수행
	 * @param cur : 현재까지의 계산 결과
	 * @param cnt : 이때까지 연산한 횟수
	 * @param operators : 남은 연산자 사용 횟수 배열 (+, - , * , /)
	 * @return
	 */
	public static void calcurate(int cur, int cnt, int[] operators) {
		if (cnt == N - 1) {
			min = Math.min(cur, min);
			max = Math.max(cur, max);
			return;
		}
		
		// 모든 연산자를 넣어보며 완전탐색
		for (int i = 0; i < operators.length; i++) {
			// 남은 연산 기회가 없으면 continue
			if (operators[i] <= 0) {
				continue;
			}
			
			// cnt+1번째 연산결과를 저장하기 위한 변수 result
			int result = cur; 
			int nextNum = arr[cnt + 1]; // 피연산자
			operators[i]--;
			
			switch (i) {
			case 0:
				result += nextNum;
				break;
			case 1:
				result -= nextNum;
				break;
			case 2:
				result *= nextNum;
				break;
			case 3:
				// 음수를 양수로 나늘 때는 양수로 바꾼 뒤 몫을 취하고 그 몫을 음수로 바꿈
				if (result < 0 && nextNum > 0) {
					result *= -1;
					result /= nextNum;
					result *= -1;
				} else {
					result /= nextNum;
				}
				break;
			}
			
			calcurate(result, cnt + 1, operators);
			operators[i]++;
		}
	}
}