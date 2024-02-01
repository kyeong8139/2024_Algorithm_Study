import java.util.Scanner;

public class 컴백홈_1189 {
    static char[][] arr = null;
    static int routeCnt = 0;
    static int ansCnt = 0;

    static int[][] routeSave = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        routeCnt= sc.nextInt();

        arr = new char[n][m];
        routeSave = new int[n][m];

        for(int i=0;i<n;i++) {
            arr[n] = sc.nextLine().toCharArray();
        }

    }

    // //(n-1, 0)에서 (0, m-1)까지 cnt로 가는 가지수 
    // static int getRoute(int x, int y, int cnt) {

    //     //x,y, cnt가 음수이거나 나올 수 없는 수라면 종료
    //     while(x>0 && x<arr.length && y>=0 && y<arr[0].length && cnt>0) {
            
            

    //         //간 곳에 장애물이 있다면 함수 종료
    //         if(arr[x][y]=='T') {
    //             return 0;
    //         }
    //     }



    //     //저장된 값이 있다면
    // }

}
