import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 특정한최단경로_1504 {

    static class Node{
        int a, b, value;

        Node(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N =Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        TreeSet<Node> set = new TreeSet<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value == o2.value) {
                    return -1;
                }
                return o1.value - o2.value;
            }
            
        });

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(bf.readLine());
            set.add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }

        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
        arr[Math.max(a, b)] = Math.min(a, b);

        while(true) {
            Node n = set.pollFirst();
            a = find(n.a); b = find(n.b);
            if(a != b) {
                arr[Math.max(a, b)] = Math.min(a, b);
            }
        }

    }

    private static int find(int a) {
        if(a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
