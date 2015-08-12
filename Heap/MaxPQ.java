public class MaxPQ<Key extends Comparable<Key>>
{
   private Key[] pq;
   private int N;

   public MaxPQ(int capacity)
   { pq = (Key[]) new Comparable[capacity+1]; }

   public boolean isEmpty()
   { return N == 0; }

   public void insert(Key x)
   {
      pq[++N] = x;
      swim(N);
   }

   private void sink(int k)
   {
     while (2*k <= N)
     {
        int j = 2*k;
        if (j <  N && less(a[j], a[j+1])) j++;
        if (!less(a[k],a[j])) break;
        exch(a,k,j);
        k = j;
     }
   }

  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private void swim(int k)
  {
     while (k > 1 && less(k/2,k) )
     {
        exch(k, k/2);
        k = k/2;
     }
  }

}
