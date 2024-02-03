import java.util.Scanner;

public class 주식_11501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			Long result = 0L;

			for (int j = 0; j < N; j++) { // 입력 받기
				arr[j] = sc.nextInt();
			}
			int max = 0;
			for (int j = N - 1; j >= 0; j--) { // 뒤에서부터 조회
				if (arr[j] > max) // 최대값 갱신
					max = arr[j];
				else
					result = result + max - arr[j]; // 차액 저장
			}
			System.out.println(result);

		}
	}
}