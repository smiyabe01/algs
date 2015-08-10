import java.util.Arrays;

public class QuickUnionUF
{

   private int[] parent;
   private int count;

   public QuickUnionUF(int N)
   {
      parent = new int[N];
      count = N;
      for(int i=0; i<N; i++)
         parent[i] = i;
   }

   private int root(int i)
   {
      validate(i);
      while( i != parent[i] ) {i=parent[i];}
      return i;
   }

   public int count(){
      return count;
   }

   private void validate(int p) {
      int N = parent.length;
      if(p< 0 || p >= N){
         throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
        }
    }
 
   public boolean connected(int p, int q)
   { return root(p) == root(q); }

   public void union(int p, int q)
   {
      int i = root(p);
      int j = root(q);
      if( i == j ) return;
      parent[i] = j;
      count--;
   }

   public static void main(String[] args) 
   {

       In in = new In(args[0]);
       int [] array1 = in.readAllInts();
       int N = array1[0];
       QuickUnionUF uf = new QuickUnionUF(N);

       int M = array1.length;
       for(int i=0; i<M/2; i++){
          int p = array1[i*2+1];
          int q = array1[i*2+2];
          if(!uf.connected(p,q))
          {  uf.union(p,q);
             StdOut.println(p + " " + q);
          }
       } 
       StdOut.println(uf.count() + " components");

   }

}
 
