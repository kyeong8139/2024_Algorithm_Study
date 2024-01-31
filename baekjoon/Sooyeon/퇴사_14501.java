import java.util.*;

public class 퇴사_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        getOnWork(arr, 0, 0);

        System.out.println(max);
        
    }

    //최대 일수
    static int max =0;

    //일 하는 날짜가 x.
    static void getOnWork(int[][] arr, int x, int salary) {

        //x일이 퇴사일을 안넘기면서 x일의 상담이 1일을 넘어가면, x+1일의 급여 계산
        if(x<arr.length && arr[x][0]>1) {
            getOnWork(arr, x+1, salary);
        }
        //x일이 퇴사일, x일에 일을 하면 퇴사 전까지 끝낼 수 없는 경우
        if(x>= arr.length || x+arr[x][0]>arr.length) {
            max = max < salary ? salary : max;
        } else {
            //나머지 경우
            getOnWork(arr, x+arr[x][0], salary+arr[x][1]);
        }
    }
}