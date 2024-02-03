import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 주식_11501 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] arr = new String[n][];

        for(int i=0;i<n;i++) {
            sc.nextLine();
            arr[i] = sc.nextLine().split(" ");
            ans = 0;
            getMax(arr[i]);
            System.out.println(ans);
        }



    }

    private static void getMax(String[] arr) { 
        int[][] getIndexArr = new int[arr.length][2];
        for(int i=0;i<getIndexArr.length;i++) {
            getIndexArr[i][0] = Integer.parseInt(arr[i]);
            getIndexArr[i][1] = i;
        }
        
        Arrays.sort(getIndexArr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
            
        });

        if(getIndexArr[0][0] == Integer.parseInt(arr[0])) {
            return;
        }

        for(int i=0;i<getIndexArr[0][1];i++) {
            ans += getIndexArr[0][0] - Integer.parseInt(arr[i]);
        }

        if(getIndexArr[0][1]!=arr.length-1) {
            String[] getBenefit = new String[arr.length-getIndexArr[0][1]-1];
            for(int i=0;i<getBenefit.length;i++) {
                getBenefit[i] = arr[i+getIndexArr[0][1]+1];
            }
            getMax(getBenefit);
        }
    }
}
