import java.util.Scanner;

public class 가장긴증가하는부분수열_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] cnt = new int[51];
		int[] num = new int[N];
		for(int i = 0; i<N; i++) {
			num[i]=(sc.nextInt());
		}
		
		int max = 1;
		cnt[num[0]]++;
		
		for(int i=1; i<N; i++) {
			int temp = 0;
			for(int j=i-1; j>=0; j--) {
				if(num[j]<num[i]) {
					cnt[num[i]] = Math.max(cnt[num[i]],cnt[num[j]]+1);
				}
			}
			if(cnt[num[i]]==0)
				cnt[num[i]]++;
			max = Math.max(max, cnt[num[i]]);
//			System.out.println(Arrays.toString(cnt));
		}
		
		System.out.println(max);
		
	}

}
