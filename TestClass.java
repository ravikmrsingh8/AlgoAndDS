
import java.io.*;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Graph g = new Graph(N);
        for(int i=0;i<M;i++){
            g.addEdge(in.nextInt()-1, in.nextInt()-1, in.nextInt());
        }
        //System.out.println(g);
        System.out.println(g.prim());

    }


static class Graph {
    int N;
    List<Vertex> vertices = new ArrayList<>();
    public Graph(int N){
        this.N = N;

        for(int i=0;i<N; i++){
            vertices.add(new Vertex(i));
        }
    }
    public void addEdge(int src, int dest, int cost) {
        Vertex srcv = vertices.get(src);
        Vertex destv = vertices.get(dest);
        if(!srcv.edges.containsKey(dest) || srcv.edges.get(dest).cost > cost) {
            Edge edge1 = new Edge(src, dest, cost);
            Edge edge2 = new Edge(dest, src, cost);
            srcv.edges.put(dest, edge1);
            destv.edges.put(src, edge2);
        }

    }


    long prim() {
        boolean[] visited = new boolean[N];

        //List<Edge> mstEdges = new ArrayList<>();
        Edge edge0 = new Edge(-1, 0, 0);
        Queue<Edge> pq  =  new PriorityQueue<>(16, (e1, e2)->e1.cost-e2.cost);
        pq.offer(edge0);
        long cost = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(visited[e.dest]) continue;

            cost += e.cost;
            visited[e.dest] = true;
            //mstEdges.add(e);

            vertices.get(e.dest).edges.forEach((dest, edge)->{
                if(!visited[dest]) {
                    pq.offer(edge);
                }
            });
        }
        //System.out.println("cost :" + cost);
        return cost;
    }
}
static class Vertex {
    int id;
    int key;
    int prev;
    Map<Integer,Edge> edges= new HashMap<>();
    public Vertex(int id) {
        this.id = id;
        key = Integer.MAX_VALUE;
        prev = -1;
    }
 }
    
static class Edge {
    int src;
    int dest;
    int cost;

    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }

}
    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

