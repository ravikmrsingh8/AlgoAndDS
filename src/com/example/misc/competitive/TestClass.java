package com.example.misc.competitive;
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
    }
}

