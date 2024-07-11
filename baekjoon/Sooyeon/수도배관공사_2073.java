import java.io.*;
import java.util.*;

/**
 * 수도배관공사_2073
 */
public class 수도배관공사_2073 {
    static class Pipe {
        int L, C;

        Pipe(int L, int C) {
            this.L = L;
            this.C = C;
        }

    }
    static int D, P;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        D = Integer.parseInt(st.nextToken()); P = Integer.parseInt(st.nextToken());
        List<Pipe> arr = new ArrayList<>();
        for(int i=0;i<P;i++) {
            st = new StringTokenizer(bf.readLine());
            arr.add(new Pipe(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr, new Comparator<Pipe>() {

            @Override
            public int compare(Pipe o1, Pipe o2) {
                if(o1.L == o2.L) {
                    return 1;
                }
                return o1.L - o2.L;
            }
            
        });

        
    }
}