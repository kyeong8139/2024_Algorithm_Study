import java.util.Scanner;
// 
public class 퇴사_14501 {
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][2];

		for (int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		} // 입력부
		System.out.println(check(arr,1,n,0));
	}

	public static int check(int[][] arr, int day, int lday, int money) { // 배열, 현재 날짜, 마지막날, 돈
		if (max < money) {
			max = money;
		}
		if (day > lday) {
			return max; 
		}
		int nday = day+arr[day][0]; // 오늘 할수 있는 작업을 했을때의 날
		if (nday<=lday+1) {
			check(arr,nday,lday,money+arr[day][1]); // 하기로 결정			
		}
		check(arr,day+1,lday,money); // 안하기로 결정
		return max;
	}
}
