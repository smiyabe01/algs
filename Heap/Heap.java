import java.util.Random;
public class Heap
{
   private Heap() {}

   public static void sort(Comparable[] a)
   {
      int N = a.length;
      for (int k=N/2; k>=1; k--)
          sink(a,k,N);
      while (N>1){
          exch(a,1,N--);
          sink(a,1,N);
      }
   }

   private static void sink(Comparable[] a, int k, int N){
      while (2*k <= N) {
          int j = 2*k;
          if (j < N && less(a,j,j+1)) j++;
          if (!less(a,k,j)) break;
          exch(a,k,j);
          k = j;
      }
   }

   private static boolean less(Comparable[] a, int i, int j)
   {  return a[i-1].compareTo(a[j-1]) < 0; }

   private static void exch(Object[] a, int i, int j){
      Object swap = a[i-1];
      a[i-1] = a[j-1];
      a[j-1] = swap;
   }

   private static void show(Comparable[] a){
      for(int i=0; i<a.length; i++) StdOut.println(a[i]);
   }

   public static void main(String[] args)
   {
      int N = StdIn.readInt();
      Random rg = new Random();
      Comparable[] a = new Comparable[N];
      for(int i=0; i<N; i++) a[i] = rg.nextInt(N);

      Heap.sort(a);
      show(a);
   }
}
