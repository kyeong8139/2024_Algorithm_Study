package BOJ;

import java.util.Scanner;

public class 퇴사_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 일자 입력 받기
		int[] Ti = new int[N];
		int[] Pi = new int[N];
		int[] total = new int[N + 1]; // 해당 날짜에 벌 수 있는 최대 금액 배열

		for (int i = 0; i < 2 * N; i++) { // 입력 받는 값 각각 Ti와 Pi에 저장
			if (i % 2 == 0)
				Ti[i / 2] = sc.nextInt();
			else
				Pi[i / 2] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (i >= 1 && total[i] < total[i - 1]) // 현재 날짜의 total 값이 이전 날짜보다 작으면 이전 날짜의 total 값이 이월 됨
				total[i] = total[i - 1];
			if (Ti[i] + i > N) // 상담완료 날짜 N초과시 다음 날짜로 넘어감
				continue;
			if (total[Ti[i] + i] < total[i] + Pi[i]) // total이 최대 값일 경우 갱신
				total[Ti[i] + i] = total[i] + Pi[i];
		}
		int max = 0;
		for (int i = 0; i < N + 1; i++) { //total 배열중 최대값 출력
			if (max < total[i])
				max = total[i];
		}
		System.out.println(max);
	}
}