public class Quick
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

  public static void sort(Comparable[] a)
  {
     StdRandom.shuffle(a);
     sort(a, 0, a.length-1);
  }

  private static void sort(Comparable[] a, int lo, int hi)
  {
     if (hi <= lo) return;
     int j = partition(a, lo, hi);
     sort(a, lo, j-1);
     sort(a, j+1, hi);
  }

  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean isSorted(Comparable[] a){
    return isSorted(a, 0, a.length-1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi){
    for (int i=lo+1; i <= hi; i++)
       if (less(a[i],a[i-1])) return false;
    return true;
  }

  public static void main(String[] args)
  {
//     int N = Integer.parseInt(args[0]);
     int N = Integer.parseInt("10");
     Double[] a = new Double[N];
     for (int i = 0; i<N; i++)
        a[i] = StdRandom.uniform();
     Quick.sort(a);
     for (int i=0; i<N; i++)
        StdOut.println(a[i]);
  }

}
