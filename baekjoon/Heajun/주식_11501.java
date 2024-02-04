import java.util.Scanner;

public class 주식_11501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int N = sc.nextInt(); //전체 날 수
            int[] stock = new int[N]; //주식 수치 저장
            for(int i = 0; i< N; i++) {
                stock[i] = sc.nextInt();
            }
            long sum = 0; //long으로 int범위 초과 방지 
            long max = stock[N-1]; //최대값 저장
            for(int i = N-2; i>=0; i--){ //뒤에서 검사하면서 가장 큰 값과의 차이를 갱신 (시간 초과 방지)
                if(stock[i] < max){
                    sum += max - stock[i];
                }else{
                    max = stock[i];
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }

}
