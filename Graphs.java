import java.util.*;

public class Graphs {
    static class Edge {
        int curr;
        int neighbour;
        int wt;

        Edge(int curr, int neighbour, int wt){
            this.curr = curr;
            this.neighbour = neighbour;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();   // vertices
        int e = sc.nextInt();   // edges
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){

            addElemInDirectedGraph(adj,sc.nextInt(),sc.nextInt(), sc.nextInt());
        }


        DFSDisconnected(adj,v);
//        System.out.println("");
//        DFSDisconnected(adj,v);
    }
    public static void addElemInDirectedGraph(ArrayList<ArrayList<Edge>> adj, int i, int j, int wt){
        adj.get(i).add(new Edge(i,j,wt));
    }
    public static void addEdge(ArrayList<ArrayList<Edge>> adj, int i, int j,int wt){
        adj.get(i).add(new Edge(i,j,wt));
        adj.get(j).add(new Edge(j,i,wt));
    }
    public static void BFSHelper(ArrayList<ArrayList<Edge>> adj, int source, boolean[] visited){
        Myqueue<Integer> q = new Myqueue<>();
        visited[source] = true;
        q.enqueue(source);
        while(q.size>0){
            int u = q.front.data;
            System.out.print(u+" ");
            q.dequeue();
            for(Edge elem: adj.get(u)){
                int v  = elem.neighbour;
                if(!visited[v]){
                    visited[v] = true;
                    q.enqueue(v);
                }
            }
        }
    }
    public static void BFSDisconnected(ArrayList<ArrayList<Edge>> adj,int v){
//        int numIslands = 0;
        boolean[] visited = new boolean[v];
        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                BFSHelper(adj,i,visited);
//                numIslands++;
            }
        }
//        return numIslands;
    }
    public static void DFSHelper(ArrayList<ArrayList<Edge>> adj, int source, boolean[] visited){
        visited[source] = true;
        System.out.print(source+" ");
        for(Edge elem: adj.get(source)){
            int u  = elem.neighbour;
            if(!visited[u]){
                DFSHelper(adj,u,visited);
            }
        }
    }
    public static void DFSDisconnected(ArrayList<ArrayList<Edge>> adj,int v){
        boolean[] visited = new boolean[v];
        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                DFSHelper(adj,i,visited);
            }
        }
    }

    public static boolean detectCycleDFS(ArrayList<ArrayList<Edge>> adj,int v){
        boolean[] visited = new boolean[v];
        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                if(detectCycleDFSHelper(adj,i,visited,-1)) return true;
            }
        }
        return false;
    }
    public static boolean detectCycleDFSHelper(ArrayList<ArrayList<Edge>> adj, int source, boolean[] visited, int parent){
        visited[source] = true;
        for(Edge u: adj.get(source)){
            int elem = u.neighbour;
            if(!visited[elem]){
                if(detectCycleDFSHelper(adj,elem,visited,source)) return true;
            }
            else if(elem!=parent) return true;
        }
        return false;
    }
    public static boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj,int v){
        int[] inDegree = new int[v];
        for (ArrayList<Integer> temp : adj) {
            for (Integer integer : temp) {
                inDegree[integer]++;
            }
        }
        Myqueue<Integer> q = new Myqueue<>();
        for(int i = 0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.enqueue(i);
            }
        }
        int count = 0;
        while (q.size > 0) {
            int u = q.front.data;
            count++;
            q.dequeue();
            for (int elem : adj.get(u)) {
                inDegree[elem]--;
                if(inDegree[elem]==0){
                    q.enqueue(elem);
                }
            }
        }
        return count!=v;
    }

    public static void topologicalSortDFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] visited = new boolean[v];
        Mystack<Integer> st = new Mystack<>();
        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                topologicalSortDFSHelper(adj,i,visited,st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println("");
    }
    public static void topologicalSortDFSHelper(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, Mystack<Integer> st){
        visited[source] = true;

        for(int u:adj.get(source)){
            if(!visited[u]){
                topologicalSortDFSHelper(adj,u,visited,st);
            }
        }
        st.push(source);
    }

    public static void topologicalSortBFS(ArrayList<ArrayList<Integer>> adj, int v){
        int[] inDegree = new int[v];
        for (ArrayList<Integer> temp : adj) {
            for (Integer integer : temp) {
                inDegree[integer]++;
            }
        }
        Myqueue<Integer> q = new Myqueue<>();
        for(int i = 0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.enqueue(i);
            }
        }
        while (q.size > 0) {
            int u = q.front.data;
            System.out.print(u + " ");
            q.dequeue();
            for (int elem : adj.get(u)) {
                inDegree[elem]--;
                if(inDegree[elem]==0){
                    q.enqueue(elem);
                }
            }
        }
    }
}
