import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   static class Pair implements Comparable<Pair>{
       int v; // aquiring vertex
       String psf;  // path so far
       int wsf;     // weight so far
       
       Pair(int v, String p, int w)
       {
           this.v = v;
           this.psf = p;
           this.wsf = w;
       }
       
       public int compareTo(Pair p) {
           return this.wsf - p.wsf;
       }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, src+"", 0));
      
      boolean[] visited = new boolean[vtces];
      while(pq.size()>0)
      {
          Pair p = pq.remove();
          
          if(visited[p.v]==true)
          continue;
          
          visited[p.v] = true;
          System.out.println(p.v+" via "+p.psf+" @ "+p.wsf);
          for(Edge e:graph[p.v])
          {
              if(visited[e.nbr]==false)
              {
                  pq.add(new Pair(e.nbr, p.psf+e.nbr, p.wsf+e.wt));
              }
          }
      }
      
      
   }
}