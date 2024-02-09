import java.util.*;
//주석 
public class 퇴사_14501 {
    public static void main(String[] args) {
        //dp를 이용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] num = new int[N + 2][2];
        for (int i = 1; i <= N; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }
        int[] dp = new int[N+2];
        int max = 0;//최댓값
        for(int i = 1; i <= N+1; i++) { //1부터 퇴직하는 n+1의 날까지
            dp[i] = Math.max(max, dp[i]); //i날 벌 수 있는 최대값 해당 dp값은 최대값과 해당 값과의 비교후 높은 값을 설정 
            if(i+num[i][0] <= N+1) {//일 끝난 다음날에 돈을 받는다는 가정이기 때문에 10일에 끝나면 11일날 퇴직할 때 받는다는 의미 
                dp[i+num[i][0]] = Math.max(dp[i+num[i][0]],dp[i] + num[i][1]); //일이 끝난 다음날짜에 돈이 들어감
                //현재 벌고 있는 금액 + 일 끝나면 버는 돈, 다른 날에 일을 했었을 때 그날에 받을 예정인 돈 중 더 큰 것으로 갱신 
            }
            max = Math.max(max, dp[i]);//최대값을 갱신 
        }

        System.out.println(max); //마지막 날의 값이 아닌 최댓값을 찾는 것 
    }
}
