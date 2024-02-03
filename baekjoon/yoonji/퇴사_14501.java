import java.util.Scanner;

public class 퇴사_14510 {
	
	public static int N, result = 0;
	public static int[] T;
	public static int[] P;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int [N]; // 상담 기간
		P = new int [N]; // 기간에 따른 이익
		
		// 배열에 저장
		for(int i = 0; i < N ; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		// 재귀함수 호출
		findMaxProfit(0, 0);
		// 최대이익 출력
		System.out.println(result);
		
	}
	
	// 모든 상담 날짜에 대해 최대 이익 찾기
	// index: 현재 상담 진행 날짜
	// profit: 현재까지 이익
	public static void findMaxProfit(int index, int profit) {
		
		// 재귀호출 종료조건: 모든 날짜 다 봤을 때
		if(index >= N) {
			result = Math.max(result, profit);
			return;
		}
		// 상담 할 때: 상담이 가능한 날짜이면 상담 하기
		// 상담 시작 날 + 상담 소요 기간이 상담 가능한 일수 이하이면
		if(index + T[index] <= N) {
			//(상담 진행 시 끝나는 다음 날짜, 현재까지 이익에 상담 이익 더한 값)
			findMaxProfit(index + T[index], profit + P[index]);			
		}
		// 상담 안할 때: 날짜만 하루 더 이동
		findMaxProfit(index+1, profit);
	}

}
