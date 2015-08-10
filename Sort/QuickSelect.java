public class QuickSelect
{

   private static int partition(Comparable[] a, int lo, int hi)
   {
      int i = lo, j = hi+1;
      while(true)
      {
        while (less(a[++i], a[lo]))
           if (i == hi) break;

        while (less(a[lo], a[--j]))
           if (j == lo) break;

        if (i >= j) break;
        exch(a, i, j);
      }

      exch(a, lo, j);
      return j;
   }

   public static Comparable select(Comparable[] a, int k)
   {
     StdRandom.shuffle(a);
     int lo = 0, hi = a.length-1;
     while (hi > lo)
     {
       int j = partition(a, lo, hi);
       if      (j < k) lo = j+1;
       else if (j > k) hi = j-1;
       else            return a[k];
     }
     return a[k];
   }

  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }


  public static void main(String[] args)
  {
     int N = Integer.parseInt("10");
     int ii = StdIn.readInt();
     Double[] a = new Double[N];

     for (int i = 0; i<N; i++)
        a[i] = StdRandom.uniform();
     Comparable x = QuickSelect.select(a,ii-1);

     StdOut.println("Array:");
     for (int i=0; i<N; i++)
        StdOut.println(a[i]);
     StdOut.println("a[" + ii +  "]= " + x);
  }

}
