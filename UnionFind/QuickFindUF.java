import java.util.Arrays;

public class QuickFindUF
{

   private int[] id;
   private int count;

   public QuickFindUF(int N)
   {
      id = new int[N];
      count = N;
      for(int i=0; i<N; i++)
         id[i] = i;
   }

   public int count(){
      return count;
   }

   public boolean connected(int p, int q)
   { return id[p] == id[q]; }

   public void union(int p, int q)
   {
      int pid = id[p];
      int qid = id[q];
      for(int i=0; i<id.length; i++)
         if( id[i] == pid ) id[i] = qid;
      count--;
   }

   public static void main(String[] args) 
   {

       In in = new In(args[0]);
       int [] array1 = in.readAllInts();
       int N = array1[0];
       QuickFindUF uf = new QuickFindUF(N);

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
 
