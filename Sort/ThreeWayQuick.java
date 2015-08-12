public class ThreeWayQuick
{

  private static void sort(Comparable[] a, int lo, int hi)
  {
     if (hi <= lo) return;
     int lt = lo, gt = hi;
     Comparable v = a[lo];
     int i = lo;
     while (i <= gt)
     {
        int cmp = a[i].compareTo(v);
        if      (cmp < 0) exch(a, lt++, i++);
        else if (cmp > 0) exch(a, i, gt--);
        else              i++;
     }

     sort(a, lo, lt - 1);
     sort(a, gt + 1, hi);

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
     ThreeWayQuick.sort(a,0,N-1);
     for (int i=0; i<N; i++)
        StdOut.println(a[i]);
  }

}
