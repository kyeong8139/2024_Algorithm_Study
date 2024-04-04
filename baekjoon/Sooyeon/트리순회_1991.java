import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리순회_1991 {

    static int[][] info;

    static class Node{
        char data;
        char leftEdge, rightEdge;

        Node(char data) {
            this.data = data;
        }

        Node(char data, char leftEdge, char rightEdge) {
            this.data = data;
            this.leftEdge =leftEdge;
            this.rightEdge = rightEdge;
        }

    }

    static ArrayList<Node>[] list;
    static ArrayList<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        list = new ArrayList[N];
        info = new int[2][];

        for(int i=0;i<N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) { 
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int idx = st.nextToken().charAt(0) - 65;
            int[] temp = new int[2];
            
        }
    }
}
=======
import java.util.StringTokenizer;


public class 트리순회_1991 {
    static Node[] tree;
    static class Node {
        char value;
        Node left;
        Node right;
    
        Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N]; // 노드 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            char parent = st.nextToken().charAt(0); 
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            if (tree[parent - 'A'] == null) { 
                tree[parent - 'A'] = new Node(parent); // 부모 노드를 생성
            }

            if (left != '.') { // 왼쪽 자식이 존재할 경우
                tree[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
                tree[parent - 'A'].left = tree[left - 'A']; // 부모 노드와 연결
            }
            if (right != '.') { // 오른쪽 자식이 존재할 경우
                tree[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
                tree[parent - 'A'].right = tree[right - 'A']; // 부모 노드와 연결
            }
        }

        // 전위 순회
        preorder(tree[0]);
        sb.append("\n");

        // 중위 순회
        inorder(tree[0]);
        sb.append("\n");

        // 후위 순회
        postorder(tree[0]);
        System.out.println(sb);
    }

    
    // 전위 순회
    public static void preorder(Node node) {

        if (node == null) {
            return;
        }

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);

        sb.append(node.value);
    }
}
>>>>>>> 4e97efd6fe6e87e55a99f3bd66c85b379435285f
