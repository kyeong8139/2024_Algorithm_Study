import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class N과M_15649 {
    static ArrayList<Integer> ar = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] arr = new int[N];
        int[] pointer = new int[P];

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<P;i++) {
            q.add(i+1);
            arr[i] = i+1;
            pointer[i] = i;
        }
        for(int i=P;i<N;i++) {
            arr[i] = i+1;
            q.add(i+1);
        }
        int[] ans = new int[P];
        func(ans, q, N, P, 0);

        // for(int i=0;i<N-P+1;i++) {
        //     for(int ans : pointer) {
        //         System.out.println(arr[ans]);
        //     }
        //     pointer[pointer.length-1]++;
        // }
        // while(pointer[pointer.length-1] != arr.length -1) {
        //     if(pointer[pointer.length-1] == arr.length -1) {

        //     }
        //     for(int ans : pointer) {
        //         System.out.println(arr[ans]);
        //     }
        //     pointer[pointer.length-1]++;
        // }
    }
    static void func(int[] ans, PriorityQueue<Integer> q, int N, int P, int idx) {
        if(P==0) {
            for(int a : ans) {
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        } 

        for(int i=0;i<N-P+1;i++) {
            int[] t = ans;
            if(idx==0) {
                t[idx] = i+1;
                q.remove(t[idx]);
            } else {
                t[idx] = q.poll();
            }
            // System.out.println("t[idx] == "+t[idx]);
            ar.add(t[idx]);
            func(t, q, N-1, P-1, idx+1);
        }
        for(int i=0;i<ar.size();i++) {
            q.add(ar.get(i));
        }
        ar.clear();
    }
}