import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 트리의지름_1967 {
    static class Temp {
        int b, value;

        Temp(int b, int value) {
            this.b = b;
            this.value = value;
        }
    }
    static int max;
    static int arr[][];
    static ArrayList<Temp> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        list = new ArrayList[N];

        for(int i=0;i<N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());

            list[a].add(new Temp(b, c));
        }
        max = 0;
        getLength(0);
        System.out.println(max);
        
    }  
    static int getLength(int num) {

        int maxValue = Integer.MIN_VALUE;
        int maxNode = -1;

        for(Temp t: list[num]) {
            if(t.value > maxValue) {
                maxValue = t.value; maxNode = t.b;
            }
        }

        if(maxNode == -1) {
            return 0;
        }
        if(list[num].size()==1){
            int aa = getLength(list[num].get(0).b)+list[num].get(0).value;
            max = Math.max(aa, max);
            return aa;
        }
        if(list[num].size()>=2){
            PriorityQueue<Integer> que = new PriorityQueue<>((a, b)->b-a);
            for(Temp t : list[num]){
                que.add(getLength(t.b)+t.value);
            }
            int tmp1 = que.poll();
            int tmp2 = que.poll();
            max = Math.max(max, tmp1+tmp2);
            return tmp1;

        }
        return 0;
    }
}
