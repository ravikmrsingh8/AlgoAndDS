package com.example.misc.competitive;
<<<<<<< HEAD


import java.util.*;
import java.io.*;


class TestClass {
    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        int K = in.nextInt();
        Constant.PER_HOUR_COST = K;

        int N = in.nextInt();
        int X = in.nextInt();
        Graph g = new Graph(N);
        for(int x=0; x< X; x++) {
            g.addEdge(in.nextInt()-1,in.nextInt()-1, in.nextInt(), in.nextLong());
        }

        int S = in.nextInt()-1;
        int D = in.nextInt()-1;


        new Dijkstra().run(g, S);
        if(g.vertices().get(D).key == Integer.MAX_VALUE){
            System.out.println("Error");
        } else {
            Stack<Integer> stack = new Stack<Integer>();
            int dest = D;
            int flights = 0;

            stack.push(dest);
            do {
                dest = g.vertices().get(dest).prev;
                flights++;
                stack.push(dest);
            } while(dest != S);


            stats(g, stack, flights, dest);

        }

    }

    static void stats(Graph g, Stack<Integer> stack, int flights, int dest) {
        boolean intermediateNodes = false;
        StringBuilder sb = new StringBuilder();
        sb.append(stack.pop());
        if(stack.size()>=2) {
            sb.append("->");
            sb.append("[");
            intermediateNodes = true;
        }

        while(stack.size() > 1) {
            sb.append(stack.pop());
            sb.append("->");
        }
        if(intermediateNodes) sb.append("]");
        sb.append("->");
        sb.append(stack.pop());
        sb.append(" ").append(g.vertices().get(dest).time + (flights-1));
        sb.append(" ").append(g.vertices().get(dest).key + (flights-1)*Constant.PER_HOUR_COST);
        System.out.println(sb);

    }
}

class Constant {
    static int PER_HOUR_COST = 1000;
}

class Vertex implements Comparable<Vertex> {
    public int id;
    public boolean visited;
    public long key;
    public long time;

    //All neighbour vertices of this vertex and edge from this vertex;
    public Map<Integer, Edge> edges;
    int prev;

    public Vertex(int id) {
        this.id = id;
        key = Integer.MAX_VALUE;
        edges = new HashMap<>();
        prev = -1;
    }

    public Map<Integer, Edge> getEdges() {
        return edges;
    }

    @Override
    public int compareTo(Vertex o) {
        return key < o.key ? -1 : 1;
    }
}

class Edge {
    public int src;
    public int dest;
    public int time;
    public long cost;

    public Edge(int src, int dest, int time, long cost){
        this.src = src;
        this.dest = dest;
        this.cost = cost;
        this.time = time;
    }

}

class Graph {
    public int N;
    public Map<Integer, Vertex> vertices;


    public Graph(int N) {
        this.N = N;
        vertices = new HashMap<>();
        for (int id = 0; id < N; id++) {
            vertices.put(id, new Vertex(id));
        }
    }

    public void addEdge(int src, int dest, int time, long cost) {
        Vertex srcVtx = vertices.get(src);
        Vertex destVtx = vertices.get(dest);
        if(!srcVtx.getEdges().containsKey(dest) || srcVtx.getEdges().get(dest).cost + time * Constant.PER_HOUR_COST > cost) {
            srcVtx.getEdges().put(dest, new Edge(src, dest,  time,cost));
            destVtx.getEdges().put(src,new Edge(dest, src,  time,cost));
        }
    }

    public Map<Integer, Vertex> vertices() {
        return vertices;
    }

}

class Dijkstra {
    public void run(Graph G, int src) {
        Map<Integer, Vertex> vertices = G.vertices();
        Vertex v0 = vertices.get(src);
        v0.key = 0;
        Queue<Vertex> q = new PriorityQueue<>();
        q.offer(v0);
        boolean[] visited = new boolean[G.N];

        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (!visited[u.id]) {
                visited[u.id] = true;
                u.getEdges().forEach((v, e) -> {
                    if (!visited[v]) {
                        Vertex dest = vertices.get(v);

                        if (u.key + e.cost + e.time * Constant.PER_HOUR_COST < dest.key) {
                            dest.key = e.cost + e.time * Constant.PER_HOUR_COST;
                            dest.prev = u.id;
                            dest.time = u.time + e.time;
                            q.offer(dest);
                        }
                    }
                });
            }
        }
    }
}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {st = new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();}
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine(){
        String str = "";
        try {str = br.readLine();} catch (IOException e) {e.printStackTrace();}
        return str;
    }
    void close(){
        try{br.close();	}catch(IOException ioe){ioe.printStackTrace();}

=======
import java.io.*;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        FastScanner in = new FastScanner(new FileInputStream("input.txt"));
        //FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Graph g = new Graph(N);
        for(int i=0;i<M;i++){
            g.addEdge(in.nextInt(), in.nextInt(), in.nextLong());
        }
        //System.out.println(g);
        System.out.println(g.prim());

    }


    static class Graph{
        int N;
        Map<Integer, Vertex> vertices = new HashMap<>();
        Graph(int N) {
            this.N = N;
            for(int i=1;i<=N;i++)vertices.put(i, new Vertex(i));
        }

        void addEdge(int src, int dest, long cost) {
            Vertex srcv = vertices.get(src);
            Vertex destv = vertices.get(dest);
            if(!srcv.edges.containsKey(dest) ){
                srcv.edges.put(dest, cost);
                destv.edges.put(src, cost);
            } else if(srcv.edges.get(dest) > cost) {
                srcv.edges.put(dest, cost);
                destv.edges.put(src, cost);
            }
        }

        long prim() {
            boolean[] visited = new boolean[N+1];
            Queue<Vertex> q = new PriorityQueue<Vertex>(16, (v1,v2)-> (int)(v1.key - v2.key));
            Vertex v1 = vertices.get(1);
            v1.key = 0;
            q.offer(v1);
            long cost = 0;
            while(!q.isEmpty()) {
                Vertex u = q.poll();
                if(!visited[u.id]) {
                    //System.out.println("Visiting " + u.id);
                    cost += u.key;
                    visited[u.id] = true;
                    u.edges.forEach((v, w)->{
                        if(!visited[v]) {
                            Vertex dest = vertices.get(v);
                            if(dest.key > w) {
                                dest.key = w;
                                q.offer(new Vertex(dest));
                            }
                        }
                    });
                }

            }
            return cost;
        }

        public String toString() {
            return vertices.toString();
        }

    }

    static class Vertex {
        int id;
        long key;
        Map<Integer, Long> edges = new HashMap<>();
        Vertex(int id) {
            this.id = id;
            this.key = Integer.MAX_VALUE;
        }

        public Vertex(Vertex v) {
            this.id = v.id;

            this.key = v.key ;
            this.edges = v.edges;
        }


        public String toString(){
            return id + " ->" + edges;
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
>>>>>>> 78102df6b6e103e2d96603ea85b3f0cfe30eaf1e
    }
}

