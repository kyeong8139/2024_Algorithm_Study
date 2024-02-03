package baekjoon.doeun._14501.퇴사;

import java.util.Scanner;

//뭔가 재귀함수를 쓰려고 했는데요...
//암튼 대충 아이디어 있는데 재귀함수 이해를 못해서 이상하게 구현한듯요..
//내일 소그룹 모임때 물어보려고 합니도

public class 퇴사_14501 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 퇴사까지 남은 일수

		int[] T = new int[N]; // 걸리는 기간
		int[] P = new int[N]; // 받는 돈

		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		int sum = 0;
		
		sum += P[findIdx(N-1, T)];
		
		System.out.println(sum);
	}
	
	public static int findIdx(int N, int[] T) {
		
		if(N-1==0) {
			return T[N-1]; //한칸 일떄
		}
		else {
			return T[N-1] + T[findIdx(N-1, T)]; //계속 넣어줌
		}
		
	}
}
