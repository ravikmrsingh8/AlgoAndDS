package com.example.misc.competitive;



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
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    void close() {
        try {
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

